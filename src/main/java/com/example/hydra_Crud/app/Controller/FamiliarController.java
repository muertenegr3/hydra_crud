package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Familiar;
import com.example.hydra_Crud.app.Entity.FamiliarPaciente;
import com.example.hydra_Crud.app.Entity.FamiliarPacienteId;
import com.example.hydra_Crud.app.Entity.Paciente;
import com.example.hydra_Crud.app.Repository.FamiliarPacienteRepository;
import com.example.hydra_Crud.app.Repository.FamiliarRepository;
import com.example.hydra_Crud.app.Repository.PacienteRepository;

@RestController
@RequestMapping("/api/familiares")
@CrossOrigin("*")
public class FamiliarController {

    @Autowired
    private FamiliarRepository familiarRepository;

    @Autowired
    private FamiliarPacienteRepository familiarPacienteRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

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

    // VINCULAR un familiar (ya existente) a un paciente (ya existente)
    @PostMapping("/{familiarRun}/pacientes/{pacienteRun}")
    public ResponseEntity<?> vincularFamiliar(
            @PathVariable String familiarRun,
            @PathVariable String pacienteRun) {

        String famRun = familiarRun.toLowerCase().trim();
        String patRun = pacienteRun.toLowerCase().trim();

        if (!familiarRepository.existsById(famRun)) {
            return ResponseEntity.notFound().build();
        }
        if (!pacienteRepository.existsById(patRun)) {
            return ResponseEntity.badRequest().body("Paciente no encontrado");
        }

        FamiliarPacienteId id = new FamiliarPacienteId(patRun, famRun);
        if (familiarPacienteRepository.existsById(id)) {
            return ResponseEntity.status(409).body("El vínculo ya existe");
        }

        FamiliarPaciente fp = new FamiliarPaciente();
        fp.setPacientesRunP(patRun);
        fp.setFamiliaresRun(famRun);
        familiarPacienteRepository.save(fp);
        return ResponseEntity.ok().build();
    }

    // DESVINCULAR un familiar de un paciente
    @DeleteMapping("/{familiarRun}/pacientes/{pacienteRun}")
    public ResponseEntity<Void> desvincularFamiliar(
            @PathVariable String familiarRun,
            @PathVariable String pacienteRun) {

        familiarPacienteRepository.deleteById(
                new FamiliarPacienteId(pacienteRun.toLowerCase().trim(), familiarRun.toLowerCase().trim()));
        return ResponseEntity.noContent().build();
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
