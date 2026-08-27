package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clinica")
    private Integer idClinica;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "comuna_id_comuna")
    private Integer comunaIdComuna;

    public Integer getIdClinica() { return idClinica; }
    public void setIdClinica(Integer idClinica) { this.idClinica = idClinica; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion.trim() : null;
    }

    public Integer getComunaIdComuna() { return comunaIdComuna; }
    public void setComunaIdComuna(Integer comunaIdComuna) { this.comunaIdComuna = comunaIdComuna; }
}
