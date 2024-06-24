package com.TPfinal.Usuarios.model.entity;


import com.TPfinal.Ventas.model.entity.Carrito;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends User {

    private String telefono;
    private Map<Integer, Carrito> historialCompras;

    public Cliente(String nombreDeUsuario, String passDeUsuario, String email, Persona persona, Domicilio domicilio, String telefono) {
        super(nombreDeUsuario, passDeUsuario, email, persona, domicilio);
        this.telefono = telefono;
        this.historialCompras = new HashMap<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Map<Integer, Carrito> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(Map<Integer, Carrito> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public void agregarAlHistorial(Carrito carrito){

        this.historialCompras.put(carrito.getId(), carrito);

    }

    public void eliminarDelHistorial(Carrito carrito){

        this.historialCompras.remove(carrito.getId());

    }

    public void addCompra(Carrito carrito){
        historialCompras.put(carrito.getId(), carrito);
    }



}
