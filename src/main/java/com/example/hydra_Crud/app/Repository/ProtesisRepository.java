package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Protesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "protesis")
public interface ProtesisRepository extends JpaRepository<Protesis, Integer> {
}
