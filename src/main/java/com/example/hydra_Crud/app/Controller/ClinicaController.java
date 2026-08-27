package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Clinica;
import com.example.hydra_Crud.app.Repository.ClinicaRepository;

@RestController
@RequestMapping("/api/clinicas")
@CrossOrigin("*")
public class ClinicaController {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @GetMapping
    public List<Clinica> obtenerClinicas() {
        return clinicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinica> obtenerClinica(@PathVariable Integer id) {
        return clinicaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clinica> guardar(@RequestBody Clinica clinica) {
        Clinica nuevo = clinicaRepository.save(clinica);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clinica> actualizar(@PathVariable Integer id, @RequestBody Clinica clinica) {
        return clinicaRepository.findById(id)
                .map(c -> {
                    clinica.setIdClinica(id);
                    return ResponseEntity.ok(clinicaRepository.save(clinica));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!clinicaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clinicaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
