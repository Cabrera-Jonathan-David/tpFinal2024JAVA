package com.TPfinal.Usuarios.Controller;

import com.TPfinal.Excepciones.EmptyDataExcepcion;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.TPfinal.Usuarios.view.ViewCliente;
import com.TPfinal.Ventas.model.entity.Carrito;

import java.util.Map;

public class ControllerCliente {

    private ViewCliente viewCliente;
    private RepositoriesCliente repositorioCliente;

    public ControllerCliente(ViewCliente viewCliente, RepositoriesCliente repositorioCliente) {
        this.viewCliente = viewCliente;
        this.repositorioCliente = repositorioCliente;
    }

    public void crearCliente() {
        String nombreUs = viewCliente.starNombreUs();
        Cliente encontrado = repositorioCliente.search(nombreUs);
        if(encontrado == null)
            {
                String email = viewCliente.starMail();
                Cliente encontrado1 = repositorioCliente.search(email);

                if(encontrado1 == null){

                    try {
                        Cliente nuevoCliente = viewCliente.crearCliente(email, nombreUs);
                        repositorioCliente.add(nuevoCliente);
                        viewCliente.mensjExito();
                    } catch (EmptyDataExcepcion e) {
                        System.out.println("Error: Se encontraron datos vacíos.");
                    }

                }else{
                    viewCliente.emailExistente();
                }
            }else {
                viewCliente.usuarioExistente();
              }
        }


    public void buscarCliente() {
        String nombreUsuario = viewCliente.starNombreUs();
        Cliente clienteEncontrado = repositorioCliente.search(nombreUsuario);
        if (clienteEncontrado != null) {
            viewCliente.mostrarUsuario(clienteEncontrado);
        } else {
            viewCliente.usuarioInexistente();
        }
    }

    public void actualizarCliente() {
        String nombreUsuario = viewCliente.starNombreUs();
        Cliente clienteEncontrado = repositorioCliente.search(nombreUsuario);
        if (clienteEncontrado != null) {
            try {
                Cliente clienteActualizado = viewCliente.crearCliente(clienteEncontrado.getEmail(), clienteEncontrado.getNombreDeUsuario());
                repositorioCliente.update(clienteActualizado);
                viewCliente.mensjExito();
            } catch (EmptyDataExcepcion e) {
                System.out.println("Error: Se encontraron datos vacíos.");
            }
        } else {
            viewCliente.usuarioInexistente();
        }
    }

    public void eliminarCliente() {
        String nombreUsuario = viewCliente.starNombreUs();
        Cliente clienteEncontrado = repositorioCliente.search(nombreUsuario);
        if (clienteEncontrado != null) {
            repositorioCliente.delete(clienteEncontrado);
            viewCliente.mensjExito();
        } else {
            viewCliente.usuarioInexistente();
        }
    }

    public void mostrarHistorialCompras(Cliente cliente) {

        System.out.println("Historial Compras");
        for (Map.Entry<String, Carrito> entry : cliente.getHistorialCompras()){

            System.out.println("---------------------------------");
            System.out.println("Id: " + entry.getKey());
            for(Producto producto : entry.getValue().getListaProductos()){



            }
            System.out.println("Total pagado: " + entry.getValue().getPrecioTotal());

    }


    }








}
