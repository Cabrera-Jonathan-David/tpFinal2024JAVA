package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEmpleado extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private JButton modDomicilioButton;
    private JButton mostrarClientesButton;
    private JButton cerrarSesionButton;
    private JButton eliminarCuentaButton;
    private JButton selButtonProductos;
    private JComboBox comboBoxProductos;
    private JComboBox comboBoxEmpleados;
    private JButton selButtonEmpleados;
    private JPanel panelClave;
    private JPasswordField pswdFClave;
    private JButton ingresarButton;
    private JButton volverButton;
    private JLabel labErrorClave;
    private JPanel domicilioPanel;
    private JTextField textFCalle;
    private JTextField textFPiso;
    private JSpinner spinnerAltura;
    private JSpinner spinnerCodPostal;
    private JTextField textFCiudad;
    private JTextField textFPartido;
    private JTextField textFPcia;
    private JTextField textFPais;
    private JButton guardarCambiosButton;
    private JButton cancelarButton;
    private JLabel labError;
    private JPanel panelBorrarCta;
    private JButton eliminarButton;
    private JButton cancelarButton1;
    private JPasswordField passwordField1;
    private JLabel labError1;
    private JPanel panelEliminar;
    private JTextField textFNick;
    private JPasswordField passwordField2;
    private JButton eliminarEmpButton;
    private JLabel labError2;
    private JButton volverButton1;

    public MenuEmpleado(ControladorUI controladorUI, ControllerEmpleado controllerEmpleado, Empleado empleado) {

        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(panelPrincipal);


        panelOpciones.setVisible(true);
        panelClave.setVisible(false);
        domicilioPanel.setVisible(false);
        panelEliminar.setVisible(false);
        panelBorrarCta.setVisible(false);




        selButtonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) comboBoxProductos.getSelectedItem();


                if(item.equals("Agregar Productos")){
                   dispose();
                   controladorUI.mostrarCrearProducto(empleado);
                }
                else if(item.equals("Eliminar Productos")){
                    dispose();
                    controladorUI.mostrarBorrarProducto(empleado);
                }
                else if(item.equals("Revisar Productos")){

                    dispose();
                    controladorUI.mostrarMostrarProducto(empleado);
                }
                else if(item.equals("Modificar Stock")){

                    dispose();
                    controladorUI.mostrarModifStock(empleado);



                }
            }
        });

        modDomicilioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(false);
                domicilioPanel.setVisible(true);
            }
        });

        mostrarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMostrarPersona(empleado);
            }
        });

        selButtonEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String item = (String) comboBoxEmpleados.getSelectedItem();

                panelOpciones.setVisible(false);
                panelClave.setVisible(true);
            }
        });

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarlogInEmpleado();
            }
        });

        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(false);
                panelBorrarCta.setVisible(true);
            }
        });


        /** panel de domicilio **/

        guardarCambiosButton.addActionListener(new ActionListener() {
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

                if (altura <= 0 || codPostal <= 0) {
                    labError.setText("¡Datos erróneos en altura o código postal!");
                } else {
                    String alt = String.valueOf(altura);

                    Domicilio dom = new Domicilio(calle, alt, piso, codPostal, ciudad, partido, provincia, pais);

                    empleado.setDomicilio(dom);

                    controladorUI.guardarEmpleados();

                    panelOpciones.setVisible(true);
                    domicilioPanel.setVisible(false);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(true);
                domicilioPanel.setVisible(false);
            }
        });



        /** panel clave **/

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pswdFClave.getText().equals("1024")){
                    panelClave.setVisible(false);

                    String item = (String) comboBoxEmpleados.getSelectedItem();

                    if(item.equals("Agregar Empleados")){
                        dispose();
                        controladorUI.mostrarRegistroEmpleado(empleado);

                        /// lleva a un frame idéntico a RegistroEmpleado

                    }
                    else if(item.equals("Eliminar Empleados")){
                        panelEliminar.setVisible(true);

                    }
                    else if(item.equals("Mostrar Empleados")){

                        dispose();
                        controladorUI.mostrarMostrarEmpleado(empleado);
                    }


                }
                else {
                    labErrorClave.setText("¡Clave incorrecta! >:(");
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelClave.setVisible(false);
                panelOpciones.setVisible(true);
            }
        });


        /** panel eliminar cta **/

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordField1.getText().equals("1024")){
                    dispose();
                    controladorUI.mostrarlogInEmpleado();
                    controllerEmpleado.getRepository().delete(empleado);

                    controladorUI.guardarEmpleados();
                }
                else{
                    labError1.setText("¡La clave es incorrecta!");
                }
            }
        });
        cancelarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBorrarCta.setVisible(false);
                panelOpciones.setVisible(true);
            }
        });

        /** panel eliminar empleado **/

        eliminarEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String nick = textFNick.getText();

                    Empleado empleado1 = controllerEmpleado.getRepository().search(nick);

                    if(empleado1 != null){

                        if(passwordField2.getText().equals("1024")){
                            controllerEmpleado.getRepository().delete(empleado1);
                            controladorUI.guardarEmpleados();
                        }
                        else {
                            labError2.setText("¡La clave es incorrecta!");
                        }

                        if(empleado1 == empleado){
                            dispose();
                            controladorUI.mostrarlogInEmpleado();
                        }
                        else {
                            panelEliminar.setVisible(false);
                            panelOpciones.setVisible(true);
                        }





                    } else {
                        labError2.setText("¡El nombre es incorrecto!");
                    }
                }

        });

        volverButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEliminar.setVisible(false);
                panelOpciones.setVisible(true);
            }
        });

    }
}
