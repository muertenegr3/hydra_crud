package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Familiar;
import com.example.hydra_Crud.app.Entity.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "pacientes")
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query("SELECT f FROM Familiar f WHERE f.run IN " +
           "(SELECT fp.familiaresRun FROM FamiliarPaciente fp WHERE fp.pacientesRunP = :runPaciente)")
    List<Familiar> findFamiliaresByPacienteRun(@Param("runPaciente") String runPaciente);
}