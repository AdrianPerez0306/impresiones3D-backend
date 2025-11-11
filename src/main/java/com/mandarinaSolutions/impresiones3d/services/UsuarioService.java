package com.mandarinaSolutions.impresiones3d.services;

import com.mandarinaSolutions.impresiones3d.DTO.UserDTO;
import com.mandarinaSolutions.impresiones3d.dominio.Usuario;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryCategoria;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private RepositoryUsuario userRepo;

    public boolean logeo(UserDTO userDTO){
        Usuario usuario = new Usuario();
        usuario = userRepo.findById(userDTO.Id).get();
        return validarUsuario(userDTO, usuario);
    }

    private boolean validarUsuario(UserDTO userDTO, Usuario usuario){
        return (userDTO.username.equals(usuario.getUsername()) && userDTO.password.equals(usuario.getPassword()));
    }

    public boolean logout() {
        return false;
    }
}
