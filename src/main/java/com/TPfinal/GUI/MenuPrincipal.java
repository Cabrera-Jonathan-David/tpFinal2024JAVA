package com.TPfinal.GUI;

import com.TPfinal.Usuarios.model.repositorie.RepositoriesCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelPortada;
    private JButton avanzarButton;
    private JPanel panelMenuInicio;
    private JButton cambiarFrameButton;


    public MenuPrincipal() {


        setLocationRelativeTo(null);
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);



        add(panelPrincipal);

        panelPortada.setVisible(true);
        panelMenuInicio.setVisible(false);



        avanzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPortada.setVisible(false);
                panelMenuInicio.setVisible(true);
            }
        });


        cambiarFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LogInUser().setVisible(true);

            }
        });
    }
/*
    public static void main(String[] args) {




        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });


    }*/



}
