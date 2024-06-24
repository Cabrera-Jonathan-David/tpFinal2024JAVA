package com.TPfinal.Excepciones;

import java.io.FileNotFoundException;

public class ArchivoNoEncontrado extends FileNotFoundException {

    public ArchivoNoEncontrado() {
    }

    public ArchivoNoEncontrado(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "No se ha podido encontrar el archivo" + super.getMessage();
    }
}
