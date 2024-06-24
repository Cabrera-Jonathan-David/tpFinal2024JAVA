package com.TPfinal.Ventas.view;

import com.TPfinal.ControladorUI;
import com.TPfinal.Productos.control.ProductoControler;
import com.TPfinal.Productos.model.entity.Alimento;
import com.TPfinal.Productos.model.entity.Electrodomestico;
import com.TPfinal.Productos.model.entity.Producto;
import com.TPfinal.Productos.model.repositorie.ProductoRepositories;
import com.TPfinal.Usuarios.model.entity.Cliente;
import com.TPfinal.Ventas.model.entity.Carrito;
import com.TPfinal.Ventas.model.repositorie.RepositoriesVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

public class Ventas extends JFrame{
    private JPanel panel;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton añadirButton;
    private JLabel VProducto;
    private JButton realizarCompraButton;
    private JButton salirButton;
    private JPanel panelAñadir;
    private JComboBox comboBox2;
    private JButton seleccionarButton;
    private JButton volverButton;
    private JLabel precioLabel;
    private JButton verCarroButton;
    private JPanel panelCarro;
    private JButton volverButton1;



    Producto x = new Producto();
    public Ventas(ControladorUI controladorUI, ProductoControler productoControler, RepositoriesVenta repositoriesVenta, Cliente registrado) {
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        add(panel);
        precioLabel.setText("");
        panel1.setVisible(true);
        panelAñadir.setVisible(false);

        ProductoRepositories aux = new ProductoRepositories();



        for(Producto producto: productoControler.getProductoRepositories().getLista()){
            if(producto.getStockDisponible()>0){
            comboBox1.addItem(producto.getNombre());}
        }

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto y= productoControler.getProductoRepositories().search((String) comboBox1.getSelectedItem());
                precioLabel.setText("Precio: "+ y.getPrecio());

            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aux.search((String) comboBox1.getSelectedItem())!= null){
                    x= aux.search((String) comboBox1.getSelectedItem());
                    Integer l = productoControler.getProductoRepositories().search((String) comboBox1.getSelectedItem()).getStockDisponible();
                    for(int i = 1; i<=l; i++){
                        comboBox2.addItem(String.valueOf(i));
                    }

                }else {
                    x = productoControler.getProductoRepositories().search((String) comboBox1.getSelectedItem());
                    for(int i=1; i<=x.getStockDisponible();i++){
                        comboBox2.addItem(String.valueOf(i));
                    }
                }
                panel1.setVisible(false);
                panelAñadir.setVisible(true);

            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer a= Integer.parseInt((String) comboBox2.getSelectedItem());
                if(x instanceof Alimento){
                    aux.delete(x);

                    Producto auxilar = new Alimento(x.getNombre(),x.getPrecio(),x.getMarca(),a,((Alimento) x).getVencimiento());
                    aux.add(auxilar);
                }else{
                    aux.delete(x);
                    Producto auxilar = new Electrodomestico(x.getNombre(),x.getPrecio(),x.getMarca(),a,((Electrodomestico) x).tiempoGarantia );
                    aux.add(auxilar);
                }

                comboBox2.removeAllItems();
                panel1.setVisible(true);
                panelAñadir.setVisible(false);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                panelAñadir.setVisible(false);
            }
        });
        realizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Iterator <Producto> iterator = aux.pedirIterador();
                LinkedList<Producto> lista= new LinkedList<>();
                Double total=0.0;
                while(iterator.hasNext()){
                    Producto producto=iterator.next();
                    total= total+(producto.getPrecio()*producto.getStockDisponible());
                    lista.add(producto);
                }

//
                Carrito carrito=new Carrito(total);
                carrito.setListaProductos(lista);
                registrado.agregarAlHistorial(carrito);
                repositoriesVenta.add(carrito);
//
                /// modifica el stock en el repo
                for(Producto producto: carrito.getListaProductos()){
                    Producto aux= productoControler.getProductoRepositories().search(producto.getNombre());
                    aux.setStockDisponible(aux.getStockDisponible()-producto.getStockDisponible());
                    productoControler.getProductoRepositories().update(aux);
                }

                        ////
                controladorUI.guardarVentas();
                controladorUI.guardarAlimentos();
                controladorUI.guardarElectrodomesticos();
                controladorUI.guardarClientes();
                dispose();
                controladorUI.mostrarMenuCliente(registrado);
            }
        });


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                controladorUI.mostrarMenuCliente(registrado);
            }
        });
    }


}
