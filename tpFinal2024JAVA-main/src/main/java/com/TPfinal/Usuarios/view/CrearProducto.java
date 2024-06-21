package com.TPfinal.Usuarios.view;



import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto extends JFrame{
    private JComboBox eleccionBox;
    private JTextField textFNombre;
    private JTextField textFMarca;
    private JTextField textFPrecio;
    private JTextField textFStock;
    private JTextField textFLabel;
    private JLabel LabelCambio;
    private JButton button1;
    private JButton button2;
    private JPanel panel;
    private JSpinner spinner1;

    public CrearProducto() {
        setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        add(panel);


        eleccionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eleccionBox.getSelectedItem() == "Electrodomesticos") {
                    LabelCambio.setText("Garantia");
                } else {
                    LabelCambio.setText("Vencimento");

                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre= textFNombre.getText();
                Double precio= Double.parseDouble(textFPrecio.getText());
                String marca= textFMarca.getText();
                Integer stock= (Integer) spinner1.getValue();

                if (eleccionBox.getSelectedItem() == "Electrodomesticos") {
                    Integer label= Integer.parseInt(textFLabel.getText());
                    new Electrodomestico(nombre,precio,marca,stock,label);

                } else {
                    String label= textFLabel.getText();
                    new Alimento(nombre,precio,marca,stock,label);
                }
                JOptionPane.showMessageDialog(null,"Producto creado");

            }
        });
    }

    public static void main(String[] args) {
        new CrearProducto();
    }
}


