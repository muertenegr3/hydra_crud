package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Farmacias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "farmacias")
public interface FarmaciasRepository extends JpaRepository<Farmacias, Integer> {
}
