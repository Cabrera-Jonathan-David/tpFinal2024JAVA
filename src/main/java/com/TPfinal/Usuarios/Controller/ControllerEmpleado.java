package com.TPfinal.Usuarios.Controller;

import com.TPfinal.Excepciones.EmptyDataExcepcion;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.entity.Persona;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;
import com.TPfinal.Usuarios.view.ViewEmpleado;

import java.util.Iterator;

public class ControllerEmpleado {

    private ViewEmpleado view;
    private RepositoriesEmpleado repository;

    public ControllerEmpleado(ViewEmpleado view, RepositoriesEmpleado repository) {
        this.view = view;
        this.repository = repository;
    }

    public void crearEmpleado() {

        String nombreUs = view.starNombreUs();
        Empleado buscar = repository.search(nombreUs);

        if(buscar == null)
        {
            String email = view.starMail();
            Empleado empleado1 = repository.search(email);

            if (empleado1 == null){

                try {

                    Empleado empleado = view.crearEmpleado(email, nombreUs);
                    repository.add(empleado);
                    view.mensjExito();
                } catch (EmptyDataExcepcion e) {
                    System.out.println("Debe completar todos los datos obligatorios.");
                }

            }else {
                view.emailExistente();
            }

        }else {
            view.usuarioExistente();
        }

    }

    public void buscarEmpleadoPorEmail() {
        String email = view.starMail();
        Empleado empleado = repository.search(email);
        if (empleado != null) {
            view.mostrarUsuario(empleado);
        } else {
            view.usuarioInexistente();
        }
    }

    public void mostrarAllEmpleados(){


        for(Empleado empleado : repository.getLista()){

            view.mostrarUsuario(empleado);

        }


    }

    public void modificarEmpleado() {
        String email = view.starMail();
        Empleado empleado = repository.search(email);
        if (empleado != null) {
            try {
                Empleado nuevoEmpleado = view.crearEmpleado(empleado.getEmail(), empleado.getNombreDeUsuario());
                if (nuevoEmpleado != null) {
                    if (repository.update(nuevoEmpleado)) {
                        view.mensjExito();
                    } else {
                        System.out.println("Error al actualizar el empleado.");
                    }
                }
            } catch (EmptyDataExcepcion e) {
                System.out.println("Debe completar todos los datos obligatorios.");
            }
        } else {
            view.usuarioInexistente();
        }
    }

    public Empleado loginEmpleado() {
        String nombreUs = view.starNombreUs();
        String pass = view.pedirContrasenia();

        Empleado empleadoEncontrado = repository.search(nombreUs);
        if (empleadoEncontrado != null && empleadoEncontrado.getPassDeUsuario().equals(pass)) {
            return empleadoEncontrado;
        } else {
            view.mostrarMensajeLoginFallido();
            return null;
        }
    }





}