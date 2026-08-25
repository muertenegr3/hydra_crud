package com.example.hydra_Crud.app.Entity;

import java.io.Serializable;
import java.util.Objects;

public class FamiliarPacienteId implements Serializable {

    private String pacientesRunP;
    private String familiaresRun;

    public FamiliarPacienteId() {}

    public FamiliarPacienteId(String pacientesRunP, String familiaresRun) {
        this.pacientesRunP = pacientesRunP;
        this.familiaresRun = familiaresRun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamiliarPacienteId that = (FamiliarPacienteId) o;
        return Objects.equals(pacientesRunP, that.pacientesRunP) &&
               Objects.equals(familiaresRun, that.familiaresRun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacientesRunP, familiaresRun);
    }
}
