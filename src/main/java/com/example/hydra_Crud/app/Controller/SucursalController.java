package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Sucursal;
import com.example.hydra_Crud.app.Repository.SucursalRepository;

@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin("*")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping
    public List<Sucursal> obtenerSucursales() {
        return sucursalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable Integer id) {
        return sucursalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sucursal> guardar(@RequestBody Sucursal sucursal) {
        Sucursal nuevo = sucursalRepository.save(sucursal);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        return sucursalRepository.findById(id)
                .map(s -> {
                    sucursal.setIdSucursal(id);
                    return ResponseEntity.ok(sucursalRepository.save(sucursal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!sucursalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sucursalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
