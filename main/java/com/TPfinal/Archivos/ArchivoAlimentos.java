package com.TPfinal.Archivos;

import com.TPfinal.Excepciones.ArchivoNoEncontrado;
import com.TPfinal.Productos.model.entity.Alimento;

import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArchivoAlimentos {

    private static final String FILE_PATH = "src/main/resources/alimentos.json";
    private Gson gson = new Gson();

    ProductoRepositories repositories;

    public ArchivoAlimentos(ProductoRepositories repositories) {
        this.repositories = repositories;
        loadArchivo();
    }

    //---------------------------------------------------------------------------------

    public void loadArchivo(){


        try (Reader r = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<Set<Alimento>>() {}.getType();
            Set<Alimento> alimentos = gson.fromJson(r, listType);

            if (alimentos != null) {
                for(Alimento alim : alimentos){

                    repositories.add(alim);

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
            Set<Alimento> alimentos= new HashSet<>();
            while(itProd.hasNext()){
                Producto producto= itProd.next();
                if (producto instanceof Alimento) {
                    alimentos.add((Alimento)producto);
                }

            }
            gson.toJson(alimentos, w);
        } catch (IOException f) {

            try {
                throw new IOException("Hubo un error de entrada y salida de datos mientras se guardaba en el Archivo" + f);

            } catch (IOException e) {

                throw new RuntimeException("Surgio un Run Time Excepcion " + e);
            }
        }
    }


}




