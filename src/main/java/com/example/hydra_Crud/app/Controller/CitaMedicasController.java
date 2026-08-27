package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.CitaMedicas;
import com.example.hydra_Crud.app.Repository.CitaMedicasRepository;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin("*")
public class CitaMedicasController {

    @Autowired
    private CitaMedicasRepository repository;

    @GetMapping
    public List<CitaMedicas> obtenerTodas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaMedicas> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CitaMedicas> guardar(@RequestBody CitaMedicas entity) {
        CitaMedicas nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaMedicas> actualizar(@PathVariable Integer id, @RequestBody CitaMedicas entity) {
        return repository.findById(id)
                .map(c -> {
                    entity.setIdCita(id);
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
