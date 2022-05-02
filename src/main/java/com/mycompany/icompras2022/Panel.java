/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.icompras2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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
    public static DefaultTableModel mimo;
    DefaultTableModel modelo, modelodet;
  
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

     
       

        
         mimo = new DefaultTableModel();
        jTable4.setModel(mimo);
        mimo.addColumn("Cuenta");
        mimo.addColumn("Nombre Cuenta");
        mimo.addColumn("Debe");
        mimo.addColumn("Haber");
        mimo.addColumn("Ide");
        limpiar();
        //llenarcta();
    }
    
    public  void AddRowToJTable(Object[] dataRow){
        //DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        System.out.println(dataRow);
        this.mimo.addRow(dataRow);
    }

        private void limpiarjtable() {
        modelo.setRowCount(0);
        modelodet.setRowCount(0);
        mimo.setRowCount(0);
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
       
      public  void llenarcta(String validador) {

          String query = "select id,ide,cuenta,descripcion,debe,haber from detctas WHERE ide=" + validador;
          cargarDriver();

           //JOptionPane.showMessageDialog(null, cn.ip);
           String dbURL = "";
           Connection dbCon = null;
           Statement stmt = null;
           ResultSet rs = null;
           Conexion cn = new Conexion();
           Integer Debe=0;Integer Haber=0;
           //String query = "select * from usuarios where usuario='" + tus + "' AND pass='" + pass + "'";

           dbURL = "jdbc:mysql://" + cn.ip + ":3306/" + cn.base;
           String username = cn.usuario;
           String password = cn.pass;
           try {
               dbCon = DriverManager.getConnection(dbURL, username, password);
               stmt = dbCon.prepareStatement(query);
               rs = stmt.executeQuery(query);


            while (rs.next()) {

                Object[] object = new Object[5];
                object[0] = rs.getString(3);
                object[1] = rs.getString(4);
                object[2] = rs.getString(5);
                object[3] = rs.getString(6);
                object[4] = rs.getString(2);
                Debe=Debe+rs.getInt(5);
                Haber=Haber+rs.getInt(6);
                
           
                System.out.println("revision->"+rs.getString(3));

                mimo.addRow(object);
            }

            //mostrar totales
            
            this.jLabel2.setText(Debe.toString());
            this.jLabel3.setText(Haber.toString());
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage().toString());
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setTitle("Panel Compras");
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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Totales");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("0");

        jButton6.setText("Procesar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)
                        .addGap(29, 29, 29)
                        .addComponent(jButton6)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addComponent(jScrollPane4))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
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
        this.jTextField1.setText(validador);
        //limpiar
        modelodet.setRowCount(0);
        mimo.setRowCount(0);
        
        llenardet(validador);
        llenarcta(validador);

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

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
   
      DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

        // get the selected row index
        int selectedRowIndex = jTable4.getSelectedRow();

        // set the selected row data into jtextfields
        if (model.getValueAt(selectedRowIndex, 0)!= null){
             this.jTextField2.setText(model.getValueAt(selectedRowIndex, 0).toString());
             
        }
         if (model.getValueAt(selectedRowIndex, 4)!= null){
              this.jTextField3.setText(model.getValueAt(selectedRowIndex, 4).toString());
             
        }

    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
         mimo.setRowCount(0);
        String validador = jTextField1.getText();
        String Buscar = jTextField2.getText();
        cargarDriver();
        Conexion cn = new Conexion();
        String dbURL = "jdbc:mysql://" + cn.ip + ":3306/" + cn.base;
        String username = cn.usuario;
        String password = cn.pass;
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;

            try {
                dbCon = DriverManager.getConnection(dbURL, username, password);
                Statement comando = dbCon.createStatement();
                

                comando.executeUpdate("DELETE from detctas  WHERE cuenta='"+Buscar+"' AND ide=" + validador);
              
                
            } catch (SQLException ex) { 
                setTitle(ex.toString());
            }
       
             llenarcta(validador);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //Buscar CONUMREG
        
        Connection miConexion = null;
        Statement miStatement4 = null;
        ResultSet miResultset4 = null;
        Integer conumreg =0;
        Integer conumreg2 =0;
        try {
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://192.168.1.3";
            String user = "sa";
            String pass = "SOFTLAND000";
            miConexion = DriverManager.getConnection(dbURL, user, pass);

            if (miConexion != null) {
                try {
                
                    String Sql4 = "SELECT MAX(CONUMREG) as f FROM [valyval].[dbo].[COMP_DB] ORDER BY CONUMREG";
                    miStatement4 = miConexion.createStatement();
                    miResultset4 = miStatement4.executeQuery(Sql4);
                    

                    while (miResultset4.next()) {
                           conumreg = miResultset4.getInt("f")+1;
               
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (miConexion != null && !miConexion.isClosed()) {
                    miConexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        //numreg2
        try {
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://192.168.1.3";
            String user = "sa";
            String pass = "SOFTLAND000";
            miConexion = DriverManager.getConnection(dbURL, user, pass);

            if (miConexion != null) {
                try {
                
                    String Sql4 = "SELECT MAX(NUMREG) as f1 FROM [valyval].[dbo].[DOCU_DB] ORDER BY NUMREG";
                    miStatement4 = miConexion.createStatement();
                    miResultset4 = miStatement4.executeQuery(Sql4);
                    

                    while (miResultset4.next()) {
                           conumreg2 = miResultset4.getInt("f1")+1;
               
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (miConexion != null && !miConexion.isClosed()) {
                    miConexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
        //Fin Buscar CONUMREG
   
        //Verificar que cuadra Asiento
        Integer Debe = 0;
        Integer Haber = 0;
        String valor = Panel.jTextField1.getText();
        //buscardatos
        String query0 = "select id,fecha,rut,razon,total,estado,tipo,numero,neto,iva,tasaiva,tipoimpuesto,montoimpuesto,exento from documentosc WHERE numero=" + valor;
        String fecha = "";
        String rut = ""; String razon = "";String total = "";
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
               stmt = dbCon.prepareStatement(query0);
               rs = stmt.executeQuery(query0);
           } catch (SQLException ex) {
               //  Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
           }

           try {

            while (rs.next()) {

              
             
                fecha = rs.getString(2);
                rut = rs.getString(3);
                razon = rs.getString(4);
                total = rs.getString(5);
            }

        } catch (SQLException ex) {
            System.out.println("Nop");
        }

          //fin buscar datos
        String query = "select id,ide,debe,haber from detctas WHERE ide=" + Panel.jTextField1.getText();
        cargarDriver();

      
           try {
               dbCon = DriverManager.getConnection(dbURL, username, password);
               stmt = dbCon.prepareStatement(query);
               rs = stmt.executeQuery(query);
           } catch (SQLException ex) {
               //  Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
           }

           try {

            while (rs.next()) {

           
                Debe = Debe+rs.getInt(3);
                Haber = Haber+rs.getInt(4);
          
            }
            System.out.println("Debe:"+Debe.toString());
            System.out.println("Haber:"+Haber.toString());
            if (Debe.equals(Haber)){
                //insert COMP_DB
                 Connection dbCon1 = null;
               
                Statement miStatement = null;
                ResultSet miResultset1 = null;
                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String dbURL1 = "jdbc:sqlserver://192.168.1.3";
                    String user1 = "sa";
                    String pass1 = "SOFTLAND000";

                    dbCon1 = DriverManager.getConnection(dbURL1, user1, pass1);
                   //dbCon1 Statement comando = dbCon1.createStatement();
                    String comprobante = Panel.jTextField1.getText();
                    java.util.Date utilDate = new java.util.Date(); //fecha actual
                    long lnMilisegundos = utilDate.getTime();
                    java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
                    java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
                    //String sql1="INSERT INTO [valyval].[dbo].[COMP_DB] (CONUMREG,CONUM,COTIPO,COAÑO,USERMODI,ESQUEMAS,CONTAB,COFECHA) VALUES (14842," + valor + ",'E','2022','US1','10000 - Plan Estandar',1,'" + sqlDate.toString() + "')";
                    String SQL_INSERT = "INSERT INTO [valyval].[dbo].[COMP_DB] (CONUMREG,CONUM,COTIPO,COAÑO,USERMODI,ESQUEMAS,CONTAB,COFECHA,FECHAMODIF,COGLOSA,COEMP) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement miStatement1 = dbCon1.prepareStatement(SQL_INSERT);
                    miStatement1.setInt(1, conumreg);
                    miStatement1.setString(2, valor);
                    miStatement1.setString(3, "E");
                    miStatement1.setString(4, "2022");
                    miStatement1.setString(5, "US1");
                    miStatement1.setString(6, "10000 - Plan Estandar");
                    miStatement1.setInt(7, 1);
                    miStatement1.setString(8, sqlDate.toString());
                    miStatement1.setString(9, sqlDate.toString());
                    
                    miStatement1.setString(10, "PAGO PROVEEDOR Fª "+valor);
                    miStatement1.setInt(11, 1);
                    int row = miStatement1.executeUpdate();
                    //Verificar Proveedor Si no Existe Ingresar
                    String query3 = "SELECT NREGUIST,RAZSOC,RUT FROM [valyval].[dbo].[CLIEN_DB] WHERE RUT='" + rut + "'";

                    cargarDriver();
                    Statement stmt3 = null;
                    ResultSet rs3 = null;
                    String existerut="N";String idcli="";
                    try {
                        dbCon = DriverManager.getConnection(dbURL, username, password);
                        stmt3 = dbCon.prepareStatement(query);
                        rs3 = stmt3.executeQuery(query);
                        while (rs3.next()) {
                               idcli=rs3.getString(1);
                               existerut="S";
                               System.out.println("Rut Existe");
                        }
                    } catch (SQLException ex3) {
                        //  Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                   if (existerut.equals("N")){
                       System.out.println("Rut No Existe");
                   }

           
                     
                     
                    //Fin Verificar Proveedor Si no Existe Ingresar
                    
                    //buscar comprobante tipo
                    
                    //fin buscar comprobante tipo
                    
                    //Detalle
                    String SQL_INSERT2 = "INSERT INTO [valyval].[dbo].[DOCU_DB] (NUMFACT,FECHA,NRUTFACT,RUTFACT,NRUTCLIE,NUMREG,CODVEN,GLOSACON,PGNUMRECOR,CTA,PGITEM,DEBE,HABER) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement miStatement2 = dbCon1.prepareStatement(SQL_INSERT2);
                     miStatement2.setString(1, valor);
                     miStatement2.setString(2, fecha);
                     miStatement2.setString(3, idcli);
                     miStatement2.setString(4, rut);
                     miStatement2.setString(5, idcli);
                     miStatement2.setString(6, conumreg2.toString());
                     miStatement2.setString(7, "666");
                     miStatement2.setString(8, "FxR "+razon);
                     miStatement2.setString(9, conumreg.toString());
                     miStatement2.setString(10, valor);
                     miStatement2.setString(11, valor);
                     miStatement2.setString(12, total);
                     miStatement2.setString(13, total);
                    int row2 = miStatement2.executeUpdate();
                    //Fin Detalle

            // rows affected
            System.out.println(row); //1                    
                } catch (SQLException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
             

                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }

                    
                    

                //fin insert COMP_DB
                
                JOptionPane.showMessageDialog(null, "Archivo Enviado a Manager"); 
                
                }else{
                JOptionPane.showMessageDialog(null, "Debe y Haber no estan Cuadrados");  
                
            }

        } catch (SQLException ex) {
            System.out.println("Nop");
        }
    

    }//GEN-LAST:event_jButton6ActionPerformed

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
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
