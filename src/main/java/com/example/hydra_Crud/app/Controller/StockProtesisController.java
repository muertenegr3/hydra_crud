package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.StockProtesis;
import com.example.hydra_Crud.app.Repository.StockProtesisRepository;

@RestController
@RequestMapping("/api/stock-protesis")
@CrossOrigin("*")
public class StockProtesisController {

    @Autowired
    private StockProtesisRepository repository;

    @GetMapping
    public List<StockProtesis> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockProtesis> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockProtesis> guardar(@RequestBody StockProtesis entity) {
        StockProtesis nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockProtesis> actualizar(@PathVariable Integer id, @RequestBody StockProtesis entity) {
        return repository.findById(id)
                .map(s -> {
                    entity.setIdItem(id);
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
