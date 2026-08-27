package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Geolocalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "geolocalizacion")
public interface GeolocalizacionRepository extends JpaRepository<Geolocalizacion, Long> {
}
