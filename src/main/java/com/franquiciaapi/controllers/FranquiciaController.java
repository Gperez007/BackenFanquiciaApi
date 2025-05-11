package com.franquiciaapi.controllers;

import com.franquiciaapi.entidades.Franquicia;
import com.franquiciaapi.entidades.Producto;
import com.franquiciaapi.entidades.Sucursal;
import com.franquiciaapi.services.FranquiciaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    // Endpoint para crear una nueva franquicia
    @PostMapping
    public ResponseEntity<Franquicia> crearFranquicia(@RequestBody Franquicia franquicia) {
        Franquicia nuevaFranquicia = franquiciaService.crearFranquicia(franquicia);
        return ResponseEntity.ok(nuevaFranquicia);
    }

    // Endpoint para agregar una nueva sucursal a una franquicia existente
    @PostMapping("/{id}/sucursales")
    public ResponseEntity<Sucursal> agregarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = franquiciaService.agregarSucursal(id, sucursal);
        return ResponseEntity.ok(nuevaSucursal);
    }

    // Endpoint para agregar un nuevo producto a una sucursal
    @PostMapping("/{franquiciaId}/sucursales/{sucursalId}/productos")
    public ResponseEntity<Producto> agregarProducto(@PathVariable Long franquiciaId, 
                                                   @PathVariable Long sucursalId, 
                                                   @RequestBody Producto producto) {
        Producto nuevoProducto = franquiciaService.agregarProducto(sucursalId, producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // Endpoint para eliminar un producto de una sucursal
    @DeleteMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long franquiciaId, 
                                                 @PathVariable Long sucursalId, 
                                                 @PathVariable Long productoId) {
        franquiciaService.eliminarProducto(productoId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para modificar el stock de un producto
    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/stock")
    public ResponseEntity<Producto> modificarStockProducto(@PathVariable Long franquiciaId, 
                                                           @PathVariable Long sucursalId, 
                                                           @PathVariable Long productoId, 
                                                           @RequestParam int stock) {
        Producto productoActualizado = franquiciaService.modificarStock(productoId, stock);
        return ResponseEntity.ok(productoActualizado);
    }

    // Endpoint para obtener el producto con más stock por sucursal dentro de una franquicia
    @GetMapping("/{franquiciaId}/productos-con-mas-stock")
    public ResponseEntity<List<Producto>> obtenerProductoConMasStockPorSucursal(@PathVariable Long franquiciaId) {
        List<Producto> productos = franquiciaService.obtenerProductosConMasStockPorSucursal(franquiciaId);
        return ResponseEntity.ok(productos);
    }

    // Plus: Endpoint para actualizar el nombre de una franquicia
    @PutMapping("/{id}/nombre")
    public ResponseEntity<Franquicia> actualizarNombreFranquicia(@PathVariable Long id, @RequestBody String nombre) {
        Franquicia franquiciaActualizada = franquiciaService.actualizarNombreFranquicia(id, nombre);
        return ResponseEntity.ok(franquiciaActualizada);
    }

    // Plus: Endpoint para actualizar el nombre de una sucursal
    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}/nombre")
    public ResponseEntity<Sucursal> actualizarNombreSucursal(@PathVariable Long franquiciaId, 
                                                             @PathVariable Long sucursalId, 
                                                             @RequestBody String nombre) {
        Sucursal sucursalActualizada = franquiciaService.actualizarNombreSucursal(sucursalId, nombre);
        return ResponseEntity.ok(sucursalActualizada);
    }

    // Plus: Endpoint para actualizar el nombre de un producto
    @PutMapping("/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/nombre")
    public ResponseEntity<Producto> actualizarNombreProducto(@PathVariable Long franquiciaId, 
                                                             @PathVariable Long sucursalId, 
                                                             @PathVariable Long productoId, 
                                                             @RequestBody String nombre) {
        Producto productoActualizado = franquiciaService.actualizarNombreProducto(productoId, nombre);
        return ResponseEntity.ok(productoActualizado);
    }
}
