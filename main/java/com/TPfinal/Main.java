package com.TPfinal;


import com.TPfinal.Archivos.*;
import com.TPfinal.Productos.control.ProductoControler;

import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;
import com.TPfinal.Ventas.model.entity.Carrito;
import com.TPfinal.Ventas.model.repositorie.RepositoriesVenta;


public class Main {
    public static void main(String[] args) {
                ///REPOS
            ProductoRepositories productoRepositories= new ProductoRepositories();
            RepositoriesEmpleado repositoriesEmpleado = new RepositoriesEmpleado();
            RepositoriesCliente repositoriesCliente = new RepositoriesCliente();
            RepositoriesVenta repositoriesVenta=new RepositoriesVenta();


                //"CONTROLERS"
            ProductoControler productoControler= new ProductoControler(productoRepositories);
            ControllerEmpleado controllerEmpleado = new ControllerEmpleado(repositoriesEmpleado);
            ControllerCliente controllerCliente = new ControllerCliente(repositoriesCliente);

                //ARCHIVOS
            ArchivoAlimentos archivoAlimentos = new ArchivoAlimentos(productoRepositories);
            ArchivoElectrodomesticos archivoElectrodomesticos = new ArchivoElectrodomesticos(productoRepositories);
            ArchivoEmpleados archivoEmpleados = new ArchivoEmpleados(repositoriesEmpleado);
            ArchivoCliente archivoCliente = new ArchivoCliente(repositoriesCliente);
            ArchivoVenta archivoVenta=new ArchivoVenta(repositoriesVenta);
                //SOLUCION AL ID STATICO CON ARCHIVOS
            new Producto(productoRepositories.max_ID());
            new Carrito(repositoriesVenta.max_ID());// IMPORTANTE QUE ESTE ANTES DE CUALQUIER COSA...........

                //CONTROLADOR DE PANELES
            ControladorUI controladorUI=new ControladorUI(productoControler, controllerCliente, controllerEmpleado,repositoriesVenta,archivoAlimentos,archivoCliente,archivoElectrodomesticos,archivoEmpleados,archivoVenta);


            //-------------------------------------------------------------------------------------------------------------


                //ARRANCA EL PROGRAMA//
            controladorUI.mostrarpantallaInicio();



    }
}