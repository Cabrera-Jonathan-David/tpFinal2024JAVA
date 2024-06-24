package com.TPfinal.Productos.view;


import com.TPfinal.ControladorUI;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto extends JFrame{

    private JPanel panel;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField tnombre;
    private JTextField tprecio;
    private JTextField tmarca;
    private JSpinner spinner1;
    private JTextField tmodify;
    private JButton cancelarButton;
    private JPanel panel2;
    private JButton confirmarButton;
    private JLabel precio;
    private JLabel marca;
    private JLabel stock;
    private JLabel nombre;
    private JLabel cambio;
    private JButton aceptarButton;
    private JSpinner spinner2;
    private JLabel labelError;
    private JTextField tstockAd;
    private Producto producto;
    public CrearProducto(ControladorUI controladorUI, ProductoControler productoControler, Empleado empleado) {
        setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        add(panel);

        panel1.setVisible(true);
        panel2.setVisible(false);

labelError.setText("");
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem() == "Electrodomesticos") {
                    cambio.setText("Garantia");
                } else {
                    cambio.setText("Vencimento");
                }
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= tnombre.getText();
                Double precio= Double.parseDouble(tprecio.getText());
                String marca= tmarca.getText();
                Integer stock= (Integer)spinner1.getValue();
                producto = productoControler.comprobarExistencia(nombre);
                if(producto==null) {

                    if (comboBox1.getSelectedItem() == "Electrodomesticos") {
                        Integer label = Integer.parseInt(tmodify.getText());
                        producto=new Electrodomestico(nombre, precio, marca, stock,label);

                    } else {
                        String label = tmodify.getText();
                        producto= new Alimento(nombre, precio, marca, stock, label);

                    }
                    productoControler.getProductoRepositories().add(producto);

                    JOptionPane.showMessageDialog(null,"Producto creado");
                    dispose();
                    controladorUI.mostrarCrearProducto(empleado);

                }else{

                panel2.setVisible(true);
                panel1.setVisible(false);
                }


            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer cantidadProducto= (Integer)spinner2.getValue();
                if(cantidadProducto>=0){
                productoControler.modificarStock(producto,cantidadProducto);
                JOptionPane.showMessageDialog(null,"Stock del producto aumentado");
                dispose();
                controladorUI.mostrarCrearProducto(empleado);
            }else{
                labelError.setText("No se puede añadir productos negativos");
                }
            }


        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(empleado);

            }
        });
    }



}


