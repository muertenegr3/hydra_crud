package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_bpm")
public class HistorialBpm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_bpm")
    private Long idHistorialBpm;

    @Column(name = "run_p", length = 1000)
    private String runP;

    @Column(name = "valor_bpm")
    private Integer valorBpm;

    @Column(name = "spo2")
    private Integer spo2;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public Long getIdHistorialBpm() { return idHistorialBpm; }
    public void setIdHistorialBpm(Long idHistorialBpm) { this.idHistorialBpm = idHistorialBpm; }

    public String getRunP() { return runP; }
    public void setRunP(String runP) {
        this.runP = runP != null ? runP.toLowerCase().trim() : null;
    }

    public Integer getValorBpm() { return valorBpm; }
    public void setValorBpm(Integer valorBpm) { this.valorBpm = valorBpm; }

    public Integer getSpo2() { return spo2; }
    public void setSpo2(Integer spo2) { this.spo2 = spo2; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
