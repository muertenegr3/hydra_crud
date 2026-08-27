package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "clinicas")
public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {
}
