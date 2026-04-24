package com.cowshop.project.resources;

import com.cowshop.project.Repository.UsuarioRepository;
import com.cowshop.project.helpers.JwtHelper;
import com.cowshop.project.entities.Usuario;
import com.cowshop.project.dto.UsuarioLoginRequest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/usuarios/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Autenticación")
public class LoginResource {

    @Inject
    UsuarioRepository usuarioRepository; // ✅ INYECCIÓN CORRECTA

    @POST
    @Operation(summary = "Login de usuario")
    @APIResponse(responseCode = "200", description = "Login exitoso")
    @APIResponse(responseCode = "401", description = "Credenciales inválidas")
    public Response login(UsuarioLoginRequest request) {

        if (request == null ||
                request.getCorreo() == null ||
                request.getPassword() == null) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Correo y contraseña son obligatorios")
                    .build();
        }

        // ✅ LLAMADA CORRECTA AL REPOSITORY
        var ver = usuarioRepository.verificarLogin(
                request.getCorreo(),
                request.getPassword()
        );

        if (ver == UsuarioRepository.VerificacionLoginResultado.NoExisteCorreo) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Correo no registrado")
                    .build();
        }

        if (ver == UsuarioRepository.VerificacionLoginResultado.ContrasenaIncorrecta) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Contraseña incorrecta")
                    .build();
        }

        // ✅ OBTENER USUARIO REAL
        Usuario usuario = usuarioRepository.login(
                request.getCorreo(),
                request.getPassword()
        );

        if (usuario == null) {
            return Response.serverError()
                    .entity("Error al obtener usuario")
                    .build();
        }

        // ✅ GENERAR TOKEN
        String token = JwtHelper.generarToken(
                usuario.getID_Usuario(),
                usuario.getTipo_Usuario()
        );

        return Response.ok(
                new LoginResponse(token, usuario)
        ).build();
    }

    /* DTO interno de respuesta */
    public record LoginResponse(String token, UsuarioDTO usuario) {
        public LoginResponse(String token, Usuario u) {
            this(token,
                    new UsuarioDTO(
                            u.getID_Usuario(),
                            u.getNombre(),
                            u.getTipo_Usuario()
                    )
            );
        }
    }

    public record UsuarioDTO(Long id, String nombre, String tipo) {}
}
