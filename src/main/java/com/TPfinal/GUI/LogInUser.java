package com.TPfinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInUser extends JFrame{
    private JPanel panelCliente;
    private JButton volverButton;
    private JPanel panelPrincipal;

    public LogInUser() {

        setLocationRelativeTo(null);
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(panelCliente);
        panelPrincipal.setVisible(true);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPrincipal().setVisible(true);

            }
        });
    }
}
