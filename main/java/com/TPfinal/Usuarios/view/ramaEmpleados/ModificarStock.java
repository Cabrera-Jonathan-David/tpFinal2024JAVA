package com.TPfinal.Usuarios.view.ramaEmpleados;

import com.TPfinal.ControladorUI;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarStock extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox comboBoxProductos;
    private JSpinner spinnerStock;
    private JButton agregarStockButton;
    private JButton quitarStockButton;
    private JButton volverButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel labMensaje;
    private JTextField textField1;
    private JLabel labStock;

    public ModificarStock(ControladorUI controladorUI, ProductoControler productoControler, Empleado empleado) {

        setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panelPrincipal);
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);

        for(Producto producto : productoControler.getProductoRepositories().getLista()){
            comboBoxProductos.addItem(producto.getNombre());
        }


        comboBoxProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto =productoControler.getProductoRepositories()
                        .search((String)comboBoxProductos.getSelectedItem());

                if(producto != null){
                    labStock.setText("Stock: " + producto.getStockDisponible());
                }


            }
        });

        agregarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Producto producto =productoControler.getProductoRepositories().search((String)comboBoxProductos.getSelectedItem());

                if(producto != null) {
                    int stockExtra = (int) spinnerStock.getValue();


                    if(stockExtra >= 0){
                        producto.setStockDisponible(producto.getStockDisponible() + stockExtra);

                        controladorUI.guardarAlimentos();
                        controladorUI.guardarElectrodomesticos();

                        labMensaje.setText("¡El stock se ha aumentado con éxito!");
                        labStock.setText("Stock: " + producto.getStockDisponible());
                    } else {
                        labMensaje.setText("¡Cantidad incorrecta ingresada!");
                    }
                }
            }
        });

        quitarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto =productoControler.getProductoRepositories()
                        .search((String)comboBoxProductos.getSelectedItem());

                if(producto != null) {
                    int stockExtra = (int) spinnerStock.getValue();


                    if(stockExtra >= 0){
                        if(stockExtra < producto.getStockDisponible()){
                            producto.setStockDisponible(producto.getStockDisponible() - stockExtra);

                            controladorUI.guardarAlimentos();
                            controladorUI.guardarElectrodomesticos();

                            labMensaje.setText("¡El stock se ha disminuido con éxito!");
                            labStock.setText("Stock: " + producto.getStockDisponible());
                        } else {
                            labMensaje.setText("¡El stock mínimo es 1!");
                        }
                    }
                    else {
                        labMensaje.setText("¡Cantidad incorrecta ingresada!");
                    }
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuEmpleado(empleado);

            }
        });

    }
}
