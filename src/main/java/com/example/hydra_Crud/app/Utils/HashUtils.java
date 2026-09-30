package com.example.hydra_Crud.app.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA-256 determinista, idéntico a hydra_arm_security.app.Utils.HashUtils.
 * Debe mantenerse en sincronía con aquel servicio: los hashes calculados
 * aquí se comparan contra los que devuelve GET /api/user/cripto/hash.
 */
public class HashUtils {

    public static String HASHEO(String run) {
        try {
            String runLimpio = run.replace(".", "").replace(" ", "").toLowerCase();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(runLimpio.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error crítico: no se encontró el algoritmo SHA-256", e);
        }
    }
}
