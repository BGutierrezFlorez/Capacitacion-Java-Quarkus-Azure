package com.cowshop.project.dto;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(
        name = "UsuarioLoginRequest",
        description = "Datos necesarios para el login"
)
@Data
public class UsuarioLoginRequest {

    @Schema(
            description = "Correo electrónico del usuario",
            required = true
    )
    private String correo;
    @Schema(
            description = "Contraseña del usuario",
            required = true
    )
    private String password;

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
