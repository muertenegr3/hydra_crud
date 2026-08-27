package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.TipoProtesis;
import com.example.hydra_Crud.app.Repository.TipoProtesisRepository;

@RestController
@RequestMapping("/api/tipos-protesis")
@CrossOrigin("*")
public class TipoProtesisController {

    @Autowired
    private TipoProtesisRepository repository;

    @GetMapping
    public List<TipoProtesis> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProtesis> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoProtesis> guardar(@RequestBody TipoProtesis entity) {
        TipoProtesis nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProtesis> actualizar(@PathVariable Integer id, @RequestBody TipoProtesis entity) {
        return repository.findById(id)
                .map(t -> {
                    entity.setIdTipo(id);
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
