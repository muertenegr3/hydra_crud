package com.example.hydra_Crud.app.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

/**
 * Cifrado en reposo del RUN en la tabla mensajes.
 *
 * IMPORTANTE: encriptarRobusto() es NO DETERMINISTA (concatena un timestamp
 * antes de cifrar), por eso NO puede usarse para filtrar. Por eso la entidad
 * Mensaje guarda además un SHA-256 (HashUtils) que sí es determinista y es
 * lo que usan las queries y el matching por SSE.
 */
@Service
public class EncryptionService {

    @Value("${app.crypto.password}")
    private String password;

    @Value("${app.crypto.salt}")
    private String salt;

    private TextEncryptor encryptor;

    @PostConstruct
    public void Init() {
        this.encryptor = Encryptors.text(password, salt);
    }

    public String encriptarRobusto(String datosO) {
        String datoCR = datosO + "|" + System.currentTimeMillis();
        return encryptor.encrypt(datoCR);
    }

    public String Desencriptar(String datosC) {
        try {
            String desencrptadoCR = encryptor.decrypt(datosC);
            return desencrptadoCR.split("\\|")[0];
        } catch (Exception e) {
            return "Error, no se pudo desencriptar";
        }
    }
}
