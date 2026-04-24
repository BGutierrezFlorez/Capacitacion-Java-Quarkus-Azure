package com.cowshop.project.helpers;

import io.smallrye.jwt.build.Jwt;

public class JwtHelper {

    private static final String ISSUER = "cowshop-api";

    public static String generarToken(Long idUsuario, String tipoUsuario) {

        long expiracion = System.currentTimeMillis() / 1000 + (2 * 60 * 60);

        return Jwt.issuer(ISSUER)
                .claim("id", idUsuario)
                .claim("rol", tipoUsuario)
                .expiresAt(expiracion)
                .sign();
    }
}
