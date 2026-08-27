package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo")
    private Integer idMetodo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    public Integer getIdMetodo() { return idMetodo; }
    public void setIdMetodo(Integer idMetodo) { this.idMetodo = idMetodo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }
}
