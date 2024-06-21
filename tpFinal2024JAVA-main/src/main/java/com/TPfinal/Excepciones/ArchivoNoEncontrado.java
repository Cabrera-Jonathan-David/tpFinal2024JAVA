package com.TPfinal.Excepciones;

import java.io.FileNotFoundException;

public class ArchivoNoEncontrado extends FileNotFoundException {

    public ArchivoNoEncontrado() {
    }

    public ArchivoNoEncontrado(String message) {
        super("Arhivo no encontrado");
    }



}
