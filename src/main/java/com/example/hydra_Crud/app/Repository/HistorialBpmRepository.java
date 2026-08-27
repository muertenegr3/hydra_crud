package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.HistorialBpm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "historial-bpm")
public interface HistorialBpmRepository extends JpaRepository<HistorialBpm, Long> {
}
