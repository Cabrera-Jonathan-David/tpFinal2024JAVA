package com.TPfinal;


import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Productos.view.ProductoViews;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;
import com.TPfinal.Usuarios.view.ViewCliente;


public class Main {
    public static void main(String[] args) {

        //ViewCliente viewCliente= new ViewCliente();
        //RepositoriesCliente repositoriesCliente= new RepositoriesCliente();
        //RepositoriesEmpleado repositoriesEmpleado= new RepositoriesEmpleado();
        ProductoRepositories productoRepositories= new ProductoRepositories();
        ProductoViews productoViews= new ProductoViews();
        ProductoControler productoControler= new ProductoControler(productoViews,productoRepositories);

        //Producto fideo= new Alimento("Fideos",23,"Lucheti",14,"Mañana");
        //Producto heladera= new Electrodomestico("Heladera",200,"TAICHI",3,40);
        //Producto lasana= new Alimento("Lasana",55,"Lucheti",11,"PasadoManana");

        //productoRepositories.add(fideo);
        //productoRepositories.add(heladera);
        //productoRepositories.add(lasana);

        productoControler.nuevoProducto();
        productoControler.nuevoProducto();
        productoControler.nuevoProducto();
        productoControler.mostrarAll();
    }
}