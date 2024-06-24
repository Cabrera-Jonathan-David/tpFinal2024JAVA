package com.TPfinal.Usuarios.model.entity;

public class Domicilio {

    private String nombreCalle;
    private String alturaCatastral;
    private String pisoYdepartamento;
    private Integer codigoPostal;
    private String nombreCiudad;
    private String partido;
    private String provincia;
    private String pais;

//-----------------------------------------------------------------------------------


    public Domicilio(String nombreCalle, String alturaCatastral, String pisoYdepartamento, Integer codigoPostal, String nombreCiudad, String partido, String provincia, String pais) {
        this.nombreCalle = nombreCalle;
        this.alturaCatastral = alturaCatastral;
        this.pisoYdepartamento = pisoYdepartamento;
        this.codigoPostal = codigoPostal;
        this.nombreCiudad = nombreCiudad;
        this.partido = partido;
        this.provincia = provincia;
        this.pais = pais;
    }

//---------------------------------------------------------------------------------


    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public String getAlturaCatastral() {
        return alturaCatastral;
    }

    public void setAlturaCatastral(String alturaCatastral) {
        this.alturaCatastral = alturaCatastral;
    }

    public String getPisoYdepartamento() {
        return pisoYdepartamento;
    }

    public void setPisoYdepartamento(String pisoYdepartamento) {
        this.pisoYdepartamento = pisoYdepartamento;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
