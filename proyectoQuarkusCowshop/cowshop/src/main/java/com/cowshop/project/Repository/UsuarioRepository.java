package com.cowshop.project.Repository;

import com.cowshop.project.entities.Usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;

@ApplicationScoped
public class UsuarioRepository {

    @PersistenceContext
     EntityManager em;

    public enum VerificacionLoginResultado{
        OK,
        NoExisteCorreo,
        ContrasenaIncorrecta,
    }
    public VerificacionLoginResultado verificarLogin(String email, String password){
        List<Usuario> usuarios = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.correo = :correo",
                Usuario.class
        ) .setParameter("correo", email)
                .getResultList();
        if(usuarios.isEmpty()) {
            return VerificacionLoginResultado.NoExisteCorreo;
        }
        Usuario u = usuarios.get(0);
        if(!u.contrasena.equals(password)){
            return VerificacionLoginResultado.ContrasenaIncorrecta;
        }
        return VerificacionLoginResultado.OK;
    }
    // 🔹 Registrar Usuario
    @Transactional
    public boolean registrarUsuario(Usuario u) {
        try {
            // Usar el nombre correcto del procedimiento: registrar_usuario
            StoredProcedureQuery sp = em.createStoredProcedureQuery("registrar_usuario");

            // Registrar parámetros basados en la firma de PostgreSQL
            sp.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);        // p_nombre
            sp.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);        // p_cedula
            sp.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);          // p_fecha_nacimiento
            sp.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);        // p_correo
            sp.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);        // p_celular
            sp.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);        // p_tipo_usuario
            sp.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);       // p_id_membresia
            sp.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);        // p_contrasena
            sp.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);       // p_id_rol
            sp.registerStoredProcedureParameter(10, Boolean.class, ParameterMode.IN);      // p_estado
            sp.registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT); // RETURNS integer

            // Establecer valores de parámetros
            sp.setParameter(1, u.nombre);
            sp.setParameter(2, u.cedula);
            
            // Convertir fecha_nacimiento a java.sql.Date
            if (u.fechaNacimiento != null && !u.fechaNacimiento.isBlank()) {
                sp.setParameter(3, Date.valueOf(u.fechaNacimiento));
            } else {
                sp.setParameter(3, null);
            }
            
            sp.setParameter(4, u.correo);
            sp.setParameter(5, u.celular);
            sp.setParameter(6, u.tipoUsuario);
            sp.setParameter(7, u.idMembresia);
            sp.setParameter(8, u.contrasena);
            sp.setParameter(9, u.idRol);
            sp.setParameter(10, u.estado != null ? u.estado : false);

            // Ejecutar el procedimiento
            sp.execute();
            
            // Obtener el ID retornado
            Integer nuevoId = (Integer) sp.getOutputParameterValue("result");
            if (nuevoId != null) {
                u.id = nuevoId.longValue();
            }
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Listar Usuarios
    @SuppressWarnings("unchecked")
    public List<Usuario> listarUsuarios() {
        return em.createNativeQuery("SELECT * FROM sp_listar_usuario()", Usuario.class)
                .getResultList();
    }

    // 🔹 Obtener por ID
    @SuppressWarnings("unchecked")
    public List<Usuario> obtenerUsuarioPorId(Long id) {
        return em.createNativeQuery("SELECT * FROM obtenerusuario(:id)", Usuario.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    public boolean actualizarUsuario(Long id, Usuario u) {
        try {
            StoredProcedureQuery sp = em.createStoredProcedureQuery("actualizar_usuario");

            // Registrar parámetros (por posición)
            sp.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);           // p_id_usuario
            sp.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);         // p_nombre
            sp.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);         // p_cedula
            sp.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);           // p_fecha_nacimiento
            sp.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);         // p_correo
            sp.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);         // p_celular
            sp.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);         // p_tipo_usuario
            sp.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);        // p_id_membresia
            sp.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);         // p_contrasena
            sp.registerStoredProcedureParameter(10, Integer.class, ParameterMode.IN);       // p_id_rol
            sp.registerStoredProcedureParameter(11, Boolean.class, ParameterMode.IN);       // p_estado

            // Establecer valores
            sp.setParameter(1, id);
            sp.setParameter(2, u.nombre);
            sp.setParameter(3, u.cedula);
            
            if (u.fechaNacimiento != null && !u.fechaNacimiento.isBlank()) {
                sp.setParameter(4, Date.valueOf(u.fechaNacimiento));
            } else {
                sp.setParameter(4, null);
            }
            
            sp.setParameter(5, u.correo);
            sp.setParameter(6, u.celular);
            sp.setParameter(7, u.tipoUsuario);
            sp.setParameter(8, u.idMembresia);
            sp.setParameter(9, u.contrasena);
            sp.setParameter(10, u.idRol);
            sp.setParameter(11, u.estado != null ? u.estado : false);

            sp.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // 🔹 Eliminar
    @Transactional
    public boolean eliminar(Long id) {
        try {
            StoredProcedureQuery sp = em.createStoredProcedureQuery("eliminar_usuario");
            sp.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
            sp.setParameter(1, id);
            sp.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 Login
    @SuppressWarnings("unchecked")
    public Usuario login(String correo, String contrasena) {
        List<Usuario> result = em.createNativeQuery(
                        "SELECT * FROM loginusuario(:correo, :contrasena)", Usuario.class)
                .setParameter("correo", correo)
                .setParameter("contrasena", contrasena)
                .getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void persist(Usuario usuario) {
    }
}

