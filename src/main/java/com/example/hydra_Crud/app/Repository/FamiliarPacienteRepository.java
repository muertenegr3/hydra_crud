package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.FamiliarPaciente;
import com.example.hydra_Crud.app.Entity.FamiliarPacienteId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "familiar-paciente", exported = false)
public interface FamiliarPacienteRepository extends JpaRepository<FamiliarPaciente, FamiliarPacienteId> {

    List<FamiliarPaciente> findByFamiliaresRun(String familiaresRun);

    List<FamiliarPaciente> findByPacientesRunP(String pacientesRunP);
}
