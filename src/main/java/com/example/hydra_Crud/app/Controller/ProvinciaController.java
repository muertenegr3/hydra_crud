package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Provincia;
import com.example.hydra_Crud.app.Repository.ProvinciaRepository;

@RestController
@RequestMapping("/api/provincias")
@CrossOrigin("*")
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @GetMapping
    public List<Provincia> obtenerProvincias() {
        return provinciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> obtenerProvincia(@PathVariable Integer id) {
        return provinciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Provincia> guardar(@RequestBody Provincia provincia) {
        Provincia nuevo = provinciaRepository.save(provincia);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provincia> actualizar(@PathVariable Integer id, @RequestBody Provincia provincia) {
        return provinciaRepository.findById(id)
                .map(p -> {
                    provincia.setIdProvincia(id);
                    return ResponseEntity.ok(provinciaRepository.save(provincia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!provinciaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        provinciaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
