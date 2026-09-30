package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "historial_geolocalizacion")
public class HistorialGeolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "run_p", length = 1000)
    private String runP;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRunP() { return runP; }
    public void setRunP(String runP) {
        this.runP = runP != null ? runP.toLowerCase().trim() : null;
    }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
}
