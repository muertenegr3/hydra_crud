package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Geolocalizacion;
import com.example.hydra_Crud.app.Repository.GeolocalizacionRepository;

@RestController
@RequestMapping("/api/geolocalizacion")
@CrossOrigin("*")
public class GeolocalizacionController {

    @Autowired
    private GeolocalizacionRepository repository;

    @GetMapping
    public List<Geolocalizacion> obtenerTodas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Geolocalizacion> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Geolocalizacion> guardar(@RequestBody Geolocalizacion entity) {
        Geolocalizacion nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Geolocalizacion> actualizar(@PathVariable Long id, @RequestBody Geolocalizacion entity) {
        return repository.findById(id)
                .map(g -> {
                    entity.setIdGeolocalizacion(id);
                    return ResponseEntity.ok(repository.save(entity));
                })
                .orElse(ResponseEntity.notFound().build());
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
