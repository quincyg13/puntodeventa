/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazBasica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marioso
 */
public class conexion {
 
    
    
    static final String CONTROLADOR = "com.mysql.jdbc.Driver"
            + "";
    static final String URL_BASEDATOS = "jdbc:mysql://localhost/agilespuntodeventa";
   public  static Connection con = null; // maneja la con
    static Statement st = null; // instruccion de consulta
    static ResultSet rs = null; // maneja los resultados
    static ResultSetMetaData metaDatos;
    private static Statement stmt;

    public  static boolean conectar() {

        try {
            Class.forName(CONTROLADOR);
             con = DriverManager.getConnection(URL_BASEDATOS, "root", "");
            st = con.createStatement();
            //rs = st.executeQuery("SELECT * from alumno");
System.out.println("conectado a sql");
            return true;

        } catch (SQLException exceptionSQL) {
            exceptionSQL.printStackTrace();
            return false;
        } catch (ClassNotFoundException noEncontroClase) {
            noEncontroClase.printStackTrace();
            return false;
        }

    }
    
    
    public static boolean ejecutar(String query) {
       boolean resultado = false;
       try {
             resultado = st.execute(query);
             JOptionPane.showMessageDialog(null,"Realizado con exito" ,"SQL",JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
           System.out.println(e);
             JOptionPane.showMessageDialog(null,"Realizado sin exito" ,"SQL",JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
    
    public static boolean consultarLOg(String nombre,String password){
        boolean entrar=false;
      String query = "Select * from Vendedor where Vendedor.NombreVendedor = '"+nombre+"';" ;
         try {
             stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(query);
               rs.next();
               String nombresql = rs.getString("NombreVendedor");
               String passsql = rs.getString("password");
               System.out.println(nombresql);
               System.out.println(passsql);
               
               if (nombresql.equals(nombre) && passsql.equals(password)) {
                 entrar=true;
                   System.out.println("conectado");
             
             }
         } catch (SQLException ex) {
             Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
             return entrar;
    }
    
      
      public static DefaultTableModel consultaToJtable(String query) {
        DefaultTableModel model = null;
        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            // Get all rows.
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                    System.out.println("" + rs.getObject(i));
                }
                rows.addElement(newRow);
            }
            System.out.println(rows.size());
            model = new DefaultTableModel(rows, columnNames);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
}
