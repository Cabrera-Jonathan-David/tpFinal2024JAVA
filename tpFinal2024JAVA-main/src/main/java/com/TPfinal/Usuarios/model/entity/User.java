package com.TPfinal.Usuarios.model.entity;



import java.util.Objects;

public abstract class User {

    private String nombreDeUsuario;
    private String passDeUsuario;
    private String email;
    private Persona persona;
    private Domicilio domicilio;

    public User(String nombreDeUsuario, String passDeUsuario, String email, Persona persona, Domicilio domicilio) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.passDeUsuario = passDeUsuario;
        this.email = email;
        this.persona = persona;
        this.domicilio = domicilio;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getPassDeUsuario() {
        return passDeUsuario;
    }

    public void setPassDeUsuario(String passDeUsuario) {
        this.passDeUsuario = passDeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
