package com.TPfinal.Usuarios.view.ramaPrincipal;

import com.TPfinal.ControladorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPrincipal extends JFrame {
    private JComboBox comboBox1;
    private JButton ingresarButton;
    private JButton volverButton;
    private JPanel panel;






    public LogInPrincipal(ControladorUI controladorUI) {

        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        add(panel);





        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(comboBox1.getSelectedItem() == "Cliente"){
                dispose();
                controladorUI.mostrarLogInCliente();
              }else{
                  dispose();
                  controladorUI.mostrarlogInEmpleado();

              }

            }
        });


    }



}



