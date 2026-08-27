package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.EstadoExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "estados-examen")
public interface EstadoExamenRepository extends JpaRepository<EstadoExamen, Integer> {
}
