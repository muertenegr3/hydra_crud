package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.MetodoPago;
import com.example.hydra_Crud.app.Repository.MetodoPagoRepository;

@RestController
@RequestMapping("/api/metodos-pago")
@CrossOrigin("*")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoRepository repository;

    @GetMapping
    public List<MetodoPago> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MetodoPago> guardar(@RequestBody MetodoPago entity) {
        MetodoPago nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizar(@PathVariable Integer id, @RequestBody MetodoPago entity) {
        return repository.findById(id)
                .map(m -> {
                    entity.setIdMetodo(id);
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
