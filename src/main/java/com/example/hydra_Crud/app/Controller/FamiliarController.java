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

    @GetMapping
    public List<Familiar> obtenerFamiliares() {
        return familiarRepository.findAll();
    }

    @GetMapping("/{run}")
    public ResponseEntity<Familiar> obtenerFamiliar(@PathVariable String run) {
        return familiarRepository.findById(run)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{run}/pacientes")
    public List<Paciente> obtenerPacientesDeFamiliar(@PathVariable String run) {
        return familiarRepository.findPacientesByFamiliarRun(run);
    }
}
