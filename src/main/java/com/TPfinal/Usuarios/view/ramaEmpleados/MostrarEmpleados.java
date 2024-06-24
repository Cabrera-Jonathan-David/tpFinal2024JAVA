package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerEmpleado;
import com.TPfinal.Usuarios.model.entity.Empleado;
import com.TPfinal.Usuarios.model.repositorie.RepositoriesEmpleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarEmpleados extends JFrame {
    private JPanel panel;
    private JComboBox comboBox1;
    private JPanel panel1;
    private JButton informacionPersonalButton;
    private JLabel VNUsuario;
    private JLabel VEmail;
    private JPanel panelInfo;
    private JLabel VNombre;
    private JLabel VApellido;
    private JLabel VNacimiento;
    private JLabel VEdad;
    private JLabel Vdni;
    private JButton informacionDeDomicilioButton;
    private JButton volverButton;
    private JLabel VCuit;
    private JPanel panelDomicilio;
    private JLabel VCalle;
    private JLabel VAltura;
    private JLabel VPiso;
    private JLabel VcodigoPostal;
    private JLabel VCiudad;
    private JLabel Vpartido;
    private JLabel VProvincia;
    private JLabel Vpais;
    private JButton salirButton;
    private JButton volverButton1;
    private JLabel VFchaC;


    public MostrarEmpleados(ControladorUI controladorUI, ControllerEmpleado controllerEmpleado,Empleado registrado){
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        add(panel);
        panel1.setVisible(true);
        panelInfo.setVisible(false);
        panelDomicilio.setVisible(false);


        for(Empleado aux: controllerEmpleado.getRepository().getLista()){
            comboBox1.addItem(aux.getNombreDeUsuario());
        }


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleado = controllerEmpleado.getRepository().search((String) comboBox1.getSelectedItem());

                VNUsuario.setText(empleado.getNombreDeUsuario());
                VEmail.setText(empleado.getEmail());

                VNombre.setText(empleado.getPersona().getNombre());
                VApellido.setText(empleado.getPersona().getApellido());
                VEdad.setText(String.valueOf(empleado.getPersona().getEdad()));
                VNacimiento.setText(empleado.getPersona().getFechaDeNacimiento());
                Vdni.setText(String.valueOf(empleado.getPersona().getDni()));
                VCuit.setText(empleado.getCuil());
                VFchaC.setText(empleado.getFechaContratacion());


                VCalle.setText(empleado.getDomicilio().getNombreCalle());
                VAltura.setText(empleado.getDomicilio().getAlturaCatastral());
                VPiso.setText(empleado.getDomicilio().getPisoYdepartamento());
                VCiudad.setText(empleado.getDomicilio().getNombreCiudad());
                VcodigoPostal.setText(String.valueOf(empleado.getDomicilio().getCodigoPostal()));
                Vpartido.setText(empleado.getDomicilio().getPartido());
                VProvincia.setText(empleado.getDomicilio().getProvincia());
                Vpais.setText(empleado.getDomicilio().getPais());


            }

        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                panelInfo.setVisible(false);
                panelDomicilio.setVisible(false);
            }
        });
        informacionDeDomicilioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                panelInfo.setVisible(false);
                panelDomicilio.setVisible(true);
            }
        });
        volverButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                panelInfo.setVisible(true);
                panelDomicilio.setVisible(false);
            }
        });
        informacionPersonalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                panelInfo.setVisible(true);
                panelDomicilio.setVisible(false);

            }
        });


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                controladorUI.mostrarMenuEmpleado(registrado);
            }
        });
    }
}

