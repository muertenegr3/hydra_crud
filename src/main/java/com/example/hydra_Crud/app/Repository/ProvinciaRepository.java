package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "provincias")
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
}
