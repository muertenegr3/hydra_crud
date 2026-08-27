package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recetas")
public class Recetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recetas")
    private Integer idRecetas;

    @Column(name = "medicamentos", length = 200)
    private String medicamentos;

    @Column(name = "indicaciones", length = 1000)
    private String indicaciones;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "id_autorizador")
    private Integer idAutorizador;

    @Column(name = "empleados_farmacia_run_ef", length = 12)
    private String empleadosFarmaciaRunEf;

    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    @Column(name = "empleados_rol_rol_id_rol")
    private Integer empleadosRolRolIdRol;

    @Column(name = "empleados_rol_empleados_run", length = 12)
    private String empleadosRolEmpleadosRun;

    public Integer getIdRecetas() { return idRecetas; }
    public void setIdRecetas(Integer idRecetas) { this.idRecetas = idRecetas; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos != null ? medicamentos.trim() : null;
    }

    public String getIndicaciones() { return indicaciones; }
    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones != null ? indicaciones.trim() : null;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }

    public Integer getIdMedico() { return idMedico; }
    public void setIdMedico(Integer idMedico) { this.idMedico = idMedico; }

    public Integer getIdAutorizador() { return idAutorizador; }
    public void setIdAutorizador(Integer idAutorizador) { this.idAutorizador = idAutorizador; }

    public String getEmpleadosFarmaciaRunEf() { return empleadosFarmaciaRunEf; }
    public void setEmpleadosFarmaciaRunEf(String empleadosFarmaciaRunEf) {
        this.empleadosFarmaciaRunEf = empleadosFarmaciaRunEf != null
            ? empleadosFarmaciaRunEf.toLowerCase().trim() : null;
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
