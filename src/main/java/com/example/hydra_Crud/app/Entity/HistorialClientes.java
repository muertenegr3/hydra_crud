package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_clientes")
public class HistorialClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    public Integer getIdHistorial() { return idHistorial; }
    public void setIdHistorial(Integer idHistorial) { this.idHistorial = idHistorial; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico != null ? diagnostico.trim() : null;
    }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones != null ? observaciones.trim() : null;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }
}
