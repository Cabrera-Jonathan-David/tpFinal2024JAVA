package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarPersona extends JFrame{
    private JComboBox<String> comboBox1;
    private JButton informacionPersonalButton;
    private JLabel VNUsuario;
    private JLabel VEmail;
    private JLabel VNombre;
    private JLabel VApellido;
    private JLabel VNacimiento;
    private JLabel VEdad;
    private JLabel Vdni;
    private JButton informacionDeDomicilioButton;
    private JButton volverButton;
    private JPanel panel1;
    private JPanel panelInfo;
    private JPanel panelDomicilio;
    private JLabel VTelefono;
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
    private JPanel panel;

    public MostrarPersona(ControladorUI controladorUI, ControllerCliente controllerCliente, Empleado empleado) {
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        add(panel);
        panel1.setVisible(true);
        panelInfo.setVisible(false);
        panelDomicilio.setVisible(false);



        for(Cliente cliente: controllerCliente.getRepositorioCliente().getLista()){
            comboBox1.addItem(cliente.getNombreDeUsuario());
        }


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = controllerCliente.getRepositorioCliente().search((String) comboBox1.getSelectedItem());

                VNUsuario.setText(cliente.getNombreDeUsuario());
                VEmail.setText(cliente.getEmail());

                VNombre.setText(cliente.getPersona().getNombre());
                VApellido.setText(cliente.getPersona().getApellido());
                VEdad.setText(String.valueOf(cliente.getPersona().getEdad()));
                VNacimiento.setText(cliente.getPersona().getFechaDeNacimiento());
                Vdni.setText(String.valueOf(cliente.getPersona().getDni()));
                VTelefono.setText(cliente.getTelefono());

                VCalle.setText(cliente.getDomicilio().getNombreCalle());
                VAltura.setText(cliente.getDomicilio().getAlturaCatastral());
                VPiso.setText(cliente.getDomicilio().getPisoYdepartamento());
                VCiudad.setText(cliente.getDomicilio().getNombreCiudad());
                VcodigoPostal.setText(String.valueOf(cliente.getDomicilio().getCodigoPostal()));
                Vpartido.setText(cliente.getDomicilio().getPartido());
                VProvincia.setText(cliente.getDomicilio().getProvincia());
                Vpais.setText(cliente.getDomicilio().getPais());


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
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(empleado);
            }
        });
    }
}