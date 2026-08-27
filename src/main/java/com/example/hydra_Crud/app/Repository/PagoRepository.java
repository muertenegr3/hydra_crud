package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pagos")
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
