package com.TPfinal.Usuarios.view.ramaCliente;

import com.TPfinal.Archivos.ArchivoCliente;
import com.TPfinal.ControladorUI;
import com.TPfinal.Usuarios.Controller.ControllerCliente;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Usuarios.model.entity.Domicilio;
import com.TPfinal.Ventas.model.entity.Carrito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MenuCliente extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private JButton comprarButton;
    private JButton modDomicilioButton;
    private JButton ultimas10ComprasButton;
    private JButton cerrarSesionButton;
    private JButton eliminarCuentaButton;

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
    private JPanel domicilioPanel;
    private JPanel eliminarPanel;
    private JButton confirmarButton;
    private JPasswordField passwordField1;
    private JLabel labError;
    private JPanel historialPanel;
    private JLabel labCpa1;
    private JLabel labCpa1Monto;
    private JLabel labCpa2;
    private JLabel labCpa3;
    private JLabel labCpa4;
    private JLabel labCpa5;
    private JLabel labCpa6;
    private JLabel labCpa7;
    private JLabel labCpa8;
    private JLabel labCpa9;
    private JLabel labCpa10;
    private JLabel labCpa2Monto;
    private JLabel labCpa3Monto;
    private JLabel labCpa4Monto;
    private JLabel labCpa5Monto;
    private JLabel labCpa6Monto;
    private JLabel labCpa7Monto;
    private JLabel labCpa8Monto;
    private JLabel labCpa9Monto;
    private JLabel labCpa10Monto;
    private JButton volverButton;
    private JLabel labError2;
    private JButton cancelarButton1;


    public MenuCliente(ControladorUI controladorUI, ControllerCliente controllerCliente, Cliente cliente) {

        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(panelPrincipal);
        panelOpciones.setVisible(true);
        domicilioPanel.setVisible(false);
        eliminarPanel.setVisible(false);
        historialPanel.setVisible(false);

        /** panel opciones **/
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarVentas(cliente);
            }
        });

        modDomicilioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(false);
                domicilioPanel.setVisible(true);

                textFCalle.setText("");
                spinnerAltura.setValue((Object)0);
                textFPiso.setText("");
                spinnerCodPostal.setValue((Object)0);
                textFCiudad.setText("");
                textFPartido.setText("");
                textFPcia.setText("");
                textFPais.setText("");
            }
        });

        ultimas10ComprasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(false);
                historialPanel.setVisible(true);

                labCpa1.setText("");
                labCpa1Monto.setText("");

                labCpa2.setText("");
                labCpa2Monto.setText("");

                labCpa3.setText("");
                labCpa3Monto.setText("");

                labCpa4.setText("");
                labCpa4Monto.setText("");

                labCpa5.setText("");
                labCpa5Monto.setText("");

                labCpa6.setText("");
                labCpa6Monto.setText("");

                labCpa7.setText("");
                labCpa7Monto.setText("");

                labCpa8.setText("");
                labCpa8Monto.setText("");

                labCpa9.setText("");
                labCpa9Monto.setText("");

                labCpa10.setText("");
                labCpa10Monto.setText("");

                Map<Integer, Carrito> lista = cliente.getHistorialCompras();
                int i = 0;

                for (Map.Entry<Integer, Carrito> carritoEntry : lista.entrySet()) {




                    Integer key = carritoEntry.getKey();
                    Double value = carritoEntry.getValue().getPrecioTotal();

                    i ++;

                    if(i > 10){
                        break;
                    }
                    else {
                        switch (i) {
                            case 1:
                                labCpa1.setText("ID: " + key);
                                labCpa1Monto.setText("Monto total: " + value);
                                break;
                            case 2:
                                labCpa2.setText("ID: " + key);
                                labCpa2Monto.setText("Monto total: " + value);
                                break;
                            case 3:
                                labCpa3.setText("ID: " + key);
                                labCpa3Monto.setText("Monto total: " + value);
                                break;
                            case 4:
                                labCpa4.setText("ID: " + key);
                                labCpa4Monto.setText("Monto total: " + value);
                                break;
                            case 5:
                                labCpa5.setText("ID: " + key);
                                labCpa5Monto.setText("Monto total: " + value);
                                break;
                            case 6:
                                labCpa6.setText("ID: " + key);
                                labCpa6Monto.setText("Monto total: " + value);
                                break;
                            case 7:
                                labCpa7.setText("ID: " + key);
                                labCpa7Monto.setText("Monto total: " + value);
                                break;
                            case 8:
                                labCpa8.setText("ID: " + key);
                                labCpa8Monto.setText("Monto total: " + value);
                                break;
                            case 9:
                                labCpa9.setText("ID: " + key);
                                labCpa9Monto.setText("Monto total: " + value);
                                break;
                            case 10:
                                labCpa10.setText("ID: " + key);
                                labCpa10Monto.setText("Monto total: " + value);
                                break;
                            default: break;
                        }
                    }
                }
            }
        });

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarLogInCliente();
            }
        });

        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(false);
                eliminarPanel.setVisible(true);
            }
        });



        /** panel domicilio **/
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

                    cliente.setDomicilio(dom);

                    controladorUI.guardarClientes();

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



        /** panel eliminar **/

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(passwordField1.getText().equals(cliente.getPassDeUsuario())){
                    controllerCliente.getRepositorioCliente().delete(cliente);

                    controladorUI.guardarClientes();

                    dispose();
                    controladorUI.mostrarLogInCliente();
                }
                else{
                    labError2.setText("¡La contraseña es incorrecta!");
                }

            }
        });

        cancelarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(true);
                eliminarPanel.setVisible(false);
            }
        });


        /** panel historial**/
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpciones.setVisible(true);
                historialPanel.setVisible(false);
            }
        });
    }

}
