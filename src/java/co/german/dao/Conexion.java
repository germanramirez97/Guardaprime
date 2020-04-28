/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    public Conexion() { 
    }
     public Connection getConnection()
    {
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/basehoy", "pruebahoy", "123");
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error en la conexion", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void cerrarConnexion(Connection con){
         try {
             con.close();
         } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexion", ex);
         }
    }

}

    

