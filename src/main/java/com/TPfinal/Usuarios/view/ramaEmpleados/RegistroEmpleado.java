package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.entity.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class RegistroEmpleado extends JFrame {
    private JPanel panelPrincipal;
    private JTextField textFNick;
    private JTextField textFCUIL;
    private JTextField textFEmail;
    private JTextField textFEdad;
    private JButton continuarButton;
    private JButton cancelarButton;
    private JSpinner spinner1Dia;
    private JSpinner spinner1Mes;
    private JSpinner spinner1Anio;
    private JPasswordField passwordField1;
    private JTextField textFNombre;
    private JTextField textFApellido;
    private JTextField textFDNI;
    private JSpinner spinner2Dia;
    private JSpinner spinner2Mes;
    private JSpinner spinner2Anio;
    private JButton continuarButton1;
    private JButton cancelarButton1;
    private JTextField textFCalle;
    private JSpinner spinnerAltura;
    private JTextField textFPiso;
    private JSpinner spinnerCP;
    private JTextField textFCiudad;
    private JTextField textFPartido;
    private JTextField textFPcia;
    private JTextField textFPais;
    private JLabel labError1;
    private JLabel labError2;
    private JButton finalizarButton;
    private JLabel labError3;
    private JButton cancelarButton2;
    private JPanel panelDatosBasicos;
    private JPanel panelPersona;
    private JPanel panelDomicilio;
    private JLabel labEdad;
    private JButton verificarEdadButton;


    Empleado empleado = new Empleado();

    LocalDate fechaActual = LocalDate.now();

    Integer edad = null;

    public RegistroEmpleado(ControladorUI controladorUI, ControllerEmpleado controllerEmpleado, Empleado aux) {

        // frame
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        // paneles
        add(panelPrincipal);

        panelDatosBasicos.setVisible(true);
        panelPersona.setVisible(false);
        panelDomicilio.setVisible(false);

        labError1.setText("");
        labError2.setText("");
        labError3.setText("");



        // botones


        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nickname = textFNick.getText();
                String email = textFEmail.getText();
                String cuil = textFCUIL.getText();

                int dia = (int) spinner1Dia.getValue();
                int mes = (int) spinner1Mes.getValue();
                int anio = (int) spinner1Anio.getValue();
                String contratacion = anio + "-" + mes + "-" + dia;

                String pswd = passwordField1.getText();

                Empleado aux = controllerEmpleado.buscarEmpleadoExistente(nickname, email);

                if (aux != null) {
                    labError1.setText("¡Nombre o email ya está registrado por otro usuario!");

                } else if(dia <= 0 || dia > 31 || (dia> 28 && mes == 2) ||
                            (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11 ))){
                    labError2.setText("¡La fecha ingresada es incorrecta!");
                }
                else if(mes > 12 || mes < 1){
                    labError2.setText("¡La fecha ingresadoa es incorrecta!");
                }
                else if (anio > 2024 || anio < 1924){
                    labError2.setText("¡La fecha ingresada es incorrecta!");
                } else {
                    empleado.setNombreDeUsuario(nickname);
                    empleado.setEmail(email);
                    empleado.setCuil(cuil);
                    empleado.setFechaContratacion(contratacion);
                    empleado.setPassDeUsuario(pswd);

                    panelDatosBasicos.setVisible(false);
                    panelPersona.setVisible(true);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(aux);
            }
        });



        continuarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFNombre.getText();
                String apellido = textFApellido.getText();
                String dni  = textFDNI.getText();

                int dia = (int) spinner2Dia.getValue();
                int mes = (int) spinner2Mes.getValue();
                int anio = (int) spinner2Anio.getValue();
                String fechaNac = dia + "-" + mes + "-" + anio;

                Date date = new Date(anio-1900, mes-1, dia);


                LocalDate nacimiento = date.toInstant().atZone(
                        ZoneId.systemDefault()).toLocalDate();



                Period period = Period.between(nacimiento, fechaActual);
                edad = period.getYears();

                Persona persona = new Persona(nombre, apellido, fechaNac, edad, dni);

                if(nombre == null || apellido == null || dni == null){
                    labError2.setText("¡Campos incompletos!");
                }
                else if(dia <= 0 || dia > 31 || (dia> 28 && mes == 2) ||
                        (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11 ))){
                    labError2.setText("¡La fecha ingresada es incorrecta!");
                }
                else if(mes > 12 || mes < 1){
                    labError2.setText("¡La fecha ingresadoa es incorrecta!");
                }
                else if(anio < 1700){
                    labError2.setText("Muy gracioso, ¡pero nadie vive tanto!");
                }
                else if (anio > 2024 || anio < 1924){
                    labError2.setText("¡La fecha ingresada es incorrecta!");
                }
                else{
                    empleado.setPersona(persona);

                    panelPersona.setVisible(false);
                    panelDomicilio.setVisible(true);
                }


            }
        });
        cancelarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(aux);
            }
        });

        verificarEdadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dia = (int) spinner2Dia.getValue();
                int mes = (int) spinner2Mes.getValue();
                int anio = (int) spinner2Anio.getValue();
                String fechaNac = dia+ "/" + mes + "/" + anio;

                Date date = new Date(anio-1900, mes-1, dia);
                LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                Period period = Period.between(date1, fechaActual);
                edad = period.getYears();


                labEdad.setText("" + edad);
            }
        });


        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String calle = textFCalle.getText();
                Integer altura = (Integer) spinnerAltura.getValue();
                String piso = textFPiso.getText();
                Integer codPostal = (Integer) spinnerCP.getValue();
                String ciudad = textFCiudad.getText();
                String partido = textFPartido.getText();
                String provincia = textFPcia.getText();
                String pais = textFPais.getText();

                if(altura <= 0 || codPostal <= 0) {
                    labError3.setText("¡Datos erróneos en altura o código postal!");
                }
                else {
                    String alt = String.valueOf(altura);

                    Domicilio dom = new Domicilio(calle, alt, piso, codPostal, ciudad, partido, provincia, pais);


                    empleado.setDomicilio(dom);

                    controllerEmpleado.getRepository().add(empleado);
                    controladorUI.guardarEmpleados();

                    dispose();
                    controladorUI.mostrarMenuEmpleado(aux);
                }



            }
        });
        cancelarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(aux);
            }
        });

    }




}
