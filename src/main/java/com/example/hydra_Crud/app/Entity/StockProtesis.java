package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_protesis")
public class StockProtesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    @Column(name = "tipo_protesis_id_tipo")
    private Integer tipoProtesisIdTipo;

    @Column(name = "clinica_id_clinica")
    private Integer clinicaIdClinica;

    public Integer getIdItem() { return idItem; }
    public void setIdItem(Integer idItem) { this.idItem = idItem; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }

    public Integer getTipoProtesisIdTipo() { return tipoProtesisIdTipo; }
    public void setTipoProtesisIdTipo(Integer tipoProtesisIdTipo) {
        this.tipoProtesisIdTipo = tipoProtesisIdTipo;
    }

    public Integer getClinicaIdClinica() { return clinicaIdClinica; }
    public void setClinicaIdClinica(Integer clinicaIdClinica) {
        this.clinicaIdClinica = clinicaIdClinica;
    }
}
