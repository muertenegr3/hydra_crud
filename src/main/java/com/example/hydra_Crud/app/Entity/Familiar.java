package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "familiares")
public class Familiar {

    @Id
    @Column(name = "run", length = 1000)
    private String run;

    @Column(name = "run1", length = 1000)
    private String run1;

    @Column(name = "nombre", length = 1000)
    private String nombre;

    @Column(name = "apellido_materno", length = 1000)
    private String apellidoMaterno;

    @Column(name = "apelllido_paterno", length = 1000)
    private String apellidoPaterno;

    @Column(name = "correo", length = 1000)
    private String correo;

    @Column(name = "pasword", length = 1000)
    private String pasword;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private Integer edad;

    // ───── Getters y Setters ─────

    public String getRun() { return run; }
    public void setRun(String run) {
        this.run = run != null ? run.toLowerCase().trim() : null;
    }

    public String getRun1() { return run1; }
    public void setRun1(String run1) {
        this.run1 = run1 != null ? run1.toLowerCase().trim() : null;
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

    public String getPasword() { return pasword; }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = genero != null ? genero.toUpperCase().trim() : null;
    }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) {
        this.edad = (edad != null && edad > 0) ? edad : null;
    }
}
