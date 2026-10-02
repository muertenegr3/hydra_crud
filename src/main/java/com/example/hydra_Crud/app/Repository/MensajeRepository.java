package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Todas las consultas comparan contra el SHA-256 del RUN, que es lo que hay
 * almacenado en remitente_run / destinatario_run. El RUN en texto plano nunca
 * llega a la base, y como el hash es determinista el equality match funciona.
 */
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    /** Historial de una conversacion 1:1 (ambas direcciones), cronologico. */
    @Query("select m from Mensaje m " +
           "where (m.remitenteRun = :aHash and m.destinatarioRun = :bHash) " +
           "   or (m.remitenteRun = :bHash and m.destinatarioRun = :aHash) " +
           "order by m.creadoEn asc")
    List<Mensaje> conversacion(@Param("aHash") String runAHash,
                               @Param("bHash") String runBHash);

    /** Mensajes no leidos de un destinatario (para el badge de notificaciones). */
    @Query("select m from Mensaje m " +
           "where m.destinatarioRun = :destinoHash and m.rolDestino = :rol and m.leido = false " +
           "order by m.creadoEn desc")
    List<Mensaje> noLeidos(@Param("destinoHash") String destinoHash,
                           @Param("rol") String rolDestino);

    @Modifying
    @Query("update Mensaje m set m.leido = true, m.leidoEn = :ahora where m.id = :id")
    int marcarLeido(@Param("id") Long id, @Param("ahora") LocalDateTime ahora);
}
