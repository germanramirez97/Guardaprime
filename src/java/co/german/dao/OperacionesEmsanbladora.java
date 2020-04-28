/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dao;

import co.german.dto.Emsambladora;
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
public class OperacionesEmsanbladora {
    
    public int insertar(Emsambladora dato1){
       
        Connection c = new Conexion().getConnection();
        if (c!= null){
            PreparedStatement ps;
            try {
                
            ps = c.prepareStatement("INSERT INTO emsambladora(id,nombre) VALUES(?,?)");
            ps.setString(1, dato1.getId());
            ps.setString(2, dato1.getNombre());
            
            
            return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesEmsanbladora.class.getName()).log(Level.SEVERE, "Error al insertar el emsambladora", ex);
            }finally{
                new Conexion().cerrarConnexion(c);
            }
        }
        return 0;
        
    }

  public List<Emsambladora> consultaT() {
      List<Emsambladora> dato1 = new ArrayList<>();
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT id,nombre  FROM emsambladora");
            
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                  String  id= rs.getString("id");
                  String nombre = rs.getString("nombre");
                  
                  
                  Emsambladora p = new Emsambladora(nombre, id);
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
        public Emsambladora consultaT(String pk) {
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT  id,nombre  FROM emsambladora where id = ?");
                ps.setString(1, pk);
            
               ResultSet rs = ps.executeQuery();
                  Emsambladora p = null;
               if (rs.next()){
                  
                  String id = rs.getString("id");
                  String nombre = rs.getString("nombre");
                 
                 p= new Emsambladora(nombre,id);
                  
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




    


    

