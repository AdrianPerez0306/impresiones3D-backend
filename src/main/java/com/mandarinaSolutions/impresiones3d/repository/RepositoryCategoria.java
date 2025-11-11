package com.mandarinaSolutions.impresiones3d.repository;

import java.util.List;
import com.mandarinaSolutions.impresiones3d.querys.CategoriaQuerys;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mandarinaSolutions.impresiones3d.dominio.Categoria;
import org.springframework.data.jpa.repository.NativeQuery;


public interface RepositoryCategoria extends JpaRepository<Categoria, Integer> {
    @NativeQuery(value = CategoriaQuerys.CATEGORIAS_NAV)
    List<Categoria> getCategoriasNav();
}
