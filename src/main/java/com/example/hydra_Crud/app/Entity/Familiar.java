package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "familiares")
public class Familiar {

    @Id
    @Column(name = "run", length = 1000)
    private String run;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "apellido_materno", length = 20)
    private String apellidoMaterno;

    @Column(name = "apellido_paterno", length = 20)
    private String apellidoPaterno;

    @Column(name = "correo", length = 1000)
    private String correo;

    @Column(name = "password", length = 1000)
    private String password;

    @Column(name = "genero", length = 1)
    private String genero;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "telefono", length = 1000)
    private String telefono;

    public String getRun() { return run; }
    public void setRun(String run) {
        this.run = run != null ? run.toLowerCase().trim() : null;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno != null ? apellidoMaterno.trim() : null;
    }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno != null ? apellidoPaterno.trim() : null;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = correo != null ? correo.toLowerCase().trim() : null;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = genero != null ? genero.toUpperCase().trim() : null;
    }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) {
        this.edad = (edad != null && edad > 0) ? edad : null;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        this.telefono = telefono != null ? telefono.trim() : null;
    }
}
