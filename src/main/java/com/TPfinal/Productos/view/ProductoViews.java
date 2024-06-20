package com.TPfinal.Productos.view;

import com.TPfinal.Excepciones.EmptyDataExcepcion;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;

import java.util.Scanner;

public class ProductoViews {
 Scanner scann= new Scanner(System.in);
    public void mostrar(Alimento alimento){

        System.out.println("=================ALIMENTO================");
        System.out.println("Id: " + alimento.getIdProducto());
        System.out.println("Nombre: " + alimento.getNombre());
        System.out.println("Precio: " + alimento.getPrecio());
        System.out.println("Vencimiento " + alimento.getVencimiento());
        System.out.println("===========================================");
    }
    public void mostrar(Electrodomestico electrodomestico){
        System.out.println("=================ELECTRODOMESTICO================");
        System.out.println("Id: " + electrodomestico.getIdProducto());
        System.out.println("Nombre: " + electrodomestico.getNombre());
        System.out.println("Precio: " + electrodomestico.getPrecio());
        System.out.println("Garantia " + electrodomestico.getTiempoGarantia()+ " Meses");
        System.out.println("=================================================");
    }

    public Integer solicitarEleccion(){
        System.out.println("Ingrese su eleccion");
        Integer num=scann.nextInt();
        scann.nextLine();
        return num;
    }
    public Integer solicitarIDEleccion(){
        System.out.println("Ingrese el Id: ");
        Integer num=scann.nextInt();
        scann.nextLine();
        return num;
    }

    public Alimento crearProductoPerecedero()throws EmptyDataExcepcion {

        System.out.println("\n------------------------------------------------------------");
        System.out.println("-------------------CREACION DE ALIMENTO-------------------");
        System.out.println("Ingrese el nombre del producto");
        String nombre= scann.nextLine();
        System.out.println("Ingrese el precio del producto");
        Double precio= scann.nextDouble();
        scann.nextLine();
        System.out.println("Ingrese la marca del producto");
        String marca= scann.nextLine();
        System.out.println("Ingrese el stock inicial del producto");
        Integer stock= scann.nextInt();
        scann.nextLine();
        System.out.println("Ingrese el vencimiento del producto");
        String vencimiento=scann.nextLine();
        if(nombre.isEmpty() || precio == null || marca.isEmpty() || stock ==null ||vencimiento.isEmpty())
        {
            throw new EmptyDataExcepcion();
        }
        return new Alimento(nombre,precio,marca,stock,vencimiento);

    }

    public Electrodomestico crearProductoHogar()throws EmptyDataExcepcion{
        System.out.println("\n------------------------------------------------------------");
        System.out.println(" ----------------CREACION DE Electrodomestico--------------");
        System.out.println("Ingrese el nombre del producto");
        String nombre= scann.nextLine();
        System.out.println("Ingrese el precio del producto");
        Double precio= scann.nextDouble();
        scann.nextLine();
        System.out.println("Ingrese la marca del producto");
        String marca= scann.nextLine();
        System.out.println("Ingrese el stock inicial del producto");
        Integer stock= scann.nextInt();
        scann.nextLine();
        System.out.println("Ingrese garantia del producto en meses");
        Integer garantia=scann.nextInt();
        scann.nextLine();
        if(nombre.isEmpty() || precio == null || marca.isEmpty() || stock ==null ||garantia==null)
        {
            throw new EmptyDataExcepcion();
        }
        return new Electrodomestico(nombre,precio,marca,stock,garantia);
    }

    public Alimento modificar(Alimento alimento){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("-------------------MODIFICAR DE PERECEDERO-------------------");
        System.out.println("Ingrese el nuevo nombre del producto");
        alimento.setNombre(scann.nextLine());
        System.out.println("Ingrese el nuevo precio del producto");
        alimento.setPrecio(scann.nextDouble());
        scann.nextLine();
        System.out.println("Ingrese la marca del producto");
        alimento.setMarca(scann.nextLine());
        System.out.println("Ingrese el stock inicial del producto");
        alimento.setStockDisponible(scann.nextInt());
        scann.nextLine();
        System.out.println("Ingrese el vencimiento del producto");
        alimento.setVencimiento(scann.nextLine());

        return alimento;
    }



    public Electrodomestico modificar(Electrodomestico electrodomestico){

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("-------------------MODIFICAR DE ELECTRODOMESTICO-------------------");
        System.out.println("Ingrese el nuevo nombre del producto");
        electrodomestico.setNombre(scann.nextLine());
        System.out.println("Ingrese el nuevo precio del producto");
        electrodomestico.setPrecio(scann.nextDouble());
        scann.nextLine();
        System.out.println("Ingrese la marca del producto");
        electrodomestico.setMarca(scann.nextLine());
        System.out.println("Ingrese el stock inicial del producto");
        electrodomestico.setStockDisponible(scann.nextInt());
        scann.nextLine();
        System.out.println("Ingrese el vencimiento del producto");
        electrodomestico.setTiempoGarantia(scann.nextInt());
        scann.nextLine();

        return electrodomestico;
    }




}
