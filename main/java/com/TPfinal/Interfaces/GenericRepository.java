package com.TPfinal.Interfaces;


import com.TPfinal.Usuarios.model.entity.Cliente;

import java.util.Iterator;

// D de value es para el indentificador que usamos para buscar
public interface GenericRepository<T,D>{


    void add(T data);
    void delete(T data);
    T search(D identificator);
    boolean update(T data);
    int size();
    Iterator<T> pedirIterador();}
