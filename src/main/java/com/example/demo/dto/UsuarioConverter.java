package com.example.demo.dto;

import com.example.demo.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioConverter {
    public UsuarioDto entityToDto(Usuario usuario) {
        ModelMapper mapper =new ModelMapper();
        UsuarioDto map = mapper.map(usuario, UsuarioDto.class);
        return map;

    }
    public List<UsuarioDto> entityToDto(List<Usuario> usuario) {
        return	usuario.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Usuario dtoToEntity(UsuarioDto usuarioDto)
    {
        ModelMapper mapper = new ModelMapper();
        Usuario map = mapper.map(usuarioDto, Usuario.class);
        return map;
    }

    public List<Usuario> dtoToEntity(List<UsuarioDto> dto)
    {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
