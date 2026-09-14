package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Mensaje 1:1 entre paciente/familiar y cuidador/medico.
 * Realtime: la tabla "mensajes" se agrega a la publicación supabase_realtime.
 */
@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "remitente_run", nullable = false, length = 12)
    private String remitenteRun;

    @Column(name = "rol_origen", nullable = false, length = 20)
    private String rolOrigen;

    @Column(name = "destinatario_run", nullable = false, length = 12)
    private String destinatarioRun;

    @Column(name = "rol_destino", nullable = false, length = 20)
    private String rolDestino;

    @Column(name = "contenido", nullable = false, columnDefinition = "text")
    private String contenido;

    @Column(name = "adjunto_url", length = 500)
    private String adjuntoUrl;

    @Column(name = "adjunto_nombre", length = 255)
    private String adjuntoNombre;

    @Column(name = "leido", nullable = false)
    private Boolean leido = false;

    @Column(name = "leido_en")
    private LocalDateTime leidoEn;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRemitenteRun() { return remitenteRun; }
    public void setRemitenteRun(String remitenteRun) { this.remitenteRun = remitenteRun; }

    public String getRolOrigen() { return rolOrigen; }
    public void setRolOrigen(String rolOrigen) { this.rolOrigen = rolOrigen; }

    public String getDestinatarioRun() { return destinatarioRun; }
    public void setDestinatarioRun(String destinatarioRun) { this.destinatarioRun = destinatarioRun; }

    public String getRolDestino() { return rolDestino; }
    public void setRolDestino(String rolDestino) { this.rolDestino = rolDestino; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getAdjuntoUrl() { return adjuntoUrl; }
    public void setAdjuntoUrl(String adjuntoUrl) { this.adjuntoUrl = adjuntoUrl; }

    public String getAdjuntoNombre() { return adjuntoNombre; }
    public void setAdjuntoNombre(String adjuntoNombre) { this.adjuntoNombre = adjuntoNombre; }

    public Boolean getLeido() { return leido; }
    public void setLeido(Boolean leido) { this.leido = leido; }

    public LocalDateTime getLeidoEn() { return leidoEn; }
    public void setLeidoEn(LocalDateTime leidoEn) { this.leidoEn = leidoEn; }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }
}