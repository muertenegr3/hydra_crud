package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @Column(name = "monto")
    private Integer monto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "paciente_run_p", length = 12)
    private String pacienteRunP;

    @Column(name = "metodo_pago_id_metodo")
    private Integer metodoPagoIdMetodo;

    @Column(name = "estado_pago_id_estado")
    private Integer estadoPagoIdEstado;

    public Integer getIdPago() { return idPago; }
    public void setIdPago(Integer idPago) { this.idPago = idPago; }

    public Integer getMonto() { return monto; }
    public void setMonto(Integer monto) { this.monto = monto; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getPacienteRunP() { return pacienteRunP; }
    public void setPacienteRunP(String pacienteRunP) {
        this.pacienteRunP = pacienteRunP != null ? pacienteRunP.toLowerCase().trim() : null;
    }

    public Integer getMetodoPagoIdMetodo() { return metodoPagoIdMetodo; }
    public void setMetodoPagoIdMetodo(Integer metodoPagoIdMetodo) {
        this.metodoPagoIdMetodo = metodoPagoIdMetodo;
    }

    public Integer getEstadoPagoIdEstado() { return estadoPagoIdEstado; }
    public void setEstadoPagoIdEstado(Integer estadoPagoIdEstado) {
        this.estadoPagoIdEstado = estadoPagoIdEstado;
    }
}
