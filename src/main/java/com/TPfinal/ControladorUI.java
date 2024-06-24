package com.TPfinal;

import com.TPfinal.Archivos.*;
import com.TPfinal.Productos.control.ProductoControler;

import com.TPfinal.Productos.view.CrearProducto;
import com.TPfinal.Productos.view.MostrarProducto;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.TPfinal.Usuarios.view.ramaCliente.LogInCliente;
import com.TPfinal.Usuarios.view.ramaCliente.MenuCliente;
import com.TPfinal.Usuarios.view.ramaEmpleados.*;
import com.TPfinal.Usuarios.view.ramaPrincipal.LogInPrincipal;
import com.TPfinal.Usuarios.view.ramaPrincipal.PantallaInicio;
import com.TPfinal.Ventas.model.repositorie.RepositoriesVenta;
import com.TPfinal.Ventas.view.Ventas;

public class ControladorUI {
    ControllerCliente controllerCliente;
    ProductoControler productoControler;
    ControllerEmpleado controllerEmpleado;
    RepositoriesVenta repositoriesVenta;
    ArchivoAlimentos archivoAlimentos;
    ArchivoCliente archivoCliente;
    ArchivoElectrodomesticos archivoElectrodomesticos;
    ArchivoEmpleados archivoEmpleados;
    ArchivoVenta archivoVenta;
    public ControladorUI(ProductoControler productoControler, ControllerCliente controllerCliente, ControllerEmpleado controllerEmpleado,RepositoriesVenta
            repositoriesVenta,ArchivoAlimentos archivoAlimentos,ArchivoCliente archivoCliente,ArchivoElectrodomesticos archivoElectrodomesticos,ArchivoEmpleados archivoEmpleados, ArchivoVenta archivoVenta) {

        this.productoControler = productoControler;
        this.controllerCliente = controllerCliente;
        this.controllerEmpleado= controllerEmpleado;
        this.repositoriesVenta= repositoriesVenta;
        this.archivoAlimentos=  archivoAlimentos;
        this.archivoCliente=archivoCliente;
        this.archivoElectrodomesticos=archivoElectrodomesticos;
        this.archivoEmpleados=archivoEmpleados;
        this.archivoVenta= archivoVenta;
    }

    public void mostrarMostrarPersona(Empleado empleado){
        MostrarPersona mostrarPersona=new MostrarPersona(this,controllerCliente,empleado);
        mostrarPersona.setVisible(true);

    }

    public  void mostrarRegistroCliente(){
        RegistroCliente registroCliente=new RegistroCliente(this,controllerCliente);
        registroCliente.setVisible(true);
    }

    public void mostrarMenuCliente(Cliente cliente){
        MenuCliente menuCliente=new MenuCliente(this,controllerCliente,cliente);
        menuCliente.setVisible(true);
    }


    public void mostrarpantallaInicio(){
        PantallaInicio pantallaInicio=new PantallaInicio(this);
        pantallaInicio.setVisible(true);
    }


    public void mostrarlogInPrincipal(){
        LogInPrincipal logInPrincipal=new LogInPrincipal(this);
        logInPrincipal.setVisible(true);
    }

    public void mostrarlogInEmpleado(){
        LogInEmpleado logInEmpleado= new LogInEmpleado(controllerEmpleado,this);
    logInEmpleado.setVisible(true);
    }

    public void mostrarBorrarProducto(Empleado empleado){
        BorrarProductos borrarProductos=new BorrarProductos(this,productoControler,empleado);
        borrarProductos.setVisible(true);
    }

    public void mostrarRegistroEmpleado(Empleado empleado){
        RegistroEmpleado registroEmpleado=new RegistroEmpleado(this,controllerEmpleado,empleado);
        registroEmpleado.setVisible(true);
    }


    public void mostrarLogInCliente(){
        LogInCliente logInCliente=new LogInCliente(controllerCliente,this);
        logInCliente.setVisible(true);

    }

    public void mostrarMostrarProducto(Empleado empleado){
        MostrarProducto mostrarProducto= new MostrarProducto(this,productoControler,empleado);
       mostrarProducto.setVisible(true);
    }


    public void mostrarMostrarEmpleado(Empleado empleado){
        MostrarEmpleados mostrarEmpleados=new MostrarEmpleados(this,controllerEmpleado,empleado);
        mostrarEmpleados.setVisible(true);
    }

    public void mostrarMenuEmpleado(Empleado empleado){
        MenuEmpleado menuEmpleado= new MenuEmpleado(this,controllerEmpleado,empleado);
        menuEmpleado.setVisible(true);
    }

    public void mostrarCrearProducto(Empleado empleado){
        CrearProducto crearProducto=new CrearProducto(this,productoControler,empleado);
        crearProducto.setVisible(true);
    }

    public void mostrarVentas(Cliente cliente){
        Ventas ventas=new Ventas(this,productoControler,repositoriesVenta,cliente);
        ventas.setVisible(true);
    }

    public void mostrarModifStock(Empleado empleado){
        ModificarStock modificarStock=new ModificarStock(this,productoControler,empleado);
        modificarStock.setVisible(true);
    }


    //////////////
    public void guardarAlimentos(){
        archivoAlimentos.saveArchivo();
    }

    public void guardarClientes(){
        archivoCliente.saveArchivo();
    }

    public void guardarElectrodomesticos(){
        archivoElectrodomesticos.saveArchivo();
    }

    public void guardarEmpleados(){
        archivoEmpleados.saveArchivo();
    }

    public void guardarVentas(){
        archivoVenta.saveArchivo();
    }

}
