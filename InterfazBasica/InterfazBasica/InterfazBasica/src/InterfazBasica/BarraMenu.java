/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;



import java.awt.event.*;
import javax.swing.*;
import InterfazBasica.indeu;
import javax.swing.JOptionPane;

/**
 *
 * @author ishrael
 */
public class BarraMenu {
     JMenuBar menuBar;
        JMenu producto, acercaDe;
        JMenuItem nuevoProducto,ingresarDatos,venderProducto;
 
public JMenuBar createMenuBar() {
 
       
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the File Menu.
        producto = new JMenu("Producto");
        menuBar.add(producto);
 
        //a group of JMenuItems
        nuevoProducto = new JMenuItem("Nuevo Producto...");
        producto.add(nuevoProducto);

        venderProducto = new JMenuItem("Vender Producto...");
        producto.add(venderProducto);
 
        //Build Edit menu in the menu bar.
        acercaDe = new JMenu("Acerca de");
        ingresarDatos = new JMenuItem("Ingresar Datos...");
        acercaDe.add(ingresarDatos);
        menuBar.add(acercaDe);
        
        //para darle algun evento al menu
        ingresarDatos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                //mande a llamar mi JFrame uqe ya tenia hecho llamado indeu y lo mostre
               new indeu().setVisible(true);
            }
        });       
        return menuBar;
}
public void addEventos(OyenteMenu oyente) {
        nuevoProducto.addActionListener(oyente);
        ingresarDatos.addActionListener(oyente);
        venderProducto.addActionListener(oyente);
    }
    }

    

