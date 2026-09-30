package com.example.hydra_Crud.app.Service;

import com.example.hydra_Crud.app.Entity.HistorialBpm;
import com.example.hydra_Crud.app.Entity.HistorialGeolocalizacion;
import com.example.hydra_Crud.app.Repository.HistorialBpmRepository;
import com.example.hydra_Crud.app.Repository.HistorialGeolocalizacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CleanupService {

    private static final Logger log = LoggerFactory.getLogger(CleanupService.class);
    private static final int DIAS_RETENCION = 30;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("${supabase.s3.endpoint}") private String endpoint;
    @Value("${supabase.s3.region}") private String region;
    @Value("${supabase.s3.access-key}") private String accessKey;
    @Value("${supabase.s3.secret-key}") private String secretKey;
    @Value("${supabase.bucket}") private String bucket;

    @Autowired private HistorialBpmRepository historialBpmRepo;
    @Autowired private HistorialGeolocalizacionRepository historialGeoRepo;

    private S3Client getS3Client() {
        return S3Client.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .forcePathStyle(true)
                .build();
    }

    @Scheduled(cron = "0 0 23 * * *")
    public void ejecutarLimpiezaDiaria() {
        log.info("=== Iniciando limpieza diaria de historiales ===");
        LocalDateTime fechaCorte = LocalDateTime.now().minusDays(DIAS_RETENCION);
        String fechaArchivo = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        try {
            archivarBpm(fechaCorte, fechaArchivo);
        } catch (Exception e) {
            log.error("Error archivando BPM: {}", e.getMessage(), e);
        }

        try {
            archivarGeolocalizacion(fechaCorte, fechaArchivo);
        } catch (Exception e) {
            log.error("Error archivando geolocalizacion: {}", e.getMessage(), e);
        }

        log.info("=== Limpieza diaria completada ===");
    }

    private void archivarBpm(LocalDateTime fechaCorte, String fechaArchivo) {
        List<HistorialBpm> registros = historialBpmRepo.findByFechaBefore(fechaCorte);
        if (registros.isEmpty()) {
            log.info("No hay registros BPM anteriores a {}", fechaCorte);
            return;
        }

        log.info("Encontrados {} registros BPM para archivar", registros.size());

        Map<String, List<HistorialBpm>> porPaciente = registros.stream()
                .filter(r -> r.getRunP() != null)
                .collect(Collectors.groupingBy(HistorialBpm::getRunP));

        try (S3Client s3 = getS3Client()) {
            for (Map.Entry<String, List<HistorialBpm>> entry : porPaciente.entrySet()) {
                String runP = entry.getKey();
                List<HistorialBpm> datos = entry.getValue();

                ObjectNode root = mapper.createObjectNode();
                root.put("runPacienteCifrado", runP);
                root.put("tipo", "historial_bpm");
                root.put("fechaExportacion", fechaArchivo);
                root.put("registrosOriginales", datos.size());

                ArrayNode arr = root.putArray("registros");
                for (HistorialBpm h : datos) {
                    ObjectNode nodo = arr.addObject();
                    nodo.put("valor_bpm", h.getValorBpm());
                    nodo.put("spo2", h.getSpo2());
                    nodo.put("fecha", h.getFecha() != null ? h.getFecha().toString() : null);
                }

                String path = "historiales/bpm/" + runP + "/bpm_" + fechaArchivo + ".json";
                s3.putObject(
                        PutObjectRequest.builder().bucket(bucket).key(path)
                                .contentType("application/json").build(),
                        RequestBody.fromBytes(mapper.writeValueAsBytes(root)));
                log.info("BPM archivado: {} ({} registros)", path, datos.size());
            }
        } catch (Exception e) {
            log.error("Error subiendo BPM a S3, se conservan los registros: {}", e.getMessage(), e);
            return;
        }

        historialBpmRepo.deleteByFechaBefore(fechaCorte);
        log.info("Registros BPM antiguos eliminados de la base de datos");
    }

    private void archivarGeolocalizacion(LocalDateTime fechaCorte, String fechaArchivo) {
        List<HistorialGeolocalizacion> registros = historialGeoRepo.findByFechaBefore(fechaCorte);
        if (registros.isEmpty()) {
            log.info("No hay registros geolocalizacion anteriores a {}", fechaCorte);
            return;
        }

        log.info("Encontrados {} registros geolocalizacion para archivar", registros.size());

        Map<String, List<HistorialGeolocalizacion>> porPaciente = registros.stream()
                .filter(r -> r.getRunP() != null)
                .collect(Collectors.groupingBy(HistorialGeolocalizacion::getRunP));

        try (S3Client s3 = getS3Client()) {
            for (Map.Entry<String, List<HistorialGeolocalizacion>> entry : porPaciente.entrySet()) {
                String runP = entry.getKey();
                List<HistorialGeolocalizacion> datos = entry.getValue();

                ObjectNode root = mapper.createObjectNode();
                root.put("runPacienteCifrado", runP);
                root.put("tipo", "historial_geolocalizacion");
                root.put("fechaExportacion", fechaArchivo);
                root.put("registrosOriginales", datos.size());

                ArrayNode arr = root.putArray("registros");
                for (HistorialGeolocalizacion h : datos) {
                    ObjectNode nodo = arr.addObject();
                    nodo.put("fecha", h.getFecha() != null ? h.getFecha().toString() : null);
                    nodo.put("hora", h.getHora() != null ? h.getHora().toString() : null);
                    nodo.put("latitud", h.getLatitud());
                    nodo.put("longitud", h.getLongitud());
                }

                String path = "historiales/geo/" + runP + "/geo_" + fechaArchivo + ".json";
                s3.putObject(
                        PutObjectRequest.builder().bucket(bucket).key(path)
                                .contentType("application/json").build(),
                        RequestBody.fromBytes(mapper.writeValueAsBytes(root)));
                log.info("Geo archivado: {} ({} registros)", path, datos.size());
            }
        } catch (Exception e) {
            log.error("Error subiendo geolocalizacion a S3, se conservan los registros: {}", e.getMessage(), e);
            return;
        }

        historialGeoRepo.deleteByFechaBefore(fechaCorte);
        log.info("Registros geolocalizacion antiguos eliminados de la base de datos");
    }
}
