package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "estados")
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
