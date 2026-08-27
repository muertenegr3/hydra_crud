package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "solicitudes")
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
