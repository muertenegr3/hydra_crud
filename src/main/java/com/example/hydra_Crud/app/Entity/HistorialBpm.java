package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_bpm")
public class HistorialBpm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_bpm")
    private Long idHistorialBpm;

    @Column(name = "run_p", length = 12)
    private String runP;

    @Column(name = "valor_bpm")
    private Integer valorBpm;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalDate hora;

    public Long getIdHistorialBpm() { return idHistorialBpm; }
    public void setIdHistorialBpm(Long idHistorialBpm) { this.idHistorialBpm = idHistorialBpm; }

    public String getRunP() { return runP; }
    public void setRunP(String runP) {
        this.runP = runP != null ? runP.toLowerCase().trim() : null;
    }

    public Integer getValorBpm() { return valorBpm; }
    public void setValorBpm(Integer valorBpm) { this.valorBpm = valorBpm; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDate getHora() { return hora; }
    public void setHora(LocalDate hora) { this.hora = hora; }
}
