package com.mandarinaSolutions.impresiones3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mandarinaSolutions.impresiones3d.dominio.Categoria;


public interface RepositoryCategoria extends JpaRepository<Categoria, Integer> {

    boolean existsByNombre(String nombre);

    Categoria findByNombre(String nombre);
}
