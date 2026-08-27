package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.CitaMedicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "citas")
public interface CitaMedicasRepository extends JpaRepository<CitaMedicas, Integer> {
}
