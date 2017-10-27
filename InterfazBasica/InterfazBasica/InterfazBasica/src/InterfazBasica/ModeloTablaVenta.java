/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
//hola ya lo corregi :3
/**
 *
 * @author omar
 */
class ModeloTablaVenta extends AbstractTableModel{

    private ArrayList<Register> list = new ArrayList<Register>();

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void setValueCantidad(int cantidadNueva,int row){
        String p =(String) this.getValueAt(row, 1);
        double pr =(double) this.getValueAt(row, 2);
        String u =(String) this.getValueAt(row, 3);
        
        list.set(row, new Register(cantidadNueva,p, pr, u));
        this.fireTableDataChanged();
    }


    public void addRegister(int cantidad,String producto, double precio, String unidad){
        list.add(new Register(cantidad,producto, precio, unidad));
        this.fireTableDataChanged();
    }

      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Register r = list.get(rowIndex);
        switch (columnIndex) {
        case 0: return r.cantidad;
        case 1: return r.producto; 
        case 2: return r.precio;
        case 3: return r.unidad; 
        }
            return null;
    }

    void removeRow(int fsel) {
        list.remove(fsel);
        this.fireTableDataChanged();
    }

    class Register{
        int cantidad;
        String producto;
        double precio;
        String unidad;

        public Register(int cantidad,String producto, double precio, String unidad) {
            this.cantidad=cantidad;
            this.producto = producto;
            this.precio = precio;
            this.unidad = unidad;
        }
    }
}
