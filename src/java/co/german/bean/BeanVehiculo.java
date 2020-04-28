/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.bean;

import co.german.dao.Operacionesvehiculo;
import co.german.dto.Vehiculo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;




@ManagedBean
@ViewScoped
public class BeanVehiculo  implements Serializable{
   private long precio;
   private String marca;
   private String placa;
   
   public BeanVehiculo() {

   }

   
   
    public void insertar() {

      if (marca == null || marca.isEmpty() || placa == null || placa.isEmpty()) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención", "no se inserto el vehiculo"));
         return;
      }
      Vehiculo v = new Vehiculo();
      v.setPrecio(precio);
      v.setMarca(marca);
      v.setPlaca(placa);

      Operacionesvehiculo oper = new Operacionesvehiculo();
      int rta = oper.insertar(v);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro el Vehiculo."));

      System.out.println("rta " + rta);
   }

   public long getPrecio() {
      return precio;
   }

   public void setPrecio(long precio) {
      this.precio = precio;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getPlaca() {
      return placa;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }

   public String salir() {
      return "index";
   }

}
