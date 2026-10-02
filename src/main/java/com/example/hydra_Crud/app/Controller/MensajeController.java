package com.example.hydra_Crud.app.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Mensaje;
import com.example.hydra_Crud.app.Repository.MensajeRepository;
import com.example.hydra_Crud.app.Utils.HashUtils;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin("*")
public class MensajeController {

    @Autowired
    private MensajeRepository repository;

    /**
     * Crear mensaje. El INSERT dispara postgres_changes en Supabase Realtime,
     * el bridge lo reenvia por SSE a todos los clientes conectados.
     *
     * Body (JSON): remitenteRun, rolOrigen, destinatarioRun, rolDestino,
     *              contenido?, adjuntoUrl?, adjuntoNombre?
     *
     * El cliente envia el RUN en texto plano por HTTPS. Aqui se reemplaza por su
     * SHA-256 antes de tocar la base, de modo que el RUN nunca queda almacenado
     * y las consultas pueden filtrar por equality (el hash es determinista).
     * La respuesta NO incluye el RUN ni su hash (WRITE_ONLY en la entidad).
     */
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Mensaje mensaje) {
        if (mensaje.getRemitenteRun() == null || mensaje.getRemitenteRun().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Falta remitenteRun"));
        }
        if (mensaje.getDestinatarioRun() == null || mensaje.getDestinatarioRun().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Falta destinatarioRun"));
        }
        boolean sinTexto = mensaje.getContenido() == null || mensaje.getContenido().isBlank();
        boolean sinFoto = mensaje.getAdjuntoUrl() == null || mensaje.getAdjuntoUrl().isBlank();
        if (sinTexto && sinFoto) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "El mensaje debe tener texto o una foto adjunta"));
        }

        String remitentePlano = mensaje.getRemitenteRun();
        String destinatarioPlano = mensaje.getDestinatarioRun();

        mensaje.setRemitenteRun(HashUtils.HASHEO(remitentePlano));
        mensaje.setDestinatarioRun(HashUtils.HASHEO(destinatarioPlano));

        mensaje.setId(null);
        mensaje.setLeido(false);
        mensaje.setLeidoEn(null);
        mensaje.setCreadoEn(LocalDateTime.now());
        Mensaje nuevo = repository.save(mensaje);
        return ResponseEntity.status(201).body(nuevo);
    }

    /** Historial de una conversacion 1:1: ?runA=..&runB=.. (RUN en texto plano). */
    @GetMapping("/conversacion")
    public ResponseEntity<List<Mensaje>> conversacion(@RequestParam String runA,
                                                      @RequestParam String runB) {
        List<Mensaje> historial = repository.conversacion(
                HashUtils.HASHEO(runA), HashUtils.HASHEO(runB));
        return ResponseEntity.ok(historial);
    }

    /** Badge de notificaciones: ?destinoRun=..&rolDestino=cuidador|medico (RUN en texto plano). */
    @GetMapping("/no-leidos")
    public ResponseEntity<?> noLeidos(@RequestParam String destinoRun,
                                      @RequestParam String rolDestino) {
        if (destinoRun == null || destinoRun.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Falta destinoRun"));
        }
        return ResponseEntity.ok(repository.noLeidos(HashUtils.HASHEO(destinoRun), rolDestino));
    }

    /** Marca un mensaje como leido: PATCH /api/mensajes/{id}/leer */
    @PatchMapping("/{id}/leer")
    @Transactional
    public ResponseEntity<Map<String, String>> marcarLeido(@PathVariable Long id) {
        int marcados = repository.marcarLeido(id, LocalDateTime.now());
        if (marcados == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Map.of("mensaje", "mensaje marcado como leido", "id", String.valueOf(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
