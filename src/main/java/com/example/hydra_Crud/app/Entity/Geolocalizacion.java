package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "geolocalizacion")
public class Geolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_geolocalizacion")
    private Long idGeolocalizacion;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    @Column(name = "latitud")
    private Integer latitud;

    @Column(name = "longitud")
    private Integer longitud;

    public Long getIdGeolocalizacion() { return idGeolocalizacion; }
    public void setIdGeolocalizacion(Long idGeolocalizacion) { this.idGeolocalizacion = idGeolocalizacion; }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }

    public Integer getLatitud() { return latitud; }
    public void setLatitud(Integer latitud) { this.latitud = latitud; }

    public Integer getLongitud() { return longitud; }
    public void setLongitud(Integer longitud) { this.longitud = longitud; }
}
