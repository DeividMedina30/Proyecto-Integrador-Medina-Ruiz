package com.example.demo.controller;

import com.example.demo.dto.UsuarioConverter;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.model.Usuario;
import com.example.demo.services.UsuarioServives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioServives usuarioServives;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @PostMapping("/usuarios")
    public ResponseEntity<?> createUser(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario =usuarioConverter.dtoToEntity(usuarioDto);
        ResponseEntity<?> usuarioAnswer = usuarioServives.saveUser(usuario);
        return usuarioAnswer;
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id){
        return usuarioServives.deleteUser(id);
    }
}
