/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.bean;

import co.german.dao.OperacionePropietario;
import co.german.dto.Propietario;
import co.german.dto.Vehiculo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BeanPropietario implements Serializable{
    
    private String cedula;
    private String nombres;
    
    public BeanPropietario(){
        
    }
    
    
    public void insertar() {

      if ( cedula ==null||cedula.isEmpty()||nombres == null || nombres.isEmpty()) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención", "no se inserto el Propietario"));
         return;
      }
      Propietario p = new Propietario();
      p.setCedula(cedula);
      p.setNombres(nombres);
      

      OperacionePropietario oper = new OperacionePropietario();
      int rta = oper.insertar(p);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro el Propietario."));

      System.out.println("rta " + rta);
   }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }



   public String salir() {
      return "index";
   }

}



