/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author omar
 */
class ModeloTablaProducto extends AbstractTableModel{

    private ArrayList<Register> list = new ArrayList<Register>();

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }


    public void addRegister(String producto, double precio, String unidad){
        list.add(new Register(producto, precio, unidad));
        this.fireTableDataChanged();
    }

      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Register r = list.get(rowIndex);
        switch (columnIndex) {
        case 0: return r.producto; 
        case 1: return r.precio;
        case 2: return r.unidad; 
        }
            return null;
    }

    class Register{
        String producto;
        double precio;
        String unidad;

        public Register(String producto, double precio, String unidad) {
            this.producto = producto;
            this.precio = precio;
            this.unidad = unidad;
        }
    }

}
