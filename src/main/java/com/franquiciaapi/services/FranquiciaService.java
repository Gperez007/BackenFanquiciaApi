package com.franquiciaapi.services;

import com.franquiciaapi.entidades.Franquicia;
import com.franquiciaapi.entidades.Producto;
import com.franquiciaapi.entidades.Sucursal;

import java.util.List;

public interface FranquiciaService {
	Franquicia crearFranquicia(Franquicia franquicia);

	Sucursal agregarSucursal(Long franquiciaId, Sucursal sucursal);

	Producto agregarProducto(Long sucursalId, Producto producto);

	void eliminarProducto(Long productoId);

	Producto modificarStock(Long productoId, int stock);

	List<Producto> obtenerProductosConMasStockPorSucursal(Long franquiciaId);

	// Métodos adicionales para actualizar los nombres
	Franquicia actualizarNombreFranquicia(Long franquiciaId, String nombre);

	Sucursal actualizarNombreSucursal(Long sucursalId, String nombre);

	Producto actualizarNombreProducto(Long productoId, String nombre);
}
