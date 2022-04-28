/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.icompras2022;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nstuardo
 */
public class Conexionsqlserver {
    Connection con;
    public Conexionsqlserver(){
        /*
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registro","root","");
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        */
        
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://192.168.1.3","sa","SOFTLAND000");
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        
    }
    
    public Connection getConnection(){
        return con;
    }
    
}
