/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dao;

import co.german.dto.Vehiculo;
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
public class Operacionesvehiculo {
    
    public int insertar(Vehiculo dato){
       
        Connection c = new Conexion().getConnection();
        if (c!= null){
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("INSERT INTO vehiculo(placa,precio,marca)VALUES (?, ?, ?)");
            ps.setString(1, dato.getPlaca());
            ps.setLong(2, dato.getPrecio());
            ps.setString(3, dato.getMarca());
            
            return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operacionesvehiculo.class.getName()).log(Level.SEVERE, "Error al insertar el vehiculo", ex);
            }finally{
                new Conexion().cerrarConnexion(c);
            }
        }
        return 0;
        
    }

   public List<Vehiculo> consultaT() {
      List<Vehiculo> dato = new ArrayList<>();
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT placa, precio, marca FROM vehiculo");
            
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                  String marc = rs.getString("marca");
                  String plac = rs.getString("placa");
                  Long precio = rs.getLong("precio");
                  
                  Vehiculo v = new Vehiculo(plac, precio, marc);
                  dato.add(v);
               }
               
            
            } catch (SQLException ex) {
                Logger.getLogger(Operacionesvehiculo.class.getName()).log(Level.SEVERE, "Error al insertar el vehiculo", ex);
            }finally{
                new Conexion().cerrarConnexion(cx);
            }
      }
      
      
      
      return dato;
   }
      public Vehiculo consultaT(String pk) {
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT marca, placa, precio FROM vehiculos where placa = ?");
                ps.setString(1, pk);
            
               ResultSet rs = ps.executeQuery();
                  Vehiculo v = null;
               if (rs.next()){
                  
                  String marc = rs.getString("marca");
                  String plac = rs.getString("placa");
                  Long precio = rs.getLong("precio");
                  v = new Vehiculo(plac, precio, marc);
                  
               }
               return v;
            
            } catch (SQLException ex) {
                Logger.getLogger(Operacionesvehiculo.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            }finally{
                new Conexion().cerrarConnexion(cx);
            }
      }
      
      
      
      return null;
   }
}


