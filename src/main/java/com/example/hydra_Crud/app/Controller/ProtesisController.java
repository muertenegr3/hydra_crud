package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Protesis;
import com.example.hydra_Crud.app.Repository.ProtesisRepository;

@RestController
@RequestMapping("/api/protesis")
@CrossOrigin("*")
public class ProtesisController {

    @Autowired
    private ProtesisRepository repository;

    @GetMapping
    public List<Protesis> obtenerTodas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protesis> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Protesis> guardar(@RequestBody Protesis entity) {
        Protesis nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Protesis> actualizar(@PathVariable Integer id, @RequestBody Protesis entity) {
        return repository.findById(id)
                .map(p -> {
                    entity.setSolicitudIdSolicitud(id);
                    return ResponseEntity.ok(repository.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
