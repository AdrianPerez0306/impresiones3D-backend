package com.mandarinaSolutions.impresiones3d.repository;

import com.mandarinaSolutions.impresiones3d.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {

}