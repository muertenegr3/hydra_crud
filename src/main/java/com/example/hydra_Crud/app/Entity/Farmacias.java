package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farmacias")
public class Farmacias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_farmacias")
    private Integer idFarmacias;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "direccion", length = 1000)
    private String direccion;

    public Integer getIdFarmacias() { return idFarmacias; }
    public void setIdFarmacias(Integer idFarmacias) { this.idFarmacias = idFarmacias; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion.trim() : null;
    }
}
