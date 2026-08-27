package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cita_medicas")
public class CitaMedicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    private LocalDate horaInicio;

    @Column(name = "hora_fin")
    private LocalDate horaFin;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "box_consulta", length = 20)
    private String boxConsulta;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDate getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalDate horaInicio) { this.horaInicio = horaInicio; }

    public LocalDate getHoraFin() { return horaFin; }
    public void setHoraFin(LocalDate horaFin) { this.horaFin = horaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        this.estado = estado != null ? estado.trim() : null;
    }

    public String getBoxConsulta() { return boxConsulta; }
    public void setBoxConsulta(String boxConsulta) {
        this.boxConsulta = boxConsulta != null ? boxConsulta.trim() : null;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }
}
