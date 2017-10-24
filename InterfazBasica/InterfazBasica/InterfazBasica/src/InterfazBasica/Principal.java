/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import javax.swing.*;

/**
 *
 * @author ishrael
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame principal = new JFrame("Punto de venta");
        ModeloTablaVenta mtmv = new ModeloTablaVenta();
        ModeloTablaProducto mtmp = new ModeloTablaProducto();
        PanelPrincipal panelprincipal = new PanelPrincipal(mtmv, mtmp);
        BarraMenu menu = new BarraMenu(mtmp);
        OyentePrincipal oyente = new OyentePrincipal(panelprincipal);

        OyenteMenu oyenteMenu = new OyenteMenu(menu);
        panelprincipal.addEventos(oyente);
        //menu.addEventos(oyenteMenu);

        principal.setSize(650, 350);
        principal.setResizable(false);
        principal.setLocation(100, 100);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setJMenuBar(menu.createMenuBar());
        principal.setContentPane(panelprincipal);
        principal.setVisible(true);
    }

}
