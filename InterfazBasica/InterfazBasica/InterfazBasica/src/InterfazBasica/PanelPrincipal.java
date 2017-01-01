/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBasica;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ishrael
 */
public class PanelPrincipal extends javax.swing.JPanel {

    private final ModeloTablaVenta mtmv;
    private final ModeloTablaProducto mtmp;
    double total;

    /**
     * Creates new form PanelPrinc
     */
    public PanelPrincipal(ModeloTablaVenta mtmv, ModeloTablaProducto mtmp) {
        initComponents();
        this.mtmp = mtmp;
        this.mtmv = mtmv;
        TablaProducto.setModel(mtmp);
        TablaProducto.getColumn("A").setHeaderValue("producto");
        TablaProducto.getColumn("B").setHeaderValue("precio");
        TablaProducto.getColumn("C").setHeaderValue("unidad");

        TablaVenta.setModel(mtmv);
        TablaVenta.getColumn("A").setHeaderValue("cantidad");
        TablaVenta.getColumn("B").setHeaderValue("producto");
        TablaVenta.getColumn("C").setHeaderValue("precio");
        TablaVenta.getColumn("D").setHeaderValue("unidad");

        mtmp.addRegister("Manzana", 10.0, "kg.");

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

        setPreferredSize(new java.awt.Dimension(600, 600));

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "nombre del producto", "precio", "unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        Total.setText("TOTAL:");

        PrecioTotal.setText("$ 0.0");

        ImprimirTicket.setText("Imprimir ticket");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImprimirTicket)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Total)
                                .addGap(18, 18, 18)
                                .addComponent(PrecioTotal)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarProducto))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(agregarProducto)
                        .addGap(56, 56, 56)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total)
                            .addComponent(PrecioTotal))
                        .addGap(18, 18, 18)
                        .addComponent(ImprimirTicket)
                        .addContainerGap(175, Short.MAX_VALUE))))
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
        int row = TablaProducto.getSelectedRow();
        //System.out.println(row);
        int cantidad = 1;
        String producto = TablaProducto.getValueAt(row, 0).toString();
        double precio = (double) TablaProducto.getValueAt(row, 1);
        String unidad = TablaProducto.getValueAt(row, 2).toString();
        mtmv.addRegister(cantidad, producto, precio, unidad);

        total = total + (double) mtmv.getValueAt(row, 2);
        PrecioTotal.setText("$ " + total);
    }//GEN-LAST:event_agregarProductoActionPerformed

    void addEventos(OyentePrincipal oyente) {
        //ImprimirTicket.addActionListener(oyente);
        // TablaProducto.addMouseListener(oyente2);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImprimirTicket;
    private javax.swing.JLabel PrecioTotal;
    private javax.swing.JTable TablaProducto;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JLabel Total;
    private javax.swing.JButton agregarProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}