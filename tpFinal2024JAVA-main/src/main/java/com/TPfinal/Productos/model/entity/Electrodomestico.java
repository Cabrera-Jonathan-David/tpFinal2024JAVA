package com.TPfinal.Productos.model.entity;

public class Electrodomestico extends Producto{

    public Integer tiempoGarantia;

    public Electrodomestico(String nombre, Double precio, String marca, Integer stockDisponible, Integer tiempoGarantia) {
        super(nombre, precio, marca, stockDisponible);
        this.tiempoGarantia = tiempoGarantia;
    }

    public Integer getTiempoGarantia() {
        return tiempoGarantia;
    }

    public void setTiempoGarantia(Integer tiempoGarantia) {
        this.tiempoGarantia = tiempoGarantia;
    }

}
