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

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin("*")
public class MensajeController {

    @Autowired
    private MensajeRepository repository;

    /**
     * Crear mensaje. El INSERT dispara postgres_changes en Supabase Realtime,
     * el bridge lo reenvia por SSE a todos los clientes conectados.
     * Body (JSON): remitenteRun, rolOrigen, destinatarioRun, rolDestino,
     *              contenido, adjuntoUrl?, adjuntoNombre?
     */
    @PostMapping
    public ResponseEntity<Mensaje> crear(@RequestBody Mensaje mensaje) {
        mensaje.setId(null);
        mensaje.setLeido(false);
        mensaje.setLeidoEn(null);
        mensaje.setCreadoEn(LocalDateTime.now());
        Mensaje nuevo = repository.save(mensaje);
        return ResponseEntity.status(201).body(nuevo);
    }

    /** Historial de una conversacion 1:1: ?runA=..&runB=.. */
    @GetMapping("/conversacion")
    public ResponseEntity<List<Mensaje>> conversacion(@RequestParam String runA,
                                                      @RequestParam String runB) {
        List<Mensaje> historial = repository.conversacion(runA, runB);
        return ResponseEntity.ok(historial);
    }

    /** Badge de notificaciones: ?destinoRun=..&rolDestino=cuidador|medico */
    @GetMapping("/no-leidos")
    public List<Mensaje> noLeidos(@RequestParam String destinoRun,
                                  @RequestParam String rolDestino) {
        return repository.noLeidos(destinoRun, rolDestino);
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