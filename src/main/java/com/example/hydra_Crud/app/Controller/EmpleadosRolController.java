package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.EmpleadosRol;
import com.example.hydra_Crud.app.Entity.EmpleadosRolId;
import com.example.hydra_Crud.app.Repository.EmpleadosRolRepository;

@RestController
@RequestMapping("/api/empleados-rol")
@CrossOrigin("*")
public class EmpleadosRolController {

    @Autowired
    private EmpleadosRolRepository repository;

    @GetMapping
    public List<EmpleadosRol> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<EmpleadosRol> guardar(@RequestBody EmpleadosRol entity) {
        EmpleadosRol nuevo = repository.save(entity);
        return ResponseEntity.status(201).body(nuevo);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestBody EmpleadosRolId id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
