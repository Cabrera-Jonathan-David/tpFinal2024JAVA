package com.TPfinal.Usuarios.Controller;

import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;


public class ControllerEmpleado {


    private RepositoriesEmpleado repository;

    public ControllerEmpleado(RepositoriesEmpleado repository) {
        this.repository = repository;
    }

    public RepositoriesEmpleado getRepository() {
        return repository;
    }

    public boolean buscarEnInicioSesion(String nombreUs, String password){
        Empleado empleado = this.repository.search(nombreUs);

        if(empleado != null && empleado.getPassDeUsuario().equals(password)){
            return true;
        }
        return false;
    }

    public Empleado buscarEmpleadoExistente(String nombreUs, String email) {

        Empleado empleadoEncontrado = repository.search(nombreUs);
        if (empleadoEncontrado != null) {
            return empleadoEncontrado;
        }else{
            empleadoEncontrado = repository.search(email);

            if (empleadoEncontrado != null)
            {
                return empleadoEncontrado;
            }
        }
        return null;
    }










}