package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.HistorialGeolocalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "historial-geo")
public interface HistorialGeolocalizacionRepository extends JpaRepository<HistorialGeolocalizacion, Integer> {
}
