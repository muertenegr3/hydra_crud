package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Familiar;
import com.example.hydra_Crud.app.Entity.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "familiares")
public interface FamiliarRepository extends JpaRepository<Familiar, String> {

    @Query("SELECT p FROM Paciente p WHERE p.runP IN " +
           "(SELECT fp.pacientesRunP FROM FamiliarPaciente fp WHERE fp.familiaresRun = :runFamiliar)")
    List<Paciente> findPacientesByFamiliarRun(@Param("runFamiliar") String runFamiliar);
}
