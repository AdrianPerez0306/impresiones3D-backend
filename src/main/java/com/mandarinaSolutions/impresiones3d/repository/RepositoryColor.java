package com.mandarinaSolutions.impresiones3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mandarinaSolutions.impresiones3d.dominio.Color;

public interface RepositoryColor extends JpaRepository<Color, Integer> {

}
