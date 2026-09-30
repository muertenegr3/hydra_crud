package com.example.hydra_Crud.app.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bpm")
public class Bpm {

    @Id
    @Column(name = "paciente_run_p", length = 1000)
    private String pacienteRunP;

    @Column(name = "valor_bpm")
    private Integer valorBpm;

    @Column(name = "spo2")
    private Integer spo2;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    // Getters y Setters

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) { this.pacienteRunP = pacienteRunP; }

    public Integer getValorBpm() { return valorBpm; }
    public void setValorBpm(Integer valorBpm) { this.valorBpm = valorBpm; }

    public Integer getSpo2() { return spo2; }
    public void setSpo2(Integer spo2) { this.spo2 = spo2; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
