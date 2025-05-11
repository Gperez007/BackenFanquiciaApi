package com.franquiciaapi.services.implement;

import com.franquiciaapi.entidades.Franquicia;
import com.franquiciaapi.entidades.Producto;
import com.franquiciaapi.entidades.Sucursal;
import com.franquiciaapi.repository.FranquiciaRepository;
import com.franquiciaapi.repository.ProductoRepository;
import com.franquiciaapi.repository.SucursalRepository;
import com.franquiciaapi.services.FranquiciaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    @Override
    public Franquicia crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public Sucursal agregarSucursal(Long franquiciaId, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElseThrow();
        sucursal.setFranquicia(franquicia);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Producto agregarProducto(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow();
        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public Producto modificarStock(Long productoId, int stock) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        producto.setStock(stock);
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerProductosConMasStockPorSucursal(Long franquiciaId) {
        // Aquí podrías implementar la lógica para obtener los productos con más stock por sucursal
        return null; // Esto debería ser reemplazado por la lógica real
    }

    // Implementación de los nuevos métodos para actualizar nombres

    @Override
    public Franquicia actualizarNombreFranquicia(Long franquiciaId, String nombre) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElseThrow();
        franquicia.setNombre(nombre);
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public Sucursal actualizarNombreSucursal(Long sucursalId, String nombre) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow();
        sucursal.setNombre(nombre);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Producto actualizarNombreProducto(Long productoId, String nombre) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        producto.setNombre(nombre);
        return productoRepository.save(producto);
    }
}