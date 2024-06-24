package com.TPfinal.Archivos;

import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.TPfinal.Excepciones.ArchivoNoEncontrado;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArchivoElectrodomesticos {

    private static final String FILE_PATH = "src/main/resources/electrodomesticos.json";
    private Gson gson = new Gson();

    ProductoRepositories repositories;

    public ArchivoElectrodomesticos(ProductoRepositories repositories) {
        this.repositories = repositories;
        loadArchivo();
    }

    //---------------------------------------------------------------------------------

    public void loadArchivo(){


        try (Reader r = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<Set<Electrodomestico>>() {}.getType();
            Set<Electrodomestico> electro = gson.fromJson(r, listType);

            if (electro != null) {
                for(Electrodomestico elec : electro){

                    repositories.getLista().add(elec);

                }
            }

        } catch (ArchivoNoEncontrado e) {
            System.out.println(e.getMessage());
        } catch (IOException f) {

            try {
                throw new IOException("Hubo un error de entrada y salida de datos en la carga del Archivo" + f);

            } catch (IOException e) {

                throw new RuntimeException("Surgio un Run Time Excepcion " + e);
            }
        }

    }

    public void saveArchivo() {
        try (Writer w = new FileWriter(FILE_PATH)) {

            Iterator<Producto> itProd= repositories.pedirIterador();
            Set<Electrodomestico> electrodomesticos= new HashSet<>();
            while(itProd.hasNext()){
                Producto producto= itProd.next();
                if (producto instanceof Electrodomestico) {
                    electrodomesticos.add((Electrodomestico) producto);
                }
            }
            gson.toJson(electrodomesticos, w);
        } catch (IOException f) {
            try {
                throw new IOException("Hubo un error de entrada y salida de datos mientras se guardaba en el Archivo" + f);

            } catch (IOException e) {

                throw new RuntimeException("Surgio un Run Time Excepcion " + e);
            }
        }


    }














}
