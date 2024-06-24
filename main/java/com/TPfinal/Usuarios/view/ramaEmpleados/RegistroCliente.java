package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroCliente extends JFrame {

    private JPanel panelPrincipal;

    /** 1/3 **/
    private JPanel panelInfoBasica;
    private JTextField textFName;
    private JTextField textFTelef;
    private JTextField textFEmail;
    private JTextField textFEdad;
    private JPasswordField passwordField1;
    private JButton continuarButton;
    private JButton cancelarButton;
    private JLabel labError;


    /** 2/3 **/
    private JPanel datosPersonales;
    private JTextField textFNomReal;
    private JTextField textFApellido;
    private JTextField textFDNI;
    private JSpinner spinnerAnio;
    private JSpinner spinnerMes;
    private JSpinner spinnerDia;
    private JButton continuarButton2;
    private JButton cancelarButton1;
    private JLabel labError2;


    /** 3/3 **/
    private JPanel domicilio;
    private JTextField textFCalle;
    private JTextField textFPiso;
    private JTextField textFCiudad;
    private JTextField textFPartido;
    private JTextField textFPcia;
    private JTextField textFPais;
    private JSpinner spinnerAltura;
    private JSpinner spinnerCodPostal;
    private JButton finalizarButton;
    private JButton cancelarButton2;
    private JLabel labError3;

    Cliente cliente = new Cliente("", "", "", null, null, "");
    Integer edad;

    public RegistroCliente(ControladorUI controladorUI, ControllerCliente controllerCliente) {

        // frame
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        // paneles
        add(panelPrincipal);

        panelInfoBasica.setVisible(true);
        datosPersonales.setVisible(false);
        domicilio.setVisible(false);

        labError.setText("");
        labError2.setText("");
        labError3.setText("");



        // botones
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nickname = textFName.getText();
                String email = textFEmail.getText();
                String telefono = textFTelef.getText();
                edad = Integer.parseInt(textFEdad.getText());
                String pswd = passwordField1.getText();

                Cliente aux = controllerCliente.buscarClienteExistente(nickname, email);

                if(aux != null){
                    labError.setText("¡Nombre o email ya está registrado por otro usuario!");

                }
                else if(!(edad instanceof Integer) || edad < 18){
                    if (edad >= 18 || edad > 100) {
                        labError.setText("¡Eres menor de edad o la edad es errónea!");

                    }
                    else {
                        labError.setText("¡Debes ser mayor de edad para poder registrarte!");

                    }
                } else {
                    cliente.setNombreDeUsuario(nickname);
                    cliente.setEmail(email);
                    cliente.setTelefono(telefono);
                    cliente.setPassDeUsuario(pswd);

                    panelInfoBasica.setVisible(false);
                    datosPersonales.setVisible(true);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarLogInCliente();
            }
        });



        continuarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFNomReal.getText();
                String apellido = textFApellido.getText();
                String dni  = textFDNI.getText();

                int dia = (int) spinnerDia.getValue();
                int mes = (int) spinnerMes.getValue();
                int anio = (int) spinnerAnio.getValue();


                String fechaNac = dia+ "/" + mes + "/" + anio;

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
                    cliente.setPersona(persona);

                    datosPersonales.setVisible(false);
                    domicilio.setVisible(true);
                }


            }
        });
        cancelarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarLogInCliente();
            }
        });


        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String calle = textFCalle.getText();
                Integer altura = (Integer) spinnerAltura.getValue();
                String piso = textFPiso.getText();
                Integer codPostal = (Integer) spinnerCodPostal.getValue();
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


                    cliente.setDomicilio(dom);



                    controllerCliente.getRepositorioCliente().add(cliente);

                    controladorUI.guardarClientes();

                    dispose();
                    controladorUI.mostrarLogInCliente();
                }



            }
        });
        cancelarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarLogInCliente();
            }
        });

    }




}
