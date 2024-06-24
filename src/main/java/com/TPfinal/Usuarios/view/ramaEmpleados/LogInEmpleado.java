package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.entity.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInEmpleado extends JFrame {
    private JPanel panelLogIn;
    private JTextField textFName;
    private JButton iniciarSesion1Button;
    private JButton panicoButton;
    private JPanel panelPrincipal;
    private JPasswordField passwordField1;
    private JLabel labError;
    private JButton cancelarButton;
    private JPasswordField pswdFClave;
    private JButton claveButton;
    private JPanel panelClave;
    private JLabel labErrorClave;

    public LogInEmpleado(ControllerEmpleado controllerEmpleado, ControladorUI controladorUI) {

        // frame
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        labError.setText("");


        // paneles
        add(panelPrincipal);

        panelLogIn.setVisible(true);
        panelClave.setVisible(false);


        iniciarSesion1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textFName.getText();
                String pswd = passwordField1.getText();

                if(controllerEmpleado.buscarEnInicioSesion(nombre, pswd)){
                    dispose();

                    Empleado empleado = controllerEmpleado.getRepository().search(nombre);

                    controladorUI.mostrarMenuEmpleado(empleado);


                } else {
                    labError.setText("¡Nombre o contraseña incorrectos!");
                }
            }
        });

        panicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLogIn.setVisible(false);
                panelClave.setVisible(true);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               controladorUI.mostrarlogInPrincipal();
            }
        });

        claveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pswdFClave.getText().equals("1024")){

                    Persona subAdmin1 = new Persona("admin", "administrador",
                            "hoy", 99, "1");

                    Domicilio subAdmin2 = new Domicilio("NaN", "NaN",
                            "NaN", 1, "NaN",
                            "NaN", "NaN", "NaN");

                    Empleado admin = new Empleado("Admin123", "1234",
                            "admin@gmail.com", subAdmin1, subAdmin2, "1",
                            "Ahora");

                    controllerEmpleado.getRepository().add(admin);
                    controladorUI.guardarEmpleados();

                    panelClave.setVisible(false);
                    panelLogIn.setVisible(true);

                    textFName.setText(admin.getNombreDeUsuario());
                    passwordField1.setText(admin.getPassDeUsuario());
                }
                else {
                    labErrorClave.setText("¡La clave es incorrecta!");
                }
            }
        });




    }
}
