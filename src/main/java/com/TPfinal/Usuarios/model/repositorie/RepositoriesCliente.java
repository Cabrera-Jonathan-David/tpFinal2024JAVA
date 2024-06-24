package com.TPfinal.Usuarios.model.repositorie;

import com.TPfinal.Interfaces.GenericRepository;
import com.TPfinal.Usuarios.model.entity.Cliente;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RepositoriesCliente implements GenericRepository<Cliente, String> {

    Set<Cliente> lista = new HashSet<>();

    public Set<Cliente> getLista() {
        return lista;
    }

    public void setLista(Set<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public void add(Cliente data) {
        lista.add(data);
    }

    @Override
    public void delete(Cliente data) {
        lista.remove(data);
    }

    @Override
    public Cliente search(String identificator) {

            for (Cliente cliente : lista) {

                ///Puede ser Username
                if (cliente.getEmail().equals(identificator) || cliente.getNombreDeUsuario().equalsIgnoreCase(identificator)) {
                    return cliente;
                }
            }
            return null;
        }


    @Override
    public boolean update(Cliente data) {

        for (Cliente cliente : lista) {
            if (cliente.equals(data)) {
                lista.remove(cliente);
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
    public Iterator<Cliente> pedirIterador() {
        return lista.iterator();
    }

    public Cliente buscarPorNombre(String nombre){

        for(Cliente cliente : lista){
            if(cliente.getNombreDeUsuario().equals(nombre)){
                return cliente;
            }
        }
        return null;
    }
}

