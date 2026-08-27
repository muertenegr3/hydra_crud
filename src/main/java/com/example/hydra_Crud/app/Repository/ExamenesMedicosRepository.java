package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.ExamenesMedicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "examenes")
public interface ExamenesMedicosRepository extends JpaRepository<ExamenesMedicos, Integer> {
}
