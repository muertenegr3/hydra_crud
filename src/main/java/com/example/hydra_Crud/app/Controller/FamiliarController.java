package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Familiar;
import com.example.hydra_Crud.app.Entity.Paciente;
import com.example.hydra_Crud.app.Repository.FamiliarRepository;

@RestController
@RequestMapping("/api/familiares")
@CrossOrigin("*")
public class FamiliarController {

    @Autowired
    private FamiliarRepository familiarRepository;

    // GET ALL
    @GetMapping
    public List<Familiar> obtenerFamiliares() {
        return familiarRepository.findAll();
    }

    // GET POR RUN
    @GetMapping("/{run}")
    public ResponseEntity<Familiar> obtenerFamiliar(@PathVariable String run) {
        return familiarRepository.findById(run)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET PACIENTES DE UN FAMILIAR
    @GetMapping("/{run}/pacientes")
    public List<Paciente> obtenerPacientesDeFamiliar(@PathVariable String run) {
        return familiarRepository.findPacientesByFamiliarRun(run);
    }

    @PostMapping
    public ResponseEntity<Familiar> guardar(@RequestBody Familiar familiar) {
        Familiar nuevo = familiarRepository.save(familiar);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{run}")
    public ResponseEntity<Familiar> actualizarFamiliar(@PathVariable String run, @RequestBody Familiar familiar) {
        return familiarRepository.findById(run)
                .map(f -> {
                    familiar.setRun(run);
                    Familiar actualizado = familiarRepository.save(familiar);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminarFamiliar(@PathVariable String run) {
        if (!familiarRepository.existsById(run)) {  
            return ResponseEntity.notFound().build();
        }
        familiarRepository.deleteById(run);
        return ResponseEntity.noContent().build();
    }
}
