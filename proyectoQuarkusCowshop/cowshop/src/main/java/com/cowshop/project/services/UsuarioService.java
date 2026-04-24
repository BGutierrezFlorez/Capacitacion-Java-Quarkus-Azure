package com.cowshop.project.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.cowshop.project.Repository.UsuarioRepository;
import com.cowshop.project.entities.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario() {
        return usuarioRepository.listarUsuarios();
    }
    public Usuario obtenerUsuario(Long id){
        List<Usuario> result = usuarioRepository.obtenerUsuarioPorId(id);
        return result.isEmpty() ? null : result.get(0);
    }

    // POST
    @Transactional
    public Usuario crearUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("El usuario no puede ser nullo");
        }
        if(usuario == null || usuario.nombre.isBlank()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if(usuario.cedula ==  null){
            throw new IllegalArgumentException("El cedula no puede ser nula");

        }
        usuarioRepository.persist(usuario);
        return usuario;
    }
}
