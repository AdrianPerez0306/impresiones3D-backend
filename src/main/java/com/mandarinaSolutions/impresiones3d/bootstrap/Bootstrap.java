package com.mandarinaSolutions.impresiones3d.bootstrap;

import org.springframework.stereotype.Service;

import com.mandarinaSolutions.impresiones3d.dominio.Articulo;
import com.mandarinaSolutions.impresiones3d.dominio.Categoria;
import com.mandarinaSolutions.impresiones3d.dominio.Color;
import com.mandarinaSolutions.impresiones3d.dominio.Dimension;
import com.mandarinaSolutions.impresiones3d.dominio.Imagen;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryArticulo;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryCategoria;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryColor;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryDimension;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryImagen;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Service
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private RepositoryArticulo repositoryArticulo;
    
    @Autowired
    private RepositoryColor repositoryColor;
    
    @Autowired 
    private RepositoryCategoria repositoryCategoria;
    
    @Autowired
    private RepositoryDimension repositoryDimension;
    
    @Autowired
    private RepositoryImagen repositoryImagen;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicación iniciada correctamente.");
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // 1. GUARDAR CATEGORÍAS PRIMERO
        Categoria catLlaveros = guardarCategoria("Llaveros");
        Categoria catSoportes = guardarCategoria("Soportes");
        Categoria catDecoracion = guardarCategoria("Decoración");
        Categoria catHerramientas = guardarCategoria("Herramientas");

        // 2. GUARDAR COLORES
        Color colorRojo = guardarColor("Rojo", "FF0000");
        Color colorAzul = guardarColor("Azul", "0000FF");
        Color colorVerde = guardarColor("Verde", "00FF00");
        Color colorNegro = guardarColor("Negro", "000000");
        Color colorBlanco = guardarColor("Blanco", "FFFFFF");
        Color colorAmarillo = guardarColor("Amarillo", "FFFF00");

        // 3. CREAR Y GUARDAR ARTÍCULOS
        crearYGuardarLlavero(catLlaveros, catHerramientas, colorRojo, colorAzul, colorNegro);
        crearYGuardarSoporte(catSoportes, catHerramientas, colorNegro, colorBlanco);
        crearYGuardarFigura(catDecoracion, colorRojo, colorVerde, colorAmarillo);
        crearYGuardarPortalapices(catHerramientas, catDecoracion, colorBlanco, colorNegro, colorAzul);
    }
    
    private Categoria guardarCategoria(String nombre) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre.toLowerCase());
        return repositoryCategoria.save(categoria);
    }
    
    private Color guardarColor(String nombre, String hexValue) {
        Color color = new Color();
        color.setNombre(nombre.toLowerCase());
        color.setHexValue(hexValue);
        return repositoryColor.save(color);
    }
    
    private void crearYGuardarLlavero(Categoria llaveros, Categoria herramientas, Color rojo, Color azul, Color negro) {
        Articulo articulo = new Articulo();
        articulo.setTitulo("Llavero Personalizado");
        articulo.setDetalle("Llavero impreso en 3D con diseño personalizable. Material PLA de alta calidad.");
        articulo.setPrecioLista(1200.0);
        articulo.setDescuento(10.0);
        articulo.setDisponible(true);
        articulo.setCategorias(Arrays.asList(llaveros, herramientas));
        articulo.setColores(Arrays.asList(rojo, azul, negro));
        
        Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
        // Dimensiones para este artículo
        Dimension dim1 = new Dimension();
        dim1.setAltoMM(50);
        dim1.setAnchoMM(30);
        dim1.setProfundidadMM(5);
        dim1.setArticuloID(articuloGuardado.getId());
        repositoryDimension.save(dim1);
        
        Dimension dim2 = new Dimension();
        dim2.setAltoMM(60);
        dim2.setAnchoMM(40);
        dim2.setProfundidadMM(5);
        dim2.setArticuloID(articuloGuardado.getId());
        repositoryDimension.save(dim2);
        
        // Imágenes para este artículo
        guardarImagen(articuloGuardado.getId(), "/images/llavero/frontal.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/llavero/lateral.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/llavero/detalle.jpg");
    }
    
    private void crearYGuardarSoporte(Categoria soportes, Categoria herramientas, Color negro, Color blanco) {
        Articulo articulo = new Articulo();
        articulo.setTitulo("Soporte para Celular");
        articulo.setDetalle("Soporte ajustable para smartphones. Diseño ergonómico y estable.");
        articulo.setPrecioLista(2500.0);
        articulo.setDescuento(15.0);
        articulo.setDisponible(true);
        articulo.setCategorias(Arrays.asList(soportes, herramientas));
        articulo.setColores(Arrays.asList(negro, blanco));
        
        Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
        Dimension dim = new Dimension();
        dim.setAltoMM(80);
        dim.setAnchoMM(60);
        dim.setProfundidadMM(40);
        dim.setArticuloID(articuloGuardado.getId());
        repositoryDimension.save(dim);
        
        guardarImagen(articuloGuardado.getId(), "/images/soporte/completo.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/soporte/en-uso.jpg");
    }
    
    private void crearYGuardarFigura(Categoria decoracion, Color rojo, Color verde, Color amarillo) {
        Articulo articulo = new Articulo();
        articulo.setTitulo("Figura Decorativa Dragón");
        articulo.setDetalle("Figura de dragón mitológico con detalles finos. Perfecta para decoración.");
        articulo.setPrecioLista(3500.0);
        articulo.setDescuento(5.0);
        articulo.setDisponible(true);
        articulo.setCategorias(Arrays.asList(decoracion));
        articulo.setColores(Arrays.asList(rojo, verde, amarillo));
        
        Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
        Dimension dim = new Dimension();
        dim.setAltoMM(120);
        dim.setAnchoMM(80);
        dim.setProfundidadMM(60);
        dim.setArticuloID(articuloGuardado.getId());
        repositoryDimension.save(dim);
        
        guardarImagen(articuloGuardado.getId(), "/images/dragon/frontal.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/dragon/lateral.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/dragon/detalle-ala.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/dragon/detalle-cabeza.jpg");
    }
    
    private void crearYGuardarPortalapices(Categoria herramientas, Categoria decoracion, Color blanco, Color negro, Color azul) {
        Articulo articulo = new Articulo();
        articulo.setTitulo("Portalápices Minimalista");
        articulo.setDetalle("Portalápices con diseño moderno y minimalista. Organiza tu escritorio.");
        articulo.setPrecioLista(1800.0);
        articulo.setDescuento(0.0);
        articulo.setDisponible(true);
        articulo.setCategorias(Arrays.asList(herramientas, decoracion));
        articulo.setColores(Arrays.asList(blanco, negro, azul));
        
        Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
        Dimension dim = new Dimension();
        dim.setAltoMM(100);
        dim.setAnchoMM(80);
        dim.setProfundidadMM(80);
        dim.setArticuloID(articuloGuardado.getId());
        repositoryDimension.save(dim);
        
        guardarImagen(articuloGuardado.getId(), "/images/portalapices/vista-superior.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/portalapices/vista-frontal.jpg");
        guardarImagen(articuloGuardado.getId(), "/images/portalapices/en-uso.jpg");
    }
    
    private void guardarImagen(Integer articuloId, String path) {
        Imagen imagen = new Imagen();
        imagen.setPath(path);
        imagen.setArticuloID(articuloId);
        repositoryImagen.save(imagen);
    }

}
