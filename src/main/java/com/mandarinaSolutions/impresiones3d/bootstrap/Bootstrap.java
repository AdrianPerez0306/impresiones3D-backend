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

    // public void createProducts() {

    //     // Articulo articulo = new Articulo();
    //     // articulo.setPrecioLista(1000.0);
    //     // articulo.setDetalle("detalle mock");
    //     // articulo.setTitulo("articulo mock");
    //     // articulo.setDescuento(10.0);
    //     // articulo.setDisponible(true);

    //     // articulo.setDimensiones_mm(null);

    //     // articulo.setColores(null);

    //     // Imagen imagen = new Imagen();
    //     // imagen.setPath("path/to/image.jpg");
    //     // articulo.setImagenes();
    //     // Categoria categoria = new Categoria();

    //     // articulo.setCategorias(null);

    //     // Color color = new Color();
    //     // Dimension dimension = new Dimension();
    //     // Crear categorías primero
    //     Categoria categoriaLlaveros = new Categoria();
    //     categoriaLlaveros.setNombre("Llaveros");

    //     Categoria categoriaSoportes = new Categoria();
    //     categoriaSoportes.setNombre("Soportes");

    //     Categoria categoriaDecoracion = new Categoria();
    //     categoriaDecoracion.setNombre("Decoración");

    //     Categoria categoriaHerramientas = new Categoria();
    //     categoriaHerramientas.setNombre("Herramientas");

    //     // Crear colores
    //     Color colorRojo = new Color();
    //     colorRojo.setNombre("Rojo");
    //     colorRojo.setHexValue("FF0000");

    //     Color colorAzul = new Color();
    //     colorAzul.setNombre("Azul");
    //     colorAzul.setHexValue("0000FF");

    //     Color colorVerde = new Color();
    //     colorVerde.setNombre("Verde");
    //     colorVerde.setHexValue("00FF00");

    //     Color colorNegro = new Color();
    //     colorNegro.setNombre("Negro");
    //     colorNegro.setHexValue("000000");

    //     Color colorBlanco = new Color();
    //     colorBlanco.setNombre("Blanco");
    //     colorBlanco.setHexValue("FFFFFF");

    //     Color colorAmarillo = new Color();
    //     colorAmarillo.setNombre("Amarillo");
    //     colorAmarillo.setHexValue("FFFF00");

    //     // ARTÍCULO 1 - Llavero Personalizado
    //     Articulo articulo1 = new Articulo();
    //     articulo1.setTitulo("Llavero Personalizado");
    //     articulo1.setDetalle("Llavero impreso en 3D con diseño personalizable. Material PLA de alta calidad.");
    //     articulo1.setPrecioLista(1200.0);
    //     articulo1.setDescuento(10.0);
    //     articulo1.setDisponible(true);

    //     // Dimensiones para artículo 1
    //     Dimension dim1_1 = new Dimension();
    //     dim1_1.setAltoMM(50);
    //     dim1_1.setAnchoMM(30);
    //     dim1_1.setProfundidadMM(5);

    //     Dimension dim1_2 = new Dimension();
    //     dim1_2.setAltoMM(60);
    //     dim1_2.setAnchoMM(40);
    //     dim1_2.setProfundidadMM(5);

    //     List<Dimension> dimensionesArticulo1 = new ArrayList<>();
    //     dimensionesArticulo1.add(dim1_1);
    //     dimensionesArticulo1.add(dim1_2);
    //     articulo1.setDimensiones_mm(dimensionesArticulo1);

    //     // Imágenes para artículo 1
    //     Imagen img1_1 = new Imagen();
    //     img1_1.setPath("/images/llavero/frontal.jpg");

    //     Imagen img1_2 = new Imagen();
    //     img1_2.setPath("/images/llavero/lateral.jpg");

    //     Imagen img1_3 = new Imagen();
    //     img1_3.setPath("/images/llavero/detalle.jpg");

    //     List<Imagen> imagenesArticulo1 = new ArrayList<>();
    //     imagenesArticulo1.add(img1_1);
    //     imagenesArticulo1.add(img1_2);
    //     imagenesArticulo1.add(img1_3);
    //     articulo1.setImagenes(imagenesArticulo1);

    //     // Categorías y colores para artículo 1
    //     List<Categoria> categoriasArticulo1 = new ArrayList<>();
    //     categoriasArticulo1.add(categoriaLlaveros);
    //     categoriasArticulo1.add(categoriaHerramientas);
    //     articulo1.setCategorias(categoriasArticulo1);

    //     List<Color> coloresArticulo1 = new ArrayList<>();
    //     coloresArticulo1.add(colorRojo);
    //     coloresArticulo1.add(colorAzul);
    //     coloresArticulo1.add(colorNegro);
    //     articulo1.setColores(coloresArticulo1);

    //     // ARTÍCULO 2 - Soporte para Celular
    //     Articulo articulo2 = new Articulo();
    //     articulo2.setTitulo("Soporte para Celular");
    //     articulo2.setDetalle("Soporte ajustable para smartphones. Diseño ergonómico y estable.");
    //     articulo2.setPrecioLista(2500.0);
    //     articulo2.setDescuento(15.0);
    //     articulo2.setDisponible(true);

    //     // Dimensiones para artículo 2
    //     Dimension dim2_1 = new Dimension();
    //     dim2_1.setAltoMM(80);
    //     dim2_1.setAnchoMM(60);
    //     dim2_1.setProfundidadMM(40);

    //     List<Dimension> dimensionesArticulo2 = new ArrayList<>();
    //     dimensionesArticulo2.add(dim2_1);
    //     articulo2.setDimensiones_mm(dimensionesArticulo2);

    //     // Imágenes para artículo 2
    //     Imagen img2_1 = new Imagen();
    //     img2_1.setPath("/images/soporte/completo.jpg");

    //     Imagen img2_2 = new Imagen();
    //     img2_2.setPath("/images/soporte/en-uso.jpg");

    //     List<Imagen> imagenesArticulo2 = new ArrayList<>();
    //     imagenesArticulo2.add(img2_1);
    //     imagenesArticulo2.add(img2_2);
    //     articulo2.setImagenes(imagenesArticulo2);

    //     // Categorías y colores para artículo 2
    //     List<Categoria> categoriasArticulo2 = new ArrayList<>();
    //     categoriasArticulo2.add(categoriaSoportes);
    //     categoriasArticulo2.add(categoriaHerramientas);
    //     articulo2.setCategorias(categoriasArticulo2);

    //     List<Color> coloresArticulo2 = new ArrayList<>();
    //     coloresArticulo2.add(colorNegro);
    //     coloresArticulo2.add(colorBlanco);
    //     articulo2.setColores(coloresArticulo2);

    //     // ARTÍCULO 3 - Figura Decorativa Dragón
    //     Articulo articulo3 = new Articulo();
    //     articulo3.setTitulo("Figura Decorativa Dragón");
    //     articulo3.setDetalle("Figura de dragón mitológico con detalles finos. Perfecta para decoración.");
    //     articulo3.setPrecioLista(3500.0);
    //     articulo3.setDescuento(5.0);
    //     articulo3.setDisponible(true);

    //     // Dimensiones para artículo 3
    //     Dimension dim3_1 = new Dimension();
    //     dim3_1.setAltoMM(120);
    //     dim3_1.setAnchoMM(80);
    //     dim3_1.setProfundidadMM(60);

    //     List<Dimension> dimensionesArticulo3 = new ArrayList<>();
    //     dimensionesArticulo3.add(dim3_1);
    //     articulo3.setDimensiones_mm(dimensionesArticulo3);

    //     // Imágenes para artículo 3
    //     Imagen img3_1 = new Imagen();
    //     img3_1.setPath("/images/dragon/frontal.jpg");

    //     Imagen img3_2 = new Imagen();
    //     img3_2.setPath("/images/dragon/lateral.jpg");

    //     Imagen img3_3 = new Imagen();
    //     img3_3.setPath("/images/dragon/detalle-ala.jpg");

    //     Imagen img3_4 = new Imagen();
    //     img3_4.setPath("/images/dragon/detalle-cabeza.jpg");

    //     List<Imagen> imagenesArticulo3 = new ArrayList<>();
    //     imagenesArticulo3.add(img3_1);
    //     imagenesArticulo3.add(img3_2);
    //     imagenesArticulo3.add(img3_3);
    //     imagenesArticulo3.add(img3_4);
    //     articulo3.setImagenes(imagenesArticulo3);

    //     // Categorías y colores para artículo 3
    //     List<Categoria> categoriasArticulo3 = new ArrayList<>();
    //     categoriasArticulo3.add(categoriaDecoracion);
    //     articulo3.setCategorias(categoriasArticulo3);

    //     List<Color> coloresArticulo3 = new ArrayList<>();
    //     coloresArticulo3.add(colorRojo);
    //     coloresArticulo3.add(colorVerde);
    //     coloresArticulo3.add(colorAmarillo);
    //     coloresArticulo3.add(colorNegro);
    //     articulo3.setColores(coloresArticulo3);

    //     // ARTÍCULO 4 - Portalápices Minimalista
    //     Articulo articulo4 = new Articulo();
    //     articulo4.setTitulo("Portalápices Minimalista");
    //     articulo4.setDetalle("Portalápices con diseño moderno y minimalista. Organiza tu escritorio.");
    //     articulo4.setPrecioLista(1800.0);
    //     articulo4.setDescuento(0.0);
    //     articulo4.setDisponible(true);

    //     // Dimensiones para artículo 4
    //     Dimension dim4_1 = new Dimension();
    //     dim4_1.setAltoMM(100);
    //     dim4_1.setAnchoMM(80);
    //     dim4_1.setProfundidadMM(80);

    //     List<Dimension> dimensionesArticulo4 = new ArrayList<>();
    //     dimensionesArticulo4.add(dim4_1);
    //     articulo4.setDimensiones_mm(dimensionesArticulo4);

    //     // Imágenes para artículo 4
    //     Imagen img4_1 = new Imagen();
    //     img4_1.setPath("/images/portalapices/vista-superior.jpg");

    //     Imagen img4_2 = new Imagen();
    //     img4_2.setPath("/images/portalapices/vista-frontal.jpg");

    //     Imagen img4_3 = new Imagen();
    //     img4_3.setPath("/images/portalapices/en-uso.jpg");

    //     List<Imagen> imagenesArticulo4 = new ArrayList<>();
    //     imagenesArticulo4.add(img4_1);
    //     imagenesArticulo4.add(img4_2);
    //     imagenesArticulo4.add(img4_3);
    //     articulo4.setImagenes(imagenesArticulo4);

    //     // Categorías y colores para artículo 4
    //     List<Categoria> categoriasArticulo4 = new ArrayList<>();
    //     categoriasArticulo4.add(categoriaHerramientas);
    //     categoriasArticulo4.add(categoriaDecoracion);
    //     articulo4.setCategorias(categoriasArticulo4);

    //     List<Color> coloresArticulo4 = new ArrayList<>();
    //     coloresArticulo4.add(colorBlanco);
    //     coloresArticulo4.add(colorNegro);
    //     coloresArticulo4.add(colorAzul);
    //     articulo4.setColores(coloresArticulo4);

    //     // Lista final de artículos para guardar
    //     List<Articulo> articulos = Arrays.asList(articulo1, articulo2, articulo3, articulo4);

    //     repositoryArticulo.saveAll(articulos);

    // }

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
        categoria.setNombre(nombre);
        return repositoryCategoria.save(categoria);
    }
    
    private Color guardarColor(String nombre, String hexValue) {
        Color color = new Color();
        color.setNombre(nombre);
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
