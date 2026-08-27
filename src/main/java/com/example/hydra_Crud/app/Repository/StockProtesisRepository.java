package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.StockProtesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "stock-protesis")
public interface StockProtesisRepository extends JpaRepository<StockProtesis, Integer> {
}
