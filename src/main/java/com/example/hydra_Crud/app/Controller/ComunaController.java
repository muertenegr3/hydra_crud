package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Comuna;
import com.example.hydra_Crud.app.Repository.ComunaRepository;

@RestController
@RequestMapping("/api/comunas")
@CrossOrigin("*")
public class ComunaController {

    @Autowired
    private ComunaRepository comunaRepository;

    @GetMapping
    public List<Comuna> obtenerComunas() {
        return comunaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> obtenerComuna(@PathVariable Integer id) {
        return comunaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comuna> guardar(@RequestBody Comuna comuna) {
        Comuna nuevo = comunaRepository.save(comuna);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizar(@PathVariable Integer id, @RequestBody Comuna comuna) {
        return comunaRepository.findById(id)
                .map(c -> {
                    comuna.setIdComuna(id);
                    return ResponseEntity.ok(comunaRepository.save(comuna));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!comunaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        comunaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
