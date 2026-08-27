package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.HistorialClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "historial")
public interface HistorialClientesRepository extends JpaRepository<HistorialClientes, Integer> {
}
