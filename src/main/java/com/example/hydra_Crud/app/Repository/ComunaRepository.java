package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "comunas")
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}
