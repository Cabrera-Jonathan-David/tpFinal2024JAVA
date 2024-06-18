package com.TPfinal.Usuarios.view;


import com.TPfinal.Excepciones.EmptyDataExcepcion;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Persona;

import java.util.Scanner;

public class ViewCliente {

    Scanner scan = new Scanner(System.in);

    public Cliente crearCliente(String email, String nombreUs) throws EmptyDataExcepcion {

        System.out.println("\n---------------------------------------------------------");
        System.out.println("-------------------CREACION DE USUARIO-------------------");
        System.out.print("Ingrese una contrasenia: ");
        String pass = scan.nextLine();
        System.out.print("Numero de telefono: ");
        String telefono = scan.nextLine();

        if (nombreUs.isBlank() || pass.isBlank() || email.isBlank() || telefono.isBlank())
        {
            throw new EmptyDataExcepcion();
        }

        Persona persona = datosPersonales();


        if (persona.getNombre().isBlank() || persona.getApellido().isBlank() || persona.getFechaDeNacimiento().isBlank()
                || persona.getEdad()==null || persona.getDni().isBlank())
        {
            throw new EmptyDataExcepcion();
        }

        Domicilio domicilio = datosDomicilio();


        if (domicilio.getNombreCalle().isBlank() || domicilio.getAlturaCatastral().isBlank() ||
                domicilio.getPisoYdepartamento().isBlank() || domicilio.getCodigoPostal() == null ||
                domicilio.getNombreCiudad().isBlank() || domicilio.getPartido().isBlank() ||
                domicilio.getProvincia().isBlank() || domicilio.getPais().isBlank())
        {
            throw new EmptyDataExcepcion();
        }

        System.out.println("---------------------------------------------------------");

        return new Cliente(nombreUs, pass, email, persona, domicilio, telefono);

    }

    public Persona datosPersonales (){


        System.out.println("\n---------Datos Personales---------");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("Apellido: ");
        String apellido= scan.nextLine();
        System.out.print("Fecha de nacimiento (Dia/Mes/Anio): ");
        String fn = scan.nextLine();
        System.out.print("Edad: ");
        Integer edad = scan.nextInt();
        scan.nextLine();
        System.out.print("Numero de DNI (Sin puntos separadores): ");
        String dni = scan.nextLine();
        return new Persona(nombre, apellido, fn, edad,dni);

    }

    public Domicilio datosDomicilio(){


        System.out.println("----------Datos de envio----------");
        System.out.print("Nombre de la calle: ");
        String calle = scan.nextLine();
        System.out.print("Altura catastral: ");
        String altura = scan.nextLine();
        System.out.print("Piso y departamento (si es casa ingresar 'casa'): ");
        String pistoYdpto = scan.nextLine();
        System.out.print("Codigo Postal: ");
        Integer codPostal = scan.nextInt();
        scan.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scan.nextLine();
        System.out.print("Partido / Departamento Judicial: ");
        String partido = scan.nextLine();
        System.out.print("Provincia: ");
        String provincia = scan.nextLine();
        System.out.print("Pais: ");
        String pais = scan.nextLine();


        return  new Domicilio(calle, altura, pistoYdpto, codPostal, ciudad, partido, provincia, pais);

    }


    public String starMail()
    {

        System.out.print("\nIngrese el e-mail: ");
        return scan.nextLine();
    }

    public String starNombreUs(){
        System.out.print("\nIngrese el nombre de Usuario: ");
        return scan.nextLine();
    }

    public void usuarioInexistente()
    {
        System.out.println("No se encontro cliente con los datos ingresados");
    }

    public void mensjExito()
    {
        System.out.println("Realizado con exito....");
    }

    public void  usuarioExistente(){

        System.out.println("Nombre de Usuario Existente.");
    }

    public void emailExistente(){

        System.out.println("Email ingresado existente.");

    }

    public void mostrarUsuario (Cliente cliente)
    {
        System.out.println("------------------------------------------------");
        System.out.println("Nombre: " + cliente.getPersona().getNombre());
        System.out.println("Apellido: " + cliente.getPersona().getApellido());
        System.out.println("Edad: " + cliente.getPersona().getEdad());
        System.out.println("Fecha de Nacimiento: " + cliente.getPersona().getFechaDeNacimiento());
        System.out.println("DNI: " + cliente.getPersona().getDni());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println();
        System.out.println("Domicilio: " + cliente.getDomicilio().getNombreCalle() + " " + cliente.getDomicilio().getAlturaCatastral()
                            + "(" + cliente.getDomicilio().getPisoYdepartamento() + ")");
        System.out.println("C.P: " + cliente.getDomicilio().getCodigoPostal() + ", " + cliente.getDomicilio().getPartido());
        System.out.println("Ciudad/Provincia/Pais: " + cliente.getDomicilio().getNombreCiudad() + ", " + cliente.getDomicilio().getProvincia() +
                            ", " + cliente.getDomicilio().getPais());
        System.out.println("------------------------------------------------");

    }





}
