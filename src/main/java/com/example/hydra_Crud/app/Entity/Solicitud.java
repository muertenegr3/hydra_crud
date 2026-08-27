package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "empleados_run", length = 12)
    private String empleadosRun;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    @Column(name = "empleados_rol_rol_id_rol")
    private Integer empleadosRolRolIdRol;

    @Column(name = "empleados_rol_empleados_run", length = 12)
    private String empleadosRolEmpleadosRun;

    public Integer getIdSolicitud() { return idSolicitud; }
    public void setIdSolicitud(Integer idSolicitud) { this.idSolicitud = idSolicitud; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }

    public String getEmpleadosRun() { return empleadosRun; }
    public void setEmpleadosRun(String empleadosRun) {
        this.empleadosRun = empleadosRun != null ? empleadosRun.toLowerCase().trim() : null;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }

    public Integer getClinicaIdClinica() { return clinicaIdClinica; }
    public void setClinicaIdClinica(Integer clinicaIdClinica) {
        this.clinicaIdClinica = clinicaIdClinica;
    }

    public Integer getEmpleadosRolRolIdRol() { return empleadosRolRolIdRol; }
    public void setEmpleadosRolRolIdRol(Integer empleadosRolRolIdRol) {
        this.empleadosRolRolIdRol = empleadosRolRolIdRol;
    }

    public String getEmpleadosRolEmpleadosRun() { return empleadosRolEmpleadosRun; }
    public void setEmpleadosRolEmpleadosRun(String empleadosRolEmpleadosRun) {
        this.empleadosRolEmpleadosRun = empleadosRolEmpleadosRun != null
            ? empleadosRolEmpleadosRun.toLowerCase().trim() : null;
    }
}
