package com.TPfinal.Ventas.model.repositorie;

import com.TPfinal.Interfaces.GenericRepository;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Ventas.model.entity.Carrito;

import javax.sound.sampled.Port;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class RepositoriesVenta{
    Map<Integer,Carrito> lista= new HashMap<>();

    public RepositoriesVenta() {
    }



    public void add(Carrito data) {
        lista.put(data.getId(),data);
    }

    public Map<Integer, Carrito> getLista() {
        return lista;
    }



    public Integer max_ID(){

        int maxId = 0;

        for (Map.Entry<Integer, Carrito> entry : lista.entrySet()) {

            if (entry.getValue().getId()>maxId){
                maxId = entry.getValue().getId();
            }

        }
        return maxId;
    }
}
