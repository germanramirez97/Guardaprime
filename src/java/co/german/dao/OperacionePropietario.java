/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dao;

import co.german.dto.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class OperacionePropietario {
    
  
    public int insertar(Propietario dato1){
       
        Connection c = new Conexion().getConnection();
        if (c!= null){
            PreparedStatement ps;
            try {
                
            ps = c.prepareStatement("INSERT INTO Propietario(cedula,nombre) VALUES(?,?)");
            ps.setString(1, dato1.getCedula());
            ps.setString(2, dato1.getNombres());
            
            
            return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionePropietario.class.getName()).log(Level.SEVERE, "Error al insertar el propietario", ex);
            }finally{
                new Conexion().cerrarConnexion(c);
            }
        }
        return 0;
        
    }

   public List<Propietario> consultaT() {
      List<Propietario> dato1 = new ArrayList<>();
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT cedula,nombre  FROM Propietario");
            
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                  String cedula = rs.getString("cedula");
                  String nombre = rs.getString("nombre");
                  
                  
                  Propietario p = new Propietario(cedula, nombre);
                  dato1.add(p);
               }
               
            
            } catch (SQLException ex) {
                Logger.getLogger(OperacionePropietario.class.getName()).log(Level.SEVERE, "Error al insertar el vehiculo", ex);
            }finally{
                new Conexion().cerrarConnexion(cx);
            }
      }
      
      
      
      return dato1;
   }
      public Propietario consultaT(String pk) {
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT cedula,nombre  FROM Propietario where cedula = ?");
                ps.setString(1, pk);
            
               ResultSet rs = ps.executeQuery();
                  Propietario p = null;
               if (rs.next()){
                  
                  String cedula = rs.getString("cedula");
                  String nombre = rs.getString("nombre");
                 
                  p = new Propietario(cedula, nombre);
                  
               }
               return p;
            
            } catch (SQLException ex) {
                Logger.getLogger(OperacionePropietario.class.getName()).log(Level.SEVERE, "Error al insertar propietario", ex);
            }finally{
                new Conexion().cerrarConnexion(cx);
            }
      }
      
      
      
      return null;
   }
}



    

