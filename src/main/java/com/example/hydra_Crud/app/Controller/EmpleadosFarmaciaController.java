package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.EmpleadosFarmacia;
import com.example.hydra_Crud.app.Repository.EmpleadosFarmaciaRepository;

@RestController
@RequestMapping("/api/empleados-farmacia")
@CrossOrigin("*")
public class EmpleadosFarmaciaController {

    @Autowired
    private EmpleadosFarmaciaRepository repository;

    @GetMapping
    public List<EmpleadosFarmacia> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{run}")
    public ResponseEntity<EmpleadosFarmacia> obtenerPorRun(@PathVariable String run) {
        return repository.findById(run)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpleadosFarmacia> guardar(@RequestBody EmpleadosFarmacia entity) {
        EmpleadosFarmacia nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{run}")
    public ResponseEntity<EmpleadosFarmacia> actualizar(@PathVariable String run, @RequestBody EmpleadosFarmacia entity) {
        return repository.findById(run)
                .map(e -> {
                    entity.setRunEf(run);
                    return ResponseEntity.ok(repository.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminar(@PathVariable String run) {
        if (!repository.existsById(run)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(run);
        return ResponseEntity.noContent().build();
    }
}
