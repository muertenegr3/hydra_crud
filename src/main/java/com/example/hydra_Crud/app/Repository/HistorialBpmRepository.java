package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.HistorialBpm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(path = "historial-bpm")
public interface HistorialBpmRepository extends JpaRepository<HistorialBpm, Long> {
    List<HistorialBpm> findByFechaBefore(LocalDateTime fecha);
    void deleteByFechaBefore(LocalDateTime fecha);
    List<HistorialBpm> findTop500ByRunPOrderByFechaDesc(String runP);
}
