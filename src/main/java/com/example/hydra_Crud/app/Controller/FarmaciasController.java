package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Farmacias;
import com.example.hydra_Crud.app.Repository.FarmaciasRepository;

@RestController
@RequestMapping("/api/farmacias")
@CrossOrigin("*")
public class FarmaciasController {

    @Autowired
    private FarmaciasRepository farmaciasRepository;

    @GetMapping
    public List<Farmacias> obtenerFarmacias() {
        return farmaciasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmacias> obtenerFarmacia(@PathVariable Integer id) {
        return farmaciasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Farmacias> guardar(@RequestBody Farmacias farmacia) {
        Farmacias nuevo = farmaciasRepository.save(farmacia);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmacias> actualizar(@PathVariable Integer id, @RequestBody Farmacias farmacia) {
        return farmaciasRepository.findById(id)
                .map(f -> {
                    farmacia.setIdFarmacias(id);
                    return ResponseEntity.ok(farmaciasRepository.save(farmacia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!farmaciasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        farmaciasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
