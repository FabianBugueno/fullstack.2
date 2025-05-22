package com.edutech.principal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.principal.model.Usuario;
import com.edutech.principal.model.dto.UsuarioDto;
import com.edutech.principal.service.UsuarioService;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> obtenerUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }
    
    @GetMapping("/obtenerUsuario/{correo}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String correo){
        Usuario usuario = usuarioService.obteneUsuario(correo);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/obtenerUsuarioDto/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioDto(@PathVariable int id){
        if (usuarioService.obtenerUsuarioDto(id) != null) {
            return ResponseEntity.ok(usuarioService.obtenerUsuarioDto(id));
        } else {
            return ResponseEntity.notFound().build();
        }
}   
}

