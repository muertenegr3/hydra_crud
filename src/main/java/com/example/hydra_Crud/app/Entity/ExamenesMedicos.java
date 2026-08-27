package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "examenes_medicos")
public class ExamenesMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private Integer idExamen;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "fecha_resultado")
    private LocalDate fechaResultado;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "archivo_pdf", length = 1000)
    private String archivoPdf;

    @Column(name = "urgente", length = 1)
    private String urgente;

    @Column(name = "estado_examen_id_estado")
    private Integer estadoExamenIdEstado;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    public Integer getIdExamen() { return idExamen; }
    public void setIdExamen(Integer idExamen) { this.idExamen = idExamen; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }

    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDate fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public LocalDate getFechaResultado() { return fechaResultado; }
    public void setFechaResultado(LocalDate fechaResultado) { this.fechaResultado = fechaResultado; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) {
        this.resultado = resultado != null ? resultado.trim() : null;
    }

    public String getArchivoPdf() { return archivoPdf; }
    public void setArchivoPdf(String archivoPdf) {
        this.archivoPdf = archivoPdf != null ? archivoPdf.trim() : null;
    }

    public String getUrgente() { return urgente; }
    public void setUrgente(String urgente) {
        this.urgente = urgente != null ? urgente.toUpperCase().trim() : null;
    }

    public Integer getEstadoExamenIdEstado() { return estadoExamenIdEstado; }
    public void setEstadoExamenIdEstado(Integer estadoExamenIdEstado) {
        this.estadoExamenIdEstado = estadoExamenIdEstado;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }
}
