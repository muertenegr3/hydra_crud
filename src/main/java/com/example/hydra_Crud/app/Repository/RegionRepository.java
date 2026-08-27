package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "regiones")
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
