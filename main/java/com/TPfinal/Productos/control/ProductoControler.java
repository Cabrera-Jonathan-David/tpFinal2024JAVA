package com.TPfinal.Productos.control;

import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;

import java.util.Iterator;

public class ProductoControler {
    ProductoRepositories productoRepositories;

    public ProductoControler(ProductoRepositories productoRepositories) {
        this.productoRepositories = productoRepositories;
    }

    public ProductoRepositories getProductoRepositories() {
        return productoRepositories;
    }

    public Producto obtenerProducto(String nombre) {
        return productoRepositories.search(nombre);
    }

    public void modificarStock(Producto producto, Integer extra){

        producto.setStockDisponible(producto.getStockDisponible()+ extra);
        productoRepositories.update(producto);

    }

    public Producto comprobarExistencia(String nombre) {
        Iterator<Producto> itProd = productoRepositories.pedirIterador();
        while (itProd.hasNext()) {
            Producto producto = itProd.next();
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }

        }
        return null;
    }

    public Iterator<Producto> iterator() {
        return productoRepositories.pedirIterador();

    }

}






