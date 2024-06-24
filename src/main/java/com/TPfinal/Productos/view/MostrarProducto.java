package com.TPfinal.Productos.view;

import com.TPfinal.ControladorUI;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Usuarios.model.entity.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarProducto extends JFrame {
    private JPanel panel;
    private JComboBox comboBox1;
    private JLabel LNombre;
    private JLabel LPrecio;
    private JLabel LMarca;
    private JLabel LStock;
    private JLabel LabelCambio;
    private JLabel Vnombre;
    private JLabel VPrecio;
    private JLabel VMarca;
    private JLabel VStock;
    private JLabel VLabel;
    private JLabel VId;
    private JLabel LId;
    private JButton volverButton;


    public MostrarProducto(ControladorUI controladorUI, ProductoControler productoControler, Empleado empleado){
        setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        add(panel);



        for(Producto producto: productoControler.getProductoRepositories().getLista()){

            comboBox1.addItem(producto.getNombre());
        }



        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto= productoControler.getProductoRepositories().search((String)comboBox1.getSelectedItem());

                if(producto instanceof Alimento) {

                    Alimento alimento= (Alimento) producto;
                    Vnombre.setText(alimento.getNombre());
                    VPrecio.setText(String.valueOf(alimento.getPrecio()));
                    VMarca.setText(alimento.getMarca());
                    LabelCambio.setText("Vencimiento");
                    VStock.setText(String.valueOf(alimento.getStockDisponible()));
                    VLabel.setText(alimento.getVencimiento());
                    VId.setText(String.valueOf(alimento.getIdProducto()));

                }
                else{
                    Electrodomestico electrodomestico = (Electrodomestico) producto;
                    Vnombre.setText(electrodomestico.getNombre());
                    VPrecio.setText(String.valueOf(electrodomestico.getPrecio()));
                    VMarca.setText(electrodomestico.getMarca());
                    LabelCambio.setText("Garantia");
                    VStock.setText(String.valueOf(electrodomestico.getStockDisponible()));
                    VLabel.setText(String.valueOf(electrodomestico.getTiempoGarantia()));
                    VId.setText(String.valueOf(electrodomestico.getIdProducto()));

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

