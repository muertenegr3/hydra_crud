package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.TipoProtesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tipos-protesis")
public interface TipoProtesisRepository extends JpaRepository<TipoProtesis, Integer> {
}
