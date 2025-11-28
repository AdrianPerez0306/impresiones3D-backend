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
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

// @Service
public class Bootstrap {

    // @Autowired
    // private RepositoryArticulo repositoryArticulo;
    
    // @Autowired
    // private RepositoryColor repositoryColor;
    
    // @Autowired 
    // private RepositoryCategoria repositoryCategoria;
    
    // @Autowired
    // private RepositoryDimension repositoryDimension;
    
    // @Autowired
    // private RepositoryImagen repositoryImagen;

    // @Override
    // public void run(String... args) throws Exception {
    //     System.out.println("Aplicación iniciada correctamente.");
    //     cargarDatosIniciales();
    // }

    // private void cargarDatosIniciales() {
    //     // 1. GUARDAR CATEGORÍAS PRIMERO
    //     Categoria catDecoracion = guardarCategoria("decoracion");
    //     Categoria catColeccion = guardarCategoria("coleccionables");
    //     Categoria catHogar = guardarCategoria("hogar");
    //     Categoria catOficina = guardarCategoria("oficina");
    //     Categoria catTecnologia = guardarCategoria("tecnologia");
    //     Categoria catAutomovil = guardarCategoria("automovil");
    //     Categoria catJuegos = guardarCategoria("juegos");
    //     Categoria catJardín = guardarCategoria("jardin");

    //     // 2. GUARDAR COLORES PREMIUM
    //     Color colorCarmesi = guardarColor("Rojo Carmesí", "DC143C");
    //     Color colorOceano = guardarColor("Azul Océano", "1E90FF");
    //     Color colorEsmeralda = guardarColor("Verde Esmeralda", "50C878");
    //     Color colorOnyx = guardarColor("Negro Ónix", "0F0F0F");
    //     Color colorMarfil = guardarColor("Blanco Marfil", "FFFFF0");
    //     Color colorAmbar = guardarColor("Ámbar Dorado", "FFBF00");
    //     Color colorGrafito = guardarColor("Gris Grafito", "464646");
    //     Color colorBronce = guardarColor("Bronce Antiguo", "CD7F32");
    //     Color colorLavanda = guardarColor("Lavanda", "E6E6FA");
    //     Color colorTurquesa = guardarColor("Turquesa", "40E0D0");

    //     // 3. CREAR Y GUARDAR PRODUCTOS
    //     crearCazaImperial(catDecoracion, catColeccion, colorGrafito, colorOnyx, colorBronce);
    //     crearBustoFangio(catDecoracion, catAutomovil, colorBronce, colorOnyx, colorCarmesi);
    //     crearLapiceroOrganico(catOficina, catHogar, colorEsmeralda, colorTurquesa, colorMarfil);
    //     crearMaceteroW(catJardín, catHogar, colorLavanda, colorEsmeralda, colorAmbar);
    //     crearMotorG1(catDecoracion, catColeccion, colorGrafito, colorOnyx, colorBronce);
    //     crearPicadorFerrari(catHogar, catAutomovil, colorCarmesi, colorOnyx, colorAmbar);
    //     crearSoporteCelular(catTecnologia, catHogar, colorOnyx, colorMarfil, colorOceano);
    //     crearRepisaAutos(catDecoracion, catColeccion, colorOceano, colorCarmesi, colorGrafito);
    //     crearStencilR2D2(catJuegos, catDecoracion, colorMarfil, colorOceano, colorGrafito);
    // }
    
    // private Categoria guardarCategoria(String nombre) {
    //     Categoria categoria = new Categoria();
    //     categoria.setNombre(nombre.toLowerCase());
    //     return repositoryCategoria.save(categoria);
    // }
    
    // private Color guardarColor(String nombre, String hexValue) {
    //     Color color = new Color();
    //     color.setNombre(nombre.toLowerCase());
    //     color.setHexValue(hexValue);
    //     return repositoryColor.save(color);
    // }
    
    // private void crearCazaImperial(Categoria decoracion, Categoria coleccion, Color grafito, Color onyx, Color bronce) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Caza Imperial Star Wars");
    //     articulo.setDetalle("Réplica detallada del caza imperial de Star Wars. Impresión de alta resolución con acabado profesional. Perfecto para coleccionistas.");
    //     articulo.setPrecioLista(4500.0);
    //     articulo.setDescuento(8.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(decoracion, coleccion)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(grafito, onyx, bronce)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim1 = new Dimension();
    //     dim1.setAltoMM(180);
    //     dim1.setAnchoMM(220);
    //     dim1.setProfundidadMM(75);
    //     dim1.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim1);
        
    //     guardarImagen(articuloGuardado.getId(), "cazaImperial_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "cazaImperial_2.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "cazaImperial_3.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "cazaImperial_4.jpeg");
    // }
    
    // private void crearBustoFangio(Categoria decoracion, Categoria automovil, Color bronce, Color onyx, Color carmesi) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Busto Conmemorativo Juan Manuel Fangio");
    //     articulo.setDetalle("Busto detallado del legendario piloto de Fórmula 1. Acabado premium ideal para oficinas o espacios automovilísticos.");
    //     articulo.setPrecioLista(3800.0);
    //     articulo.setDescuento(5.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(decoracion, automovil)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(bronce, onyx, carmesi)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(150);
    //     dim.setAnchoMM(120);
    //     dim.setProfundidadMM(90);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "fangio_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "fangio_2.jpeg");
    // }
    
    // private void crearLapiceroOrganico(Categoria oficina, Categoria hogar, Color esmeralda, Color turquesa, Color marfil) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Lapicero Orgánico Moderno");
    //     articulo.setDetalle("Diseño orgánico y fluido que combina funcionalidad con arte. Perfecto para escritorios modernos y espacios de trabajo creativos.");
    //     articulo.setPrecioLista(2200.0);
    //     articulo.setDescuento(12.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(oficina, hogar)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(esmeralda, turquesa, marfil)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(140);
    //     dim.setAnchoMM(100);
    //     dim.setProfundidadMM(100);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "lapiceroOrganico_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "lapiceroOrganico_2.jpeg");
    // }
    
    // private void crearMaceteroW(Categoria jardin, Categoria hogar, Color lavanda, Color esmeralda, Color ambar) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Macetero W Diseño Geométrico");
    //     articulo.setDetalle("Macetero con patrón geométrico 'W' que permite excelente drenaje y aireación. Ideal para suculentas y plantas pequeñas.");
    //     articulo.setPrecioLista(1900.0);
    //     articulo.setDescuento(7.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(jardin, hogar)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(lavanda, esmeralda, ambar)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(110);
    //     dim.setAnchoMM(130);
    //     dim.setProfundidadMM(130);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "maceteroW_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "maceteroW_2.jpeg");
    // }
    
    // private void crearMotorG1(Categoria decoracion, Categoria coleccion, Color grafito, Color onyx, Color bronce) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Motor G1 Detalle Mecánico");
    //     articulo.setDetalle("Réplica de motor con detalles mecánicos visibles. Pieza decorativa ideal para talleres, oficinas técnicas o amantes de la ingeniería.");
    //     articulo.setPrecioLista(5200.0);
    //     articulo.setDescuento(10.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(decoracion, coleccion)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(grafito, onyx, bronce)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(160);
    //     dim.setAnchoMM(200);
    //     dim.setProfundidadMM(150);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "motorG1_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "motorG1_2.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "motorG1_3.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "motorG1_4.jpeg");
    // }
    
    // private void crearPicadorFerrari(Categoria hogar, Categoria automovil, Color carmesi, Color onyx, Color ambar) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Picador Ferrari Design");
    //     articulo.setDetalle("Picador de hierbas con diseño inspirado en la aerodinámica Ferrari. Funcionalidad de cocina con estilo automovilístico.");
    //     articulo.setPrecioLista(2800.0);
    //     articulo.setDescuento(15.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(hogar, automovil)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(carmesi, onyx, ambar)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(95);
    //     dim.setAnchoMM(75);
    //     dim.setProfundidadMM(75);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "picadorFerrari_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "picadorFerrari_2.jpeg");
    // }
    
    // private void crearSoporteCelular(Categoria tecnologia, Categoria hogar, Color onyx, Color marfil, Color oceano) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Soporte Celular Ajustable 360°");
    //     articulo.setDetalle("Soporte universal para celulares con rotación 360° y base antideslizante. Perfecto para videollamadas, navegación GPS o ver contenido.");
    //     articulo.setPrecioLista(1600.0);
    //     articulo.setDescuento(20.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(tecnologia, hogar)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(onyx, marfil, oceano)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(120);
    //     dim.setAnchoMM(80);
    //     dim.setProfundidadMM(80);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "soporteCelular_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "soporteCelular_2.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "soporteCelular_3.jpeg");
    // }
    
    // private void crearRepisaAutos(Categoria decoracion, Categoria coleccion, Color oceano, Color carmesi, Color grafito) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Repisa Expositora para Autos en Miniatura");
    //     articulo.setDetalle("Repisa con diseño moderno para exhibir autos en miniatura. Incluye divisiones para organizar la colección de manera elegante.");
    //     articulo.setPrecioLista(3100.0);
    //     articulo.setDescuento(6.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(decoracion, coleccion)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(oceano, carmesi, grafito)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(250);
    //     dim.setAnchoMM(400);
    //     dim.setProfundidadMM(120);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "repisaAutos_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "repisaAutos_2.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "repisaAutos_3.jpeg");
    // }
    
    // private void crearStencilR2D2(Categoria juegos, Categoria decoracion, Color marfil, Color oceano, Color grafito) {
    //     Articulo articulo = new Articulo();
    //     articulo.setTitulo("Stencil Decorativo R2-D2 Star Wars");
    //     articulo.setDetalle("Plantilla/stencil del icónico droide R2-D2. Perfecto para personalizar paredes, cuadernos, o crear arte personalizado con temática Star Wars.");
    //     articulo.setPrecioLista(1350.0);
    //     articulo.setDescuento(18.0);
    //     articulo.setDisponible(true);
    //     articulo.setCategorias(new HashSet<>(Arrays.asList(juegos, decoracion)));
    //     articulo.setColores(new HashSet<>(Arrays.asList(marfil, oceano, grafito)));
        
    //     Articulo articuloGuardado = repositoryArticulo.save(articulo);
        
    //     Dimension dim = new Dimension();
    //     dim.setAltoMM(200);
    //     dim.setAnchoMM(140);
    //     dim.setProfundidadMM(5);
    //     dim.setArticuloID(articuloGuardado.getId());
    //     repositoryDimension.save(dim);
        
    //     guardarImagen(articuloGuardado.getId(), "stencilR2D2_1.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "stencilR2D2_2.jpeg");
    //     guardarImagen(articuloGuardado.getId(), "stencilR2D2_3.jpeg");
    // }
    
    // private void guardarImagen(Integer articuloId, String path) {
    //     Imagen imagen = new Imagen();
    //     imagen.setPath(path);
    //     imagen.setArticuloID(articuloId);
    //     repositoryImagen.save(imagen);
    // }

}