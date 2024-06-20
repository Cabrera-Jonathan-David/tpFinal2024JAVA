package com.TPfinal.Productos.control;

import com.TPfinal.Excepciones.EmptyDataExcepcion;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Productos.view.ProductoViews;

import java.util.Iterator;

public class ProductoControler {
    ProductoViews productoViews;
    ProductoRepositories productoRepositories;

    public ProductoControler(ProductoViews productoViews, ProductoRepositories productoRepositories) {
        this.productoViews = productoViews;
        this.productoRepositories = productoRepositories;
    }


    public void nuevoProducto(){
        System.out.println();
        System.out.println("=================================================");
        System.out.println("        Que tipo de producto desea añadir"+ "\n" +
                            "        1: Perecedero"+ "\n" +
                            "        2: Electrodomestico");
        try {
            Integer eleccion = productoViews.solicitarEleccion();

            if (eleccion == 1) {
                productoRepositories.add(productoViews.crearProductoPerecedero());
            } else if (eleccion == 2) {
                productoRepositories.add(productoViews.crearProductoHogar());
            }else{
                System.out.println("Opcion incorrecta");
            }
        }catch (EmptyDataExcepcion error){
            System.out.println(error.getMessage());
        }

    }

    public void mostrarAll(){

        Iterator<Producto>  itProd= productoRepositories.pedirIterador();
        while(itProd.hasNext()){
            Producto productoprueba= itProd.next();
            if (productoprueba instanceof Electrodomestico) {
                productoViews.mostrar((Electrodomestico) productoprueba);
            }else{
                productoViews.mostrar((Alimento) productoprueba);
            }
        }

    }

    public void modificarProducto(){
        Producto productoprueba= productoRepositories.search(productoViews.solicitarIDEleccion());

        if (productoprueba instanceof Electrodomestico) {
            productoprueba=productoViews.modificar((Electrodomestico) productoprueba);
        }else if(productoprueba instanceof Alimento){
            productoprueba=productoViews.modificar((Alimento) productoprueba);
        }else{
            System.out.println("No existe el producto a modificar");
        }
    }

    public void eliminarProducto(){
        Producto productoprueba= productoRepositories.search(productoViews.solicitarEleccion());
        if(productoprueba!=null){
            productoRepositories.delete(productoprueba);
        }else {
            System.out.println("No exsite el producto buscado para eliminar");
        }
    }
}
