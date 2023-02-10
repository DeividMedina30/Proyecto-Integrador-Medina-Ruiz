package com.example.demo.services;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServives {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> saveUser(Usuario usuario){
        Optional<Usuario> usuarioExistente = userRepository.findById(usuario.getId());
        if(!usuarioExistente.isEmpty()){
            return new ResponseEntity<>(userRepository.save(usuario), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("El usuario ya existe en la base de datos.", HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<?> deleteUser(Long id){
        Optional<Usuario> usuarioExistente = userRepository.findById(id);
        if(!usuarioExistente.isEmpty()){
            userRepository.deleteById(id);
            return new ResponseEntity<>("Se elimino correctamente el usuario", HttpStatus.OK);
        }
        return new ResponseEntity<>("El usuario no existe en la base de datos.", HttpStatus.BAD_REQUEST);
    }
}
