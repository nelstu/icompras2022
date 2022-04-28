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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nstuardo
 */
public class SelPlan extends javax.swing.JFrame {
    DefaultTableModel modeloc;

    /**
     * Creates new form SelPlan
     */
    public SelPlan() throws ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
         modeloc = new DefaultTableModel();
        jTable1.setModel(modeloc);

        modeloc.addColumn("Cuenta");
        modeloc.addColumn("Descripcion");
        
        llenarselplan();
    }
    
      public void buscarcuenta() throws ClassNotFoundException{

        modeloc.setRowCount(0);
        
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResultset = null;
        Statement miStatement1 = null;
        ResultSet miResultset1 = null;
        DecimalFormat formateador = new DecimalFormat("#,###,###,##0");
  
        try {
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://192.168.1.3";
            String user = "sa";
            String pass = "SOFTLAND000";
            miConexion = DriverManager.getConnection(dbURL, user, pass);

            if (miConexion != null) {
                try {
                
                    String instruccionSql = "SELECT PCCODI,PCDESC FROM IOPASA2021.softland.cwpctas WHERE PCCODI='"+this.jTextField1.getText()+"'";
                    miStatement = miConexion.createStatement();
                    miResultset = miStatement.executeQuery(instruccionSql);
                    String nombre = "";

                    while (miResultset.next()) {
                        String CodProd = miResultset.getString("PCCODI");
                        String DesProd = miResultset.getString("PCDESC");

                        Object[] object = new Object[2];
                        object[0] = miResultset.getString(1);
                        object[1] = miResultset.getString(2);
                        

                        modeloc.addRow(object);;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (miConexion != null && !miConexion.isClosed()) {
                    miConexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        this.jTextField1.setText("");
        
    }
    
    public void llenarselplan() throws ClassNotFoundException{

        
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResultset = null;
        Statement miStatement1 = null;
        ResultSet miResultset1 = null;
        DecimalFormat formateador = new DecimalFormat("#,###,###,##0");
  
        try {
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://192.168.1.3";
            String user = "sa";
            String pass = "SOFTLAND000";
            miConexion = DriverManager.getConnection(dbURL, user, pass);

            if (miConexion != null) {
                try {
                
                    String instruccionSql = "SELECT PCCODI,PCDESC FROM IOPASA2021.softland.cwpctas ";
                    miStatement = miConexion.createStatement();
                    miResultset = miStatement.executeQuery(instruccionSql);
                    String nombre = "";

                    while (miResultset.next()) {
                        String CodProd = miResultset.getString("PCCODI");
                        String DesProd = miResultset.getString("PCDESC");

                        Object[] object = new Object[2];
                        object[0] = miResultset.getString(1);
                        object[1] = miResultset.getString(2);
                        

                        modeloc.addRow(object);;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (miConexion != null && !miConexion.isClosed()) {
                    miConexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("Seleccionar Cuenta");

        jLabel1.setText("Cuenta");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            buscarcuenta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();

        // set the selected row data into jtextfields
        if (model.getValueAt(selectedRowIndex, 0)!= null){
             Ctas.jTextField1.setText(model.getValueAt(selectedRowIndex, 0).toString());
             //jTextField1.setText();
        }
         if (model.getValueAt(selectedRowIndex, 1)!= null){
             Ctas.jTextField2.setText(model.getValueAt(selectedRowIndex, 1).toString());
             //jTextField1.setText();
        }
      // Ctas ca=new Ctas();
        this.setVisible(false);
      
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(SelPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SelPlan().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SelPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
