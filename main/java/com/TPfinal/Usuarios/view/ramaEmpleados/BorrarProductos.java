package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.Archivos.ArchivoAlimentos;
import com.TPfinal.ControladorUI;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrarProductos extends JFrame{


    private JComboBox comboBox1;
    private JButton borrarButton;
    private JButton salirButton;
    private JLabel VStock;
    private JPanel panel1;
    private JPanel panel;

    public BorrarProductos(ControladorUI controladorUI, ProductoControler productoControler, Empleado empleado) {
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);




        add(panel);
        panel1.setVisible(true);




        for (Producto producto : productoControler.getProductoRepositories().getLista()) {
            comboBox1.addItem(producto.getNombre());
        }

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Producto producto = productoControler.getProductoRepositories().search((String) comboBox1.getSelectedItem());
                    VStock.setText(String.valueOf(producto.getStockDisponible()));
                }
            });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = productoControler.getProductoRepositories().search((String) comboBox1.getSelectedItem());
                productoControler.getProductoRepositories().delete(producto);

                controladorUI.guardarAlimentos();
                controladorUI.guardarElectrodomesticos();


                JOptionPane.showMessageDialog(null,"Producto Borrado");



                dispose();
                controladorUI.mostrarBorrarProducto(empleado);
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
