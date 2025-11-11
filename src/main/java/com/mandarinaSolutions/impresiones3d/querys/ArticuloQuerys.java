package com.mandarinaSolutions.impresiones3d.querys;


public class ArticuloQuerys {
	
	private static final String QueryArticuloBasicDTO = """
			SELECT
				a.id,
				a.titulo,
				a.precio_lista,
				a.descuento,
				(SELECT i.path FROM imagen i WHERE i.articulo_id = a.id LIMIT 1) AS imagen
			FROM
				articulo a
			""";
	
	public static final String CARRITO = ArticuloQuerys.QueryArticuloBasicDTO + """
			WHERE
				a.id in :ids
			""";
	
	public static final String HOME = ArticuloQuerys.QueryArticuloBasicDTO + """
			WHERE
				a.disponible = True
			""";
	
	public static final String FILTER = ArticuloQuerys.QueryArticuloBasicDTO + """
			WHERE
				a.titulo LIKE CONCAT('%',:filter,'%')
			""";
	
	public static final String CATEGORIA = ArticuloQuerys.QueryArticuloBasicDTO + """
			JOIN
				articulo_categoria ac ON a.id = ac.id_articulo
			JOIN
				categoria c ON ac.id_categoria = c.id
			WHERE 
				c.nombre = :categoria
			""";
}
