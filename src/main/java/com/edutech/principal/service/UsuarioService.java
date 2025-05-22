package com.edutech.principal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.principal.model.Usuario;
import com.edutech.principal.model.entity.UsuarioEntity;
import com.edutech.principal.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;    
    
    public String crearUsuario(Usuario user){
        try {
            if (usuarioRepository.existsByCorreo(user.getCorreo())) {
                throw new RuntimeException("El correo ya existe");
            }
            UsuarioEntity usuarioNuevo = new UsuarioEntity();
                usuarioNuevo.setIdUsuario(user.getIdUsuario());
                usuarioNuevo.setNombre(user.getNombre());
                usuarioNuevo.setApellidos(user.getApellidos());
                usuarioNuevo.setCorreo(user.getCorreo());
                usuarioNuevo.setContrasena(user.getContrasena());
                usuarioRepository.save(usuarioNuevo);
                return "Usuario creado con éxito";

        }
                catch (Exception e) {
                    return "Error al crear el usuario: " + e.getMessage();
        }
}
public Usuario obteneUsuario(String correo){
    try {
        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null) {
            Usuario user = new Usuario(
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getApellidos(),
                    usuario.getCorreo(),
                    usuario.getContrasena()
            );
            return user;
            
        }
        return null;
    } catch (Exception e) {
        return null;
    }  
    }
}