package com.TPfinal.Usuarios.Controller;


import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;



public class ControllerCliente {


    private RepositoriesCliente repositorioCliente;



    public ControllerCliente(RepositoriesCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }



    public RepositoriesCliente getRepositorioCliente() {
        return repositorioCliente;
    }

    public Cliente buscarClienteExistente(String nombreUs, String email) {

        Cliente clienteEncontrado = repositorioCliente.search(nombreUs);
        if (clienteEncontrado != null) {
            return clienteEncontrado;
        }else{
            clienteEncontrado = repositorioCliente.search(email);

            if (clienteEncontrado != null)
            {
                return clienteEncontrado;
            }
        }
        return null;
    }






    public boolean buscarEnInicioSesion(String nombreUs, String password){
        Cliente cliente = this.repositorioCliente.buscarPorNombre(nombreUs);

        if(cliente != null && cliente.getPassDeUsuario().equals(password)){
            return true;
        }
        return false;
    }



}
