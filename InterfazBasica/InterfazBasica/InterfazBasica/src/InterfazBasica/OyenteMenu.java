/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author ishrael
 */
class OyenteMenu implements ActionListener{
    private static BarraMenu menu;

    public OyenteMenu(BarraMenu menu) {
        this.menu=menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menu.nuevoProducto) {
            //new JFrame();
        }
    
    }
    
}
