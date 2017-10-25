/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 12312312312312312asd
 */
package InterfazBasica;

import InterfazBasica.Persona;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author AGI_1
 */
public class Agenda {

   
    Vector vector = new Vector();
    Persona persona = new Persona();
    
    
    public void GuardarPersona(Persona persona) {
        if(vector.add(persona)){
            JOptionPane.showMessageDialog(null,"se registro con exito los datos");
        }
    }
    public String MostrarAgenda(){
        String Linea="",Linea2;
        
        for(int x=0;x<vector.size();x++){
        persona=(Persona)vector.get(x);
        Linea2=persona.Nombre+"  -  "+persona.Telefono+"  -  "+persona.Lugar+"  -  "+persona.Direccion;
        
        Linea=Linea+Linea2+"\n";
    }
        return Linea;
    }
}
