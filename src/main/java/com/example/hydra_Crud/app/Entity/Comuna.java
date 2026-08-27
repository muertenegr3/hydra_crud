package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comuna")
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private Integer idComuna;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "provincia_id_provincia")
    private Integer provinciaIdProvincia;

    public Integer getIdComuna() { return idComuna; }
    public void setIdComuna(Integer idComuna) { this.idComuna = idComuna; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public Integer getProvinciaIdProvincia() { return provinciaIdProvincia; }
    public void setProvinciaIdProvincia(Integer provinciaIdProvincia) { this.provinciaIdProvincia = provinciaIdProvincia; }
}
