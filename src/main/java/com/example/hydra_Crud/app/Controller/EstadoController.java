package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Estado;
import com.example.hydra_Crud.app.Repository.EstadoRepository;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin("*")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> obtenerEstados() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerEstado(@PathVariable Integer id) {
        return estadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> guardar(@RequestBody Estado estado) {
        Estado nuevo = estadoRepository.save(estado);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizar(@PathVariable Integer id, @RequestBody Estado estado) {
        return estadoRepository.findById(id)
                .map(e -> {
                    estado.setIdEstado(id);
                    return ResponseEntity.ok(estadoRepository.save(estado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!estadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
