package com.example.hydra_Crud.app.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados_rol")
@IdClass(EmpleadosRolId.class)
public class EmpleadosRol {

    @Id
    @Column(name = "rol_id_rol")
    private Integer rolIdRol;

    @Id
    @Column(name = "empleados_run", length = 12)
    private String empleadosRun;

    public Integer getRolIdRol() { return rolIdRol; }
    public void setRolIdRol(Integer rolIdRol) { this.rolIdRol = rolIdRol; }

    public String getEmpleadosRun() { return empleadosRun; }
    public void setEmpleadosRun(String empleadosRun) {
        this.empleadosRun = empleadosRun != null ? empleadosRun.toLowerCase().trim() : null;
    }
}
