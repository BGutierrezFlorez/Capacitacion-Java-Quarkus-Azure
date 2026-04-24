package com.cowshop.project.resources;

import com.cowshop.project.Repository.UsuarioRepository;
import com.cowshop.project.entities.Usuario;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuarios", description = "Gestión de usuarios")
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;

    /* ===================== GET ===================== */

    @GET
    @Operation(summary = "Listar usuarios")
    @APIResponse(responseCode = "200", description = "Lista de usuarios")
    public Response listar() {
        List<Usuario> usuarios = usuarioRepository.listarUsuarios();
        return Response.ok(usuarios != null ? usuarios : List.of()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Obtener usuario por ID")
    @APIResponse(responseCode = "200", description = "Usuario encontrado")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Response obtenerPorId(@PathParam("id") int id) {
        List<Usuario> resultado = usuarioRepository.obtenerUsuarioPorId((long) id);
        Usuario usuario = resultado.isEmpty() ? null : resultado.get(0);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    /* ===================== POST ===================== */

    @POST
    @Operation(summary = "Registrar usuario")
    @APIResponse(responseCode = "201", description = "Usuario creado")
    @APIResponse(responseCode = "400", description = "Datos inválidos")
    public Response registrar(Usuario usuario, @Context UriInfo uriInfo) {
        try {
            if (usuario == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Usuario es requerido")
                        .build();
            }

            // Validar campos requeridos
            if (usuario.nombre == null || usuario.nombre.isBlank()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("El nombre es requerido")
                        .build();
            }

            if (usuario.cedula == null || usuario.cedula.isBlank()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("La cédula es requerida")
                        .build();
            }

            if (usuario.correo == null || usuario.correo.isBlank()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("El correo es requerido")
                        .build();
            }

            if (usuario.contrasena == null || usuario.contrasena.isBlank()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("La contraseña es requerida")
                        .build();
            }

            if (usuario.tipoUsuario == null || usuario.tipoUsuario.isBlank()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("El tipo de usuario es requerido")
                        .build();
            }

            boolean success = usuarioRepository.registrarUsuario(usuario);
            if (!success) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("No se pudo registrar el usuario")
                        .build();
            }

            UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            builder.path(String.valueOf(usuario.getID_Usuario()));

            return Response.created(builder.build()).entity(usuario).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al registrar usuario: " + e.getMessage())
                    .build();
        }
    }

    /* ===================== PUT ===================== */

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar usuario")
    @APIResponse(responseCode = "200", description = "Usuario actualizado")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Response actualizar(@PathParam("id") int id, Usuario usuario) {
        if (usuario == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        usuario.setID_Usuario(id);

        boolean success = usuarioRepository.actualizarUsuario((long) id, usuario);
        if (!success) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(usuario).build();
    }

    /* ===================== DELETE ===================== */

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar usuario")
    @APIResponse(responseCode = "204", description = "Usuario eliminado")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    public Response eliminar(@PathParam("id") int id) {
        boolean success = usuarioRepository.eliminar((long) id);
        if (!success) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
