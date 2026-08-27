package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region")
    private Integer idRegion;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "pais_id_pais")
    private Integer paisIdPais;

    public Integer getIdRegion() { return idRegion; }
    public void setIdRegion(Integer idRegion) { this.idRegion = idRegion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public Integer getPaisIdPais() { return paisIdPais; }
    public void setPaisIdPais(Integer paisIdPais) { this.paisIdPais = paisIdPais; }
}
