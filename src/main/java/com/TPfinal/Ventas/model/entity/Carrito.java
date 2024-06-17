package com.TPfinal.Ventas.model.entity;


import com.TPfinal.Productos.model.entity.Producto;

import java.util.LinkedList;
import java.util.Objects;

public class Carrito {

    private Integer id;
    private static Integer contador = 0;
    private LinkedList<Producto> listaProductos;
    private Double precioTotal;

    public Carrito(Double precioTotal) {
        this.id = ++contador;
        this.listaProductos = new LinkedList<Producto>();
        this.precioTotal = precioTotal;
    }

    public Integer getId() {
        return id;
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setListaProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return id == carrito.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
