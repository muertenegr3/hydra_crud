package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados_farmacia")
public class EmpleadosFarmacia {

    @Id
    @Column(name = "run_ef", length = 12)
    private String runEf;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "apellido_materno", length = 20)
    private String apellidoMaterno;

    @Column(name = "apellido_paterno", length = 20)
    private String apellidoPaterno;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "farmacias_id_farmacias")
    private Integer farmaciasIdFarmacias;

    public String getRunEf() { return runEf; }
    public void setRunEf(String runEf) {
        this.runEf = runEf != null ? runEf.toLowerCase().trim() : null;
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

    public Integer getFarmaciasIdFarmacias() { return farmaciasIdFarmacias; }
    public void setFarmaciasIdFarmacias(Integer farmaciasIdFarmacias) {
        this.farmaciasIdFarmacias = farmaciasIdFarmacias;
    }
}
