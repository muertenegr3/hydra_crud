package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Region;
import com.example.hydra_Crud.app.Repository.RegionRepository;

@RestController
@RequestMapping("/api/regiones")
@CrossOrigin("*")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public List<Region> obtenerRegiones() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> obtenerRegion(@PathVariable Integer id) {
        return regionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Region> guardar(@RequestBody Region region) {
        Region nuevo = regionRepository.save(region);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> actualizar(@PathVariable Integer id, @RequestBody Region region) {
        return regionRepository.findById(id)
                .map(r -> {
                    region.setIdRegion(id);
                    return ResponseEntity.ok(regionRepository.save(region));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!regionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        regionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
