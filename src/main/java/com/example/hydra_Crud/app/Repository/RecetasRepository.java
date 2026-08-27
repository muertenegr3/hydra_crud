package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "recetas")
public interface RecetasRepository extends JpaRepository<Recetas, Integer> {
}
