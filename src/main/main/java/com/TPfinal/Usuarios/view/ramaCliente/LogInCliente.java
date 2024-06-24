package com.TPfinal.Usuarios.view.ramaCliente;

import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInCliente extends JFrame {
    private JPanel panelLogIn;
    private JPanel panelLogIn1;
    private JTextField textFName;
    private JPasswordField textFPswd;
    private JLabel labelError;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;
    private JButton volverButton;

    public LogInCliente(ControllerCliente controllerCliente, ControladorUI controladorUI) {

        // frame
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        // paneles
        add(panelLogIn);

        panelLogIn1.setVisible(true);





        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nickname = textFName.getText();
                String password = textFPswd.getText();

                if (controllerCliente.buscarEnInicioSesion(nickname, password)) {
                    dispose();
                    controladorUI.mostrarMenuCliente(controllerCliente.getRepositorioCliente().search(nickname));
                }
                else{
                    JOptionPane.showMessageDialog(null,"LERRASTE MOSTRO");
                    dispose();
                    controladorUI.mostrarLogInCliente();
                }
            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarRegistroCliente();

            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarlogInPrincipal();
            }
        });





    }
}
