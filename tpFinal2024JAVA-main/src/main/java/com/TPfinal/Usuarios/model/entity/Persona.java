package com.TPfinal.Usuarios.model.entity;

public class Persona {

    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;
    private Integer edad;
    private String dni;

    //----------------------------------------------------------------------------------

    public Persona(String nombre, String apellido, String fechaDeNacimiento, Integer edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.edad = edad;
        this.dni = dni;
    }

    //----------------------------------------------------------------------------------


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
