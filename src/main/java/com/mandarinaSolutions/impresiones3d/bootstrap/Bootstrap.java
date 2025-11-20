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
        guardarImagen(articuloGuardado.getId(), "https://acdn-us.mitiendanube.com/stores/427/841/products/img_68351-df6fcaf72091c9079b16778653523585-1024-1024.jpeg");
        guardarImagen(articuloGuardado.getId(), "https://cdn.quicksell.co/-NkYl4A0SPH5NIewgV0v/products/-Nkdy4ZQatYpNDilZpJu.jpg");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqZV-11PXoOPPiG62pyDJMHhp8h7day4aK_A&s");
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
        
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSvdy9WY3Js2LrFfQIyDhbFq1kVx-sxTStvTmux2OcYaou6tuVfxibDbUNFCSh2JqJF74&usqp=CAU");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP0QdbodaKGUwJgqICDQV97R5VNWgAbmLmLg&s");
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
        
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGq5pybfOLhuLR6jrjOoRagq27yPzOttxI2A&s");
        guardarImagen(articuloGuardado.getId(), "https://i5.walmartimages.com/asr/5021f186-74c2-45d9-806a-e9e7a8a0c23a.96d79ca648cfecdf56bc3b78afbfea12.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSELJ6MjIqVs45FdxPXOMX2Bo4_5p-4XG3PBqW2gjkXTDYq0SuNrF-XnN3dWEqto0Et94A&usqp=CAU");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVRJ6qmTENu80NM0MbEHlXNIfAYenxfk6nBSdGSmTtBmWGjhgS3Gwdg8cPs2ZTYLjC0UQ&usqp=CAU");
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
        
        guardarImagen(articuloGuardado.getId(), "https://i5.walmartimages.com/asr/b81c1a50-347a-4daa-907f-07662ff1542f.867c2cad4e1ae88e337a073ff9046519.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT59nitS32GrU2EGYKAitDDuXDRH0ZMyGZZpg&s");
        guardarImagen(articuloGuardado.getId(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR24s4Spa075su64hKTP_ZUM57waYOtVi-RjQ&s");
    }
    
    private void guardarImagen(Integer articuloId, String path) {
        Imagen imagen = new Imagen();
        imagen.setPath(path);
        imagen.setArticuloID(articuloId);
        repositoryImagen.save(imagen);
    }

}
