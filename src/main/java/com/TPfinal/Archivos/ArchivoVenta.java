package com.TPfinal.Archivos;

import com.TPfinal.Excepciones.ArchivoNoEncontrado;
import com.TPfinal.Ventas.model.entity.Carrito;
import com.TPfinal.Ventas.model.repositorie.RepositoriesVenta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class ArchivoVenta {

    private static final String FILE_PATH = "src/main/resources/ventas.json";
    private Gson gson = new Gson();

    RepositoriesVenta repositoriesVenta;

    public ArchivoVenta(RepositoriesVenta repositoriesVenta) {
        this.repositoriesVenta = repositoriesVenta;
        loadArchivo();
    }

  //--------------------------------------------------------------

   public void loadArchivo(){

       try{

           Reader r = new FileReader(FILE_PATH);
           Type listType = new TypeToken<Map<String, Carrito>>(){}.getType();
            Map<Integer, Carrito> carritos =gson.fromJson(r, listType);

            if(carritos != null)
            {
                for(Map.Entry<Integer, Carrito> entry : carritos.entrySet()) {

                    Carrito carrito = entry.getValue();

                        repositoriesVenta.add(carrito);

                    }

            }

       }catch(ArchivoNoEncontrado e ){

           System.out.println(e.getMessage());

        }catch(IOException f){

           try {
               throw new IOException("Hubo un error de entrada y salida de datos en la carga del Archivo" + f);

           } catch (IOException e) {

               throw new RuntimeException("Surgio un Run Time Excepcion " + e);
           }

       }

   }

    public void saveArchivo() {
        try (Writer w = new FileWriter(FILE_PATH)) {
            gson.toJson(repositoriesVenta.getLista(), w);
        } catch (IOException e) {
            throw new RuntimeException("Hubo un error de entrada y salida de datos mientras se guardaba en el Archivo", e);
        }
    }


}







