package com.TPfinal.MenuPrincipal;

import com.TPfinal.GUI.MenuPrincipal;

public class Menu {

    public Menu() {
    }

    public void inicMenuPrincipal(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

}
