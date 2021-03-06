/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import static InterfazBasica.conexion.con;

import java.awt.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ishrael
 */
public class PanelPrincipal extends javax.swing.JPanel {

    private final ModeloTablaVenta mtmv;
    private final ModeloTablaProducto mtmp;
    private TableRowSorter trsFiltro;
    double total;

    /**
     * Creates new form PanelPrinc
     */
    public PanelPrincipal(ModeloTablaVenta mtmv, ModeloTablaProducto mtmp) {
        initComponents();
        iniTablaProducto();
        obtenerCategoria();
        this.mtmp = mtmp;
        this.mtmv = mtmv;

        /*TablaProducto.setModel(mtmp);
        TablaProducto.getColumn("A").setHeaderValue("producto");
        TablaProducto.getColumn("B").setHeaderValue("precio");
        TablaProducto.getColumn("C").setHeaderValue("unidad");*/
        TablaVenta.setModel(mtmv);
        TablaVenta.getColumn("A").setHeaderValue("cantidad");
        TablaVenta.getColumn("B").setHeaderValue("producto");
        TablaVenta.getColumn("C").setHeaderValue("precio");
        TablaVenta.getColumn("D").setHeaderValue("unidad");

        /* mtmp.addRegister("Manzana", 10.0, "kg.","Frutas");
        mtmp.addRegister("Mango", 12.0, "kg.","Frutas");
        mtmp.addRegister("Naranja", 30.0, "kg.","Frutas");
        mtmp.addRegister("Uva", 55.0, "kg.","Frutas");*/
    }

    public void obtenerCategoria() {
        boolean flag = true;
        String categoria;
        for (int i = 0; i <= TablaProducto.getRowCount() - 1; i++) {
            categoria = (String) TablaProducto.getValueAt(i, 4);
            for (int j = 0; j <= Categorias.getItemCount() - 1; j++) {
                if (categoria == Categorias.getItemAt(i)) {
                    flag = false;
                }
            }
            if (flag) {
                Categorias.addItem(categoria);
            }
        }

    }

    public void filtro() {
        int columnaABuscar = 1;
        if (comboFiltro.getSelectedItem() == "producto") {
            columnaABuscar = 1;
        }

        if (comboFiltro.getSelectedItem().toString() == "precio") {
            columnaABuscar = 2;
        }
        if (comboFiltro.getSelectedItem() == "unidad") {
            columnaABuscar = 3;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(txtFiltro.getText(), columnaABuscar));
    }

    private void iniTablaProducto() {
        String q = "select CantidadProducto, NombreProducto, UnidadProducto, PrecioProducto,CategoriaProducto from producto";

        TablaProducto.setModel(conexion.consultaToJtable(q));
        TablaProducto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < TablaProducto.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) TablaProducto.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width = 0;

            TableCellRenderer renderer = col.getHeaderRenderer();
            if (renderer == null) {
                renderer = TablaProducto.getTableHeader().getDefaultRenderer();
            }
            Component comp = renderer.getTableCellRendererComponent(TablaProducto, col.getHeaderValue(), false,
                    false, 0, 0);
            width = comp.getPreferredSize().width;

            col.setPreferredWidth(width + 80);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        Total = new javax.swing.JLabel();
        PrecioTotal = new javax.swing.JLabel();
        ImprimirTicket = new javax.swing.JButton();
        agregarProducto = new javax.swing.JButton();
        comboFiltro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        eliminarProducto = new javax.swing.JButton();
        Categorias = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaProducto);

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Precio", "Unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaVenta);

        Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Total.setText("TOTAL:");

        PrecioTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PrecioTotal.setText("$ 0.0");

        ImprimirTicket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ImprimirTicket.setText("Cobrar");
        ImprimirTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirTicketActionPerformed(evt);
            }
        });

        agregarProducto.setText("Agregar producto");
        agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoActionPerformed(evt);
            }
        });

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "producto", "unidad", "precio" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        eliminarProducto.setText("Eliminar Producto");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        Categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorias", "Verduras", "Frutas", "Abarrotes", "Medicina", "Ropa", "Calzado", "Accesorios", " " }));
        Categorias.setToolTipText("");
        Categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ImprimirTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(425, 425, 425))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(agregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarProducto)
                        .addGap(27, 27, 27)
                        .addComponent(Total)
                        .addGap(18, 18, 18)
                        .addComponent(PrecioTotal)
                        .addGap(18, 18, 18)
                        .addComponent(ImprimirTicket)
                        .addGap(361, 361, 361))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ImprimirTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirTicketActionPerformed
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss aa");
        Ticket ticket = new Ticket();
        ticket.AddCabecera("RESTAURANTE XXXX");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("EXPEDIDO EN: ----------");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("AV. TAMAULIPAS NO. 5 LOC. 101");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera(ticket.DibujarLinea(29));
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("LIMA, XXXXXXXXXXXX");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddCabecera("RFC: CSI-020226-MV4");
        ticket.AddCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("Caja # 1 - Ticket # 1");
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("LE ATENDIO: JUAN");
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera("" + fecha.format(date) + " " + hora.format(date));
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddSubCabecera(ticket.DibujarLinea(29));
        ticket.AddSubCabecera(ticket.DarEspacio());
        ticket.AddItem("1", "Articulo Prueba", "15.00");
        ticket.AddItem("", "", ticket.DarEspacio());
        ticket.AddItem("2", "Articulo Prueba", "25.00");
        ticket.AddItem("", "", ticket.DarEspacio());
        ticket.AddTotal("", ticket.DibujarLinea(29));
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("SUBTOTAL", "29.75");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("IVA", "5.25");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("TOTAL", "35.00");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("RECIBIDO", "50.00");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("CAMBIO", "15.00");
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddTotal("", ticket.DarEspacio());
        ticket.AddPieLinea(ticket.DibujarLinea(29));
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea("EL xxx ES NUESTRA PASION...");
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea("VIVE LA EXPERIENCIA EN xxx");
        ticket.AddPieLinea(ticket.DarEspacio());
        ticket.AddPieLinea("Gracias por su visita");
        ticket.AddPieLinea(ticket.DarEspacio());
        Ticket.ImprimirDocumento();
    }//GEN-LAST:event_ImprimirTicketActionPerformed

    private void agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductoActionPerformed
        try {
            int row = TablaProducto.getSelectedRow();
            int cantidad = 1;

            boolean flag = true;
            int contador = 0;
            int cantidadAnterior = 0;
            String producto = TablaProducto.getValueAt(row, 1).toString();
            double precio = (double) TablaProducto.getValueAt(row, 2);
            String unidad = TablaProducto.getValueAt(row, 3).toString();

            for (int i = 0; i <= mtmv.getRowCount() - 1; i++) {
                if (producto == TablaVenta.getValueAt(i, 1)) {
                    flag = false;
                    contador = i;
                    cantidadAnterior = (int) TablaVenta.getValueAt(i, 0);
                }
            }
            if (flag == true) {
                mtmv.addRegister(cantidad, producto, precio, unidad);
            } else {
                cantidadAnterior = cantidadAnterior + 1;
                mtmv.setValueCantidad(cantidadAnterior, contador);
                flag = true;
            }
            total = total + precio;
            PrecioTotal.setText("$ " + total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error no se pudo añadir la fila", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_agregarProductoActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped

        // TODO add your handling code here:
        txtFiltro.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtFiltro.getText());
                txtFiltro.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(TablaProducto.getModel());
        TablaProducto.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoActionPerformed
        // TODO add your handling code here:
        int fsel;
        int resp;

        try {
            fsel = TablaVenta.getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "seleccione un producto para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {
                resp = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar " + mtmv.getValueAt(fsel, 1), "eliminar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    total = total - (double) mtmv.getValueAt(fsel, 2);
                    PrecioTotal.setText("$ " + total);
                    mtmv.removeRow(fsel);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error no se pudo eliminar la fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarProductoActionPerformed

    private void CategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasActionPerformed
        String nombre = evt.getActionCommand();
        trsFiltro.setRowFilter(RowFilter.regexFilter(nombre, 4));

    }//GEN-LAST:event_CategoriasActionPerformed

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*String opc = Categorias.getSelectedItem().toString();
        if (opc == ("Verduras")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item1");
        }
        if (opc == ("Frutas")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item2");
        }
        if (opc == ("Abarrotes")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item3");
        }
        if (opc == ("Medicina")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item4");
        }
        if (opc == ("Ropa")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item5");
        }
        if (opc == ("Calzado")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item6");
        }
        if (opc == ("Accesorios")) {
            JOptionPane.showMessageDialog(null, "Prueba de cada item7");
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    void addEventos(OyentePrincipal oyente) {
        //ImprimirTicket.addActionListener(oyente);
        // TablaProducto.addMouseListener(oyente2);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JButton ImprimirTicket;
    private javax.swing.JLabel PrecioTotal;
    private javax.swing.JTable TablaProducto;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JLabel Total;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
