package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "estados-pago")
public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Integer> {
}
