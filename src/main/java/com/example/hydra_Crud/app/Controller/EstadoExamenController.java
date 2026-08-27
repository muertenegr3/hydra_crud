package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.EstadoExamen;
import com.example.hydra_Crud.app.Repository.EstadoExamenRepository;

@RestController
@RequestMapping("/api/estados-examen")
@CrossOrigin("*")
public class EstadoExamenController {

    @Autowired
    private EstadoExamenRepository repository;

    @GetMapping
    public List<EstadoExamen> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoExamen> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoExamen> guardar(@RequestBody EstadoExamen entity) {
        EstadoExamen nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoExamen> actualizar(@PathVariable Integer id, @RequestBody EstadoExamen entity) {
        return repository.findById(id)
                .map(e -> {
                    entity.setIdEstado(id);
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
