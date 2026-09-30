package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.HistorialGeolocalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(path = "historial-geo")
public interface HistorialGeolocalizacionRepository extends JpaRepository<HistorialGeolocalizacion, Long> {
    List<HistorialGeolocalizacion> findByFechaBefore(LocalDateTime fecha);
    void deleteByFechaBefore(LocalDateTime fecha);
}
