package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Recetas;
import com.example.hydra_Crud.app.Repository.RecetasRepository;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin("*")
public class RecetasController {

    @Autowired
    private RecetasRepository repository;

    @GetMapping
    public List<Recetas> obtenerTodas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recetas> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recetas> guardar(@RequestBody Recetas entity) {
        Recetas nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recetas> actualizar(@PathVariable Integer id, @RequestBody Recetas entity) {
        return repository.findById(id)
                .map(r -> {
                    entity.setIdRecetas(id);
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
