package com.TPfinal.Archivos;


import com.TPfinal.Excepciones.ArchivoNoEncontrado;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Set;

public class ArchivoEmpleados {

    private static final String FILE_PATH = "src/main/resources/empleados.json";
    private Gson gson = new Gson();

    RepositoriesEmpleado repositoriesEmpleado;

    public ArchivoEmpleados(RepositoriesEmpleado repositoriesEmpleado) {
        this.repositoriesEmpleado = repositoriesEmpleado;
        loadArchivo();
    }

    //--------------------------------------------------------------------


    public void loadArchivo(){
        try{
            Reader r = new FileReader(FILE_PATH);
            Type listType = new TypeToken<Set<Empleado>>() {}.getType();
            Set<Empleado> empleados = gson.fromJson(r, listType);

            if(empleados != null){

                for(Empleado empleado : empleados){

                    repositoriesEmpleado.add(empleado);
                }
            }

        }catch (ArchivoNoEncontrado e){
            System.out.println(e.getMessage());
        }catch (IOException f){

            try {
                throw new IOException("Hubo un error de entrada y salida de datos en la carga del Archivo" + f);

            } catch (IOException e) {

                throw new RuntimeException("Surgio un Run Time Excepcion " + e);
            }
        }
    }

    public void saveArchivo(){

        try(Writer w = new FileWriter(FILE_PATH)){

            gson.toJson(repositoriesEmpleado.getLista(), w);

        }catch(IOException f){
            try {
                throw new IOException("Hubo un error de entrada y salida de datos mientras se guardaba en el Archivo" + f);

            } catch (IOException e) {

                throw new RuntimeException("Surgio un Run Time Excepcion " + e);
            }
        }

    }









}
