package com.TPfinal.Productos.model.repositorie;

import com.TPfinal.Interfaces.GenericRepository;
import com.TPfinal.Productos.model.entity.Producto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProductoRepositories implements GenericRepository<Producto, Integer> {

    Set<Producto> lista=new HashSet<>();

    public ProductoRepositories() {
    }

    @Override
    public void add(Producto data) {
        lista.add(data);
    }

    @Override
    public void delete(Producto data) {
        lista.remove(data);
    }

    @Override
    public Producto search(Integer identificator) {
        for (Producto producto : lista) {
            if (producto.getIdProducto().equals(identificator)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean update(Producto data) {
        for (Producto producto : lista) {
            if (producto.equals(data)) {
                lista.remove(producto);
                lista.add(data);
                return  true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public Iterator<Producto> pedirIterador() {
        return lista.iterator();
    }
}
