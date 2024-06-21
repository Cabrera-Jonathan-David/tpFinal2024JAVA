package com.TPfinal.Excepciones;

public class EmptyDataExcepcion extends Exception {
    public EmptyDataExcepcion(String message) {

        super("Error: Uno de los campos requeridos está vacío o es NULL");
    }

    public EmptyDataExcepcion() {
    }
}

