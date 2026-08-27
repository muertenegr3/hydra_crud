package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia")
    private Integer idProvincia;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "region_id_region")
    private Integer regionIdRegion;

    public Integer getIdProvincia() { return idProvincia; }
    public void setIdProvincia(Integer idProvincia) { this.idProvincia = idProvincia; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public Integer getRegionIdRegion() { return regionIdRegion; }
    public void setRegionIdRegion(Integer regionIdRegion) { this.regionIdRegion = regionIdRegion; }
}
