package com.TPfinal.Productos.model.entity;

public class Alimento extends Producto{
    private String vencimiento;

    public Alimento(String nombre, Double precio, String marca, Integer stockDisponible, String vencimiento) {
        super(nombre, precio, marca, stockDisponible);
        this.vencimiento = vencimiento;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

}
