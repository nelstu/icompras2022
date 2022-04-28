/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.icompras2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nstuardo
 */
public class Panel extends javax.swing.JFrame {
 // public static int modelodetctas;  
  DefaultTableModel modelo,modelodet,modeloctas;
  
    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        jTable1.setModel(modelo);

        modelo.addColumn("Id");
        modelo.addColumn("Fecha");
        modelo.addColumn("Numero");
      
        modelo.addColumn("Rut");
        modelo.addColumn("Razon");
        modelo.addColumn("tipo");
        modelo.addColumn("Neto");
        modelo.addColumn("Exento");
        modelo.addColumn("Tasa Iva");
        modelo.addColumn("Iva");
        modelo.addColumn("Tipo Impuesto");
        modelo.addColumn("Monto Impuesto");
        modelo.addColumn("Total");
        modelo.addColumn("Estado");

        
        modelodet = new DefaultTableModel();
        jTable2.setModel(modelodet);
        modelodet.addColumn("codigo");
        modelodet.addColumn("producto");
        modelodet.addColumn("un");
        modelodet.addColumn("precio");
        modelodet.addColumn("cantidad");
        modelodet.addColumn("Total");

        modeloctas = new DefaultTableModel();
        jTable3.setModel(modeloctas);
        modeloctas.addColumn("Cuenta");
        modeloctas.addColumn("Nombre Cuenta");
        modeloctas.addColumn("Debe");
        modeloctas.addColumn("Haber");

        limpiar();
        //llenarcta();
    }
    
    public  void AddRowToJTable(Object[] dataRow){
        //DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        System.out.println(dataRow);
        this.modeloctas.addRow(dataRow);
    }

        private void limpiarjtable() {
        modelo.setRowCount(0);
        modelodet.setRowCount(0);
        modeloctas.setRowCount(0);
    }

    private void limpiar() {
        limpiarjtable();
    }

    private void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {

        }
    }
    
    
       public void llenar1() {

           String query = "select id,fecha,rut,razon,total,estado,tipo,numero,neto,iva,tasaiva,tipoimpuesto,montoimpuesto,exento from documentosc";
           cargarDriver();

           //JOptionPane.showMessageDialog(null, cn.ip);
           String dbURL = "";
           Connection dbCon = null;
           Statement stmt = null;
           ResultSet rs = null;
           Conexion cn = new Conexion();
           //String query = "select * from usuarios where usuario='" + tus + "' AND pass='" + pass + "'";

           dbURL = "jdbc:mysql://" + cn.ip + ":3306/" + cn.base;
           String username = cn.usuario;
           String password = cn.pass;
           try {
               dbCon = DriverManager.getConnection(dbURL, username, password);
               stmt = dbCon.prepareStatement(query);
               rs = stmt.executeQuery(query);
           } catch (SQLException ex) {
               //  Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
           }

           try {

            while (rs.next()) {

                Object[] object = new Object[14];
                object[0] = rs.getString(1);
                object[1] = rs.getString(2);
                object[2] = rs.getString(8);
                object[3] = rs.getString(3);
                object[4] = rs.getString(4);
                object[5] = rs.getString(7);
                object[6] = rs.getString(9);
                object[7] = rs.getString(14);
                object[8] = rs.getString(11);
                object[9] = rs.getString(10);
                
                object[10] = rs.getString(12);
                object[11] = rs.getString(13);
                
                object[12] = rs.getString(5);
                object[13] = rs.getString(6);
                System.out.println("Si");

                modelo.addRow(object);
            }

        } catch (SQLException ex) {
            System.out.println("Nop");
        }

    }
    
    
             public void llenardet(String validador) {

             String query = "select codigo,producto,un,precio,cantidad,total,numero,ide from detdocumentosc where numero="+validador;
           cargarDriver();

           //JOptionPane.showMessageDialog(null, cn.ip);
           String dbURL = "";
           Connection dbCon = null;
           Statement stmt = null;
           ResultSet rs = null;
           Conexion cn = new Conexion();
           //String query = "select * from usuarios where usuario='" + tus + "' AND pass='" + pass + "'";

           dbURL = "jdbc:mysql://" + cn.ip + ":3306/" + cn.base;
           String username = cn.usuario;
           String password = cn.pass;
           try {
               dbCon = DriverManager.getConnection(dbURL, username, password);
               stmt = dbCon.prepareStatement(query);
               rs = stmt.executeQuery(query);
           } catch (SQLException ex) {
               //  Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
           }

           try {

            while (rs.next()) {

                Object[] object = new Object[6];
                object[0] = rs.getString(1);
                object[1] = rs.getString(2);
                object[2] = rs.getString(3);
                object[3] = rs.getString(4);
                object[4] = rs.getString(5);
                object[5] = rs.getString(6);
                
           
                System.out.println("Si");

                modelodet.addRow(object);
            }

        } catch (SQLException ex) {
            System.out.println("Nop");
        }

    }
       
      public  void llenarcta() {

             String query = "select id,ide,cuenta,descripcion,debe,haber from detctas ";
           cargarDriver();

           //JOptionPane.showMessageDialog(null, cn.ip);
           String dbURL = "";
           Connection dbCon = null;
           Statement stmt = null;
           ResultSet rs = null;
           Conexion cn = new Conexion();
           //String query = "select * from usuarios where usuario='" + tus + "' AND pass='" + pass + "'";

           dbURL = "jdbc:mysql://" + cn.ip + ":3306/" + cn.base;
           String username = cn.usuario;
           String password = cn.pass;
           try {
               dbCon = DriverManager.getConnection(dbURL, username, password);
               stmt = dbCon.prepareStatement(query);
               rs = stmt.executeQuery(query);


            while (rs.next()) {

                Object[] object = new Object[4];
                object[0] = rs.getString(3);
                object[1] = rs.getString(4);
                object[2] = rs.getString(5);
                object[3] = rs.getString(6);
             
                
           
                System.out.println("Si");

                modeloctas.addRow(object);
            }

        } catch (SQLException ex) {
            System.out.println("Nop");
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Rut", "Razon Socia", "Tipo", "Total", "Estado"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Descargar emails");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Un", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Nombre Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton3.setText("Matriz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("-");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Totales");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        llenar1();
        
         JOptionPane.showMessageDialog(null, "Archivos Cargados");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        EmailAttachmentReceiver ea = new EmailAttachmentReceiver();
        ea.sincronizar();
        
        
        ILeer il=new ILeer();
        il.ejecutar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();
        String validador = (String) model.getValueAt(selectedRowIndex, 2).toString();

        modelodet.setRowCount(0);

        llenardet(validador);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //Abrir Ventana
        Matriz ma = new Matriz(this,true);
        ma.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         Ctas ct=new Ctas();
         ct.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
       System.exit(0); 
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
