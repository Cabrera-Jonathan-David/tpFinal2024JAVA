package com.TPfinal.Usuarios.view.ramaPrincipal;

import com.TPfinal.ControladorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame{
    private JButton continuarButton;
    private JButton salirButton;
    private JPanel panel;

    public PantallaInicio(ControladorUI controladorUI) {
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);



        add(panel);

        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();;
                controladorUI.mostrarlogInPrincipal();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
    }
}
