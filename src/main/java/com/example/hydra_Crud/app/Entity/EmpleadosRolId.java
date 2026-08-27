package com.example.hydra_Crud.app.Entity;

import java.io.Serializable;
import java.util.Objects;

public class EmpleadosRolId implements Serializable {

    private Integer rolIdRol;
    private String empleadosRun;

    public EmpleadosRolId() {}

    public EmpleadosRolId(Integer rolIdRol, String empleadosRun) {
        this.rolIdRol = rolIdRol;
        this.empleadosRun = empleadosRun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosRolId that = (EmpleadosRolId) o;
        return Objects.equals(rolIdRol, that.rolIdRol) &&
               Objects.equals(empleadosRun, that.empleadosRun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolIdRol, empleadosRun);
    }
}
