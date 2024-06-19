package com.TPfinal.Usuarios.model.repositorie;

import com.TPfinal.Interfaces.GenericRepository;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Empleado;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RepositoriesEmpleado implements GenericRepository<Empleado,String> {

    Set<Empleado> lista = new HashSet<>();


    public Set<Empleado> getLista() {
        return lista;
    }

    public void setLista(Set<Empleado> lista) {
        this.lista = lista;
    }

    @Override
    public void add(Empleado data) {
        lista.add(data);
    }

    @Override
    public void delete(Empleado data) {
        lista.remove(data);
    }

    @Override
    public Empleado search(String identificator) {
        for (Empleado empleado : lista) {

            if (empleado.getEmail().equals(identificator) || empleado.getNombreDeUsuario().equalsIgnoreCase(identificator)) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public boolean update(Empleado data) {
        for (Empleado empleado : lista) {
            if (empleado.equals(data)) {
                lista.remove(empleado);
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
    public Iterator<Empleado> pedirIterador() {
        return lista.iterator();
    }
}
