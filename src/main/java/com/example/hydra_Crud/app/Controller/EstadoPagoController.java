package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.EstadoPago;
import com.example.hydra_Crud.app.Repository.EstadoPagoRepository;

@RestController
@RequestMapping("/api/estados-pago")
@CrossOrigin("*")
public class EstadoPagoController {

    @Autowired
    private EstadoPagoRepository repository;

    @GetMapping
    public List<EstadoPago> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPago> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoPago> guardar(@RequestBody EstadoPago entity) {
        EstadoPago nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPago> actualizar(@PathVariable Integer id, @RequestBody EstadoPago entity) {
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
