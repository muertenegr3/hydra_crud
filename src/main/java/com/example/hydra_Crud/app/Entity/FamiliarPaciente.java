package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "familiar_paciente")
@IdClass(FamiliarPacienteId.class)
public class FamiliarPaciente {

    @Id
    @Column(name = "pacientes_run_p", length = 1000)
    private String pacientesRunP;

    @Id
    @Column(name = "familiares_run", length = 1000)
    private String familiaresRun;

    // ───── Getters y Setters ─────

    public String getPacientesRunP() { return pacientesRunP; }
    public void setPacientesRunP(String pacientesRunP) {
        this.pacientesRunP = pacientesRunP;
    }

    public String getFamiliaresRun() { return familiaresRun; }
    public void setFamiliaresRun(String familiaresRun) {
        this.familiaresRun = familiaresRun;
    }
}
