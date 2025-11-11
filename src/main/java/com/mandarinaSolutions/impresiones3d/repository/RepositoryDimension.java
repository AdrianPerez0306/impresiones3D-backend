package com.mandarinaSolutions.impresiones3d.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mandarinaSolutions.impresiones3d.dominio.Dimension;

public interface RepositoryDimension extends JpaRepository<Dimension, Integer> {
	
}
