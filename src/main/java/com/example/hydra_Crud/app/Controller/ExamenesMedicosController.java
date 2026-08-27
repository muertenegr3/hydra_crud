package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.ExamenesMedicos;
import com.example.hydra_Crud.app.Repository.ExamenesMedicosRepository;

@RestController
@RequestMapping("/api/examenes")
@CrossOrigin("*")
public class ExamenesMedicosController {

    @Autowired
    private ExamenesMedicosRepository repository;

    @GetMapping
    public List<ExamenesMedicos> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenesMedicos> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExamenesMedicos> guardar(@RequestBody ExamenesMedicos entity) {
        ExamenesMedicos nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenesMedicos> actualizar(@PathVariable Integer id, @RequestBody ExamenesMedicos entity) {
        return repository.findById(id)
                .map(e -> {
                    entity.setIdExamen(id);
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
