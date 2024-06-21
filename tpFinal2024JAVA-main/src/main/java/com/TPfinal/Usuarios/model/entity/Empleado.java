package com.TPfinal.Usuarios.model.entity;


public class Empleado extends User {

    private String cuil;
    private String fechaContratacion;

    public Empleado(String nombreDeUsuario, String passDeUsuario, String email, Persona persona, Domicilio domicilio, String cuil, String fechaContratacion) {
        super(nombreDeUsuario, passDeUsuario, email, persona, domicilio);
        this.cuil = cuil;
        this.fechaContratacion = fechaContratacion;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
