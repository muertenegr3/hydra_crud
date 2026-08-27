package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "descripcion", length = 20)
    private String descripcion;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    public Integer getIdEstado() { return idEstado; }
    public void setIdEstado(Integer idEstado) { this.idEstado = idEstado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : null;
    }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }
}
