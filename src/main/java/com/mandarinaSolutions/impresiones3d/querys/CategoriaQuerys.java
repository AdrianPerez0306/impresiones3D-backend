package com.mandarinaSolutions.impresiones3d.querys;

public class CategoriaQuerys {
    public static final String CATEGORIAS_NAV = """
			SELECT 
				c.id, 
				c.nombre
			FROM 
				categoria c 
			INNER JOIN 
				articulo_categoria ac ON c.id = ac.id_categoria
			GROUP BY c.nombre
			""";
}
