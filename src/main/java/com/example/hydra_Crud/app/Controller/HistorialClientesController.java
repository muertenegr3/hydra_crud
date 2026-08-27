package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.HistorialClientes;
import com.example.hydra_Crud.app.Repository.HistorialClientesRepository;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin("*")
public class HistorialClientesController {

    @Autowired
    private HistorialClientesRepository repository;

    @GetMapping
    public List<HistorialClientes> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialClientes> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialClientes> guardar(@RequestBody HistorialClientes entity) {
        HistorialClientes nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialClientes> actualizar(@PathVariable Integer id, @RequestBody HistorialClientes entity) {
        return repository.findById(id)
                .map(h -> {
                    entity.setIdHistorial(id);
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
