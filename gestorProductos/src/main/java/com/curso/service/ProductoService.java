package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.enums.Cat;
import com.curso.model.Producto;

/**
 * Clase que actúa de servicio con la clase Producto
 * 
 * @author DavidH
 * @version 1.0
 */
public class ProductoService {
	private static List<Producto> productos = new ArrayList<Producto>();

	static {
		Producto p1 = new Producto("Mesa Auxiliar", Cat.HOGAR, 13.5, 20);
		Producto p2 = new Producto("Cereales", Cat.ALIMENTO, 2.5, 12);
		Producto p3 = new Producto("Patinete eléctrico", Cat.OCIO, 120, 3);
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
	}

	/**
	 * Obtiene los productos actuales
	 * 
	 * @return lista de productos
	 */
	public static List<Producto> getProductos() {
		return productos;
	}

	/**
	 * Permite obtener el producto de la lista, indicando su Id
	 * 
	 * @param idProducto
	 * @return Producto
	 */
	public static Producto obtenerProductoById(Long id) {
		return productos.stream().filter(p -> p.getId() == id).toList().get(0);
	}

}
