package com.cowshop.project.api;

import com.cowshop.project.entities.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Usuarios")
public interface UsuarioApi {

    // =========================
    // GET - Listar usuarios
    // =========================
    Response getUsuarios();

    // =========================
    // GET - Usuario por ID
    // =========================
    Response getUsuarioById(Integer id);

    // =========================
    // POST - Registrar usuario
    // =========================
    Response registrarUsuario(Usuario usuario);

    // =========================
    // PUT - Actualizar usuario
    // (pendiente)
    // =========================
    Response actualizarUsuario(Integer id, com.cowshop.project.model.Usuario usuario);

    // =========================
    // DELETE - Eliminar usuario
    // (pendiente)
    // =========================
    Response eliminarUsuario(Integer id);

    // =========================
    // POST - Login
    // (pendiente)
    // =========================
    Response login(com.cowshop.project.model.LoginRequest loginRequest);

    // =========================
    // GET - Roles
    // (pendiente)
    // =========================
    Response getRoles();

    @GET
    @Operation(summary = "Obtener todos los usuarios")
    @APIResponse(responseCode = "200", description = "Lista de usuarios")
    Response getAllUsuarios();

    @GET
    @Path("/{id}")
    @Operation(summary = "Obtener usuario por id")
    @APIResponse(responseCode = "200", description = "Usuario encontrado")
    @APIResponse(responseCode = "404", description = "Usuario no encontrado")
    Response getUsuarioById(@PathParam("id") Long id);

    @POST
    @Operation(summary = "Crear usuario")
    @APIResponse(responseCode = "201", description = "Usuario creado")
    Response createUsuario(Usuario usuario);

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar usuario")
    Response updateUsuario(@PathParam("id") Long id, Usuario usuario);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar usuario")
    Response deleteUsuario(@PathParam("id") Long id);
}
