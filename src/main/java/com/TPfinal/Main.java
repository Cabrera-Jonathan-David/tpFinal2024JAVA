package com.TPfinal;


import com.TPfinal.Archivos.ArchivoAlimentos;
import com.TPfinal.Archivos.ArchivoCliente;
import com.TPfinal.Archivos.ArchivoElectrodomesticos;
import com.TPfinal.Archivos.ArchivoEmpleados;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Productos.view.ProductoViews;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;
import com.TPfinal.Usuarios.view.ViewCliente;
import com.TPfinal.Usuarios.view.ViewEmpleado;




public class Main {
    public static void main(String[] args) {

        //ViewCliente viewCliente= new ViewCliente();
        //RepositoriesCliente repositoriesCliente= new RepositoriesCliente();
        //RepositoriesEmpleado repositoriesEmpleado= new RepositoriesEmpleado();
        ProductoRepositories productoRepositories= new ProductoRepositories();
        ProductoViews productoViews= new ProductoViews();
        ProductoControler productoControler= new ProductoControler(productoViews,productoRepositories);
        ArchivoAlimentos archivoAlimentos = new ArchivoAlimentos(productoRepositories);
        ArchivoElectrodomesticos archivoElectrodomesticos = new ArchivoElectrodomesticos(productoRepositories);
        ViewCliente viewCliente = new ViewCliente();
        ViewEmpleado viewEmpleado = new ViewEmpleado();
        RepositoriesEmpleado repositoriesEmpleado = new RepositoriesEmpleado();
        ControllerEmpleado controllerEmpleado = new ControllerEmpleado(viewEmpleado, repositoriesEmpleado);
        ArchivoEmpleados archivoEmpleados = new ArchivoEmpleados(repositoriesEmpleado);
        RepositoriesCliente repositoriesCliente = new RepositoriesCliente();
        ControllerCliente controllerCliente = new ControllerCliente(viewCliente, repositoriesCliente);
        ArchivoCliente archivoCliente = new ArchivoCliente(repositoriesCliente);
        new Producto(productoRepositories.max_ID()); // IMPORTANTE QUE ESTE ANTES DE CUALQUIER COSA...........
//-------------------------------------------------------------------------------------------------------------




       //SAVE ARCHIVOS

        archivoElectrodomesticos.saveArchivo();
        archivoCliente.saveArchivo();
        archivoAlimentos.saveArchivo();
        archivoEmpleados.saveArchivo();


    }
}