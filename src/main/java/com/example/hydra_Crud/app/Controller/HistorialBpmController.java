package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.HistorialBpm;
import com.example.hydra_Crud.app.Repository.HistorialBpmRepository;

@RestController
@RequestMapping("/api/historial-bpm")
@CrossOrigin("*")
public class HistorialBpmController {

    @Autowired
    private HistorialBpmRepository repository;

    @GetMapping
    public List<HistorialBpm> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialBpm> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialBpm> guardar(@RequestBody HistorialBpm entity) {
        HistorialBpm nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
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
