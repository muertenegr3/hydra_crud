package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.EmpleadosFarmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "empleados-farmacia")
public interface EmpleadosFarmaciaRepository extends JpaRepository<EmpleadosFarmacia, String> {
}
