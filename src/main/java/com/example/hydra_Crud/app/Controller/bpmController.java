package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Bpm;
import com.example.hydra_Crud.app.Entity.HistorialBpm;
import com.example.hydra_Crud.app.Repository.BpmRepository;
import com.example.hydra_Crud.app.Repository.HistorialBpmRepository;

@RestController
@RequestMapping("/api/bpm")
@CrossOrigin("*")
public class bpmController {

    @Autowired
    private BpmRepository bpmRepository;

    @Autowired
    private HistorialBpmRepository historialBpmRepository;

    /** Snapshot del BPM actual de un paciente. El run llega CIFRADO (igual que la columna). */
    @GetMapping("/{runP:.+}")
    public ResponseEntity<Bpm> obtenerBpmActual(@PathVariable String runP) {
        return bpmRepository.findById(runP.toLowerCase().trim())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** Historial de BPM de un paciente, mas reciente primero. */
    @GetMapping("/{runP:.+}/historial")
    public ResponseEntity<List<HistorialBpm>> obtenerHistorial(
            @PathVariable String runP,
            @RequestParam(defaultValue = "100") int limite) {
        int max = Math.max(1, Math.min(limite, 500));
        List<HistorialBpm> todos = historialBpmRepository
                .findTop500ByRunPOrderByFechaDesc(runP.toLowerCase().trim());
        return ResponseEntity.ok(todos.stream().limit(max).toList());
    }
}
