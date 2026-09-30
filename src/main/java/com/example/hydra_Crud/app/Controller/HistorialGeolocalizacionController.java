package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.HistorialGeolocalizacion;
import com.example.hydra_Crud.app.Repository.HistorialGeolocalizacionRepository;

@RestController
@RequestMapping("/api/historial-geo")
@CrossOrigin("*")
public class HistorialGeolocalizacionController {

    @Autowired
    private HistorialGeolocalizacionRepository repository;

    @GetMapping
    public List<HistorialGeolocalizacion> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialGeolocalizacion> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialGeolocalizacion> guardar(@RequestBody HistorialGeolocalizacion entity) {
        HistorialGeolocalizacion nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
