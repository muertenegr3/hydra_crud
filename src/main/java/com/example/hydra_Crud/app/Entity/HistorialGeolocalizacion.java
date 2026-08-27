package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_geolocalizacion")
public class HistorialGeolocalizacion {

    @Id
    @Column(name = "run_p")
    private Integer runP;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalDate hora;

    public Integer getRunP() { return runP; }
    public void setRunP(Integer runP) { this.runP = runP; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDate getHora() { return hora; }
    public void setHora(LocalDate hora) { this.hora = hora; }
}
