package com.TPfinal.Productos.model.entity;

import java.util.Objects;

public class Producto {
    private String nombre;
    private Double precio;
    private Integer idProducto;
    private String marca;
    private Integer stockDisponible;
    private static Integer contadorId=0;

    public Producto(String nombre, Double precio, String marca, Integer stockDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.stockDisponible = stockDisponible;
        this.idProducto= ++contadorId;
    }

    public Producto(Integer idProducto) {
        contadorId =idProducto;
    }

    public Integer getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Producto producto = (Producto) object;
        return Objects.equals(idProducto, producto.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProducto);
    }


}
