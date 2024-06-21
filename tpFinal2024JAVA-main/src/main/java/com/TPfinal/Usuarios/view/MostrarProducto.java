package com.TPfinal.Usuarios.view;

import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;

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

    public MostrarProducto(){
        setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        add(panel);


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //falta extraer productos de una lista
                if(comboBox1.getModel() instanceof Alimento) {
                    Alimento producto = (Alimento) comboBox1.getModel();
                    Vnombre.setText(producto.getNombre());
                    VPrecio.setText(String.valueOf(producto.getPrecio()));
                    VMarca.setText(producto.getMarca());
                    LabelCambio.setText("Vencimiento");
                    VStock.setText(String.valueOf(producto.getVencimiento()));
                    VLabel.setText(producto.getVencimiento());
                    VId.setText(String.valueOf(producto.getIdProducto()));
                }
                else{
                    Electrodomestico producto= (Electrodomestico) comboBox1.getModel();
                    Vnombre.setText(producto.getNombre());
                    VPrecio.setText(String.valueOf(producto.getPrecio()));
                    VMarca.setText(producto.getMarca());
                    LabelCambio.setText("Garantia");
                    VStock.setText(String.valueOf(producto.getStockDisponible()));
                    VLabel.setText(String.valueOf(producto.getTiempoGarantia()));
                    VId.setText(String.valueOf(producto.getIdProducto()));
                }
            }
        });

    }

    public static void main(String[] args) {
        new MostrarProducto();
    }
}

