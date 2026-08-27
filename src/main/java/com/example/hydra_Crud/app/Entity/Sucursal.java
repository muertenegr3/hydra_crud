package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idSucursal;

    @Column(name = "direccion", length = 300)
    private String direccion;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    public Integer getIdSucursal() { return idSucursal; }
    public void setIdSucursal(Integer idSucursal) { this.idSucursal = idSucursal; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = direccion != null ? direccion.trim() : null;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public Integer getClinicaIdClinica() { return clinicaIdClinica; }
    public void setClinicaIdClinica(Integer clinicaIdClinica) { this.clinicaIdClinica = clinicaIdClinica; }
}
