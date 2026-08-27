package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "protesis")
public class Protesis {

    @Id
    @Column(name = "solicitud_id_solicitud")
    private Integer solicitudIdSolicitud;

    @Column(name = "id_protesis")
    private Integer idProtesis;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    @Column(name = "stock_protesis_id_item")
    private Integer stockProtesisIdItem;

    public Integer getSolicitudIdSolicitud() { return solicitudIdSolicitud; }
    public void setSolicitudIdSolicitud(Integer solicitudIdSolicitud) {
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }

    public Integer getIdProtesis() { return idProtesis; }
    public void setIdProtesis(Integer idProtesis) { this.idProtesis = idProtesis; }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }

    public Integer getStockProtesisIdItem() { return stockProtesisIdItem; }
    public void setStockProtesisIdItem(Integer stockProtesisIdItem) {
        this.stockProtesisIdItem = stockProtesisIdItem;
    }
}
