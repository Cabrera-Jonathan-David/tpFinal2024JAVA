package com.TPfinal.Archivos;

import com.TPfinal.Excepciones.ArchivoNoEncontrado;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Set;

public class ArchivoCliente {

    private static final String FILE_PATH = "src/main/resources/clientes.json";
    private Gson gson = new Gson();

    RepositoriesCliente repositoriesCliente;

    public ArchivoCliente(RepositoriesCliente repositoriesCliente) {
        this.repositoriesCliente = repositoriesCliente;
        loadArchivo();
    }

    //-------------------------------------------------------------------------------

    public void loadArchivo(){
        try{
                Reader r = new FileReader(FILE_PATH);
                Type listType = new TypeToken<Set<Cliente>>() {}.getType();
                Set<Cliente> clientes = gson.fromJson(r, listType);

                if(clientes != null){

                    for(Cliente cliente : clientes){

                        repositoriesCliente.add(cliente);
                    }

                }

        }catch (ArchivoNoEncontrado e){
            e.getMessage();
        }catch (IOException f){
            f.printStackTrace();
        }
    }

        public void saveArchivo(){

            try(Writer w = new FileWriter(FILE_PATH)){

                gson.toJson(repositoriesCliente.getLista(), w);

            }catch(IOException e){
                e.printStackTrace();
            }

        }





    }

