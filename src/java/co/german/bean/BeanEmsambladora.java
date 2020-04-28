/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.bean;

import co.german.dao.OperacionesEmsanbladora;
import co.german.dto.Emsambladora;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;




@ManagedBean
@ViewScoped
public class BeanEmsambladora implements Serializable{
    
    private  String nombre;
    private  String id;
    
   
    public BeanEmsambladora(){
        
    }
    
    
    public void insertar() {

      if ( id ==null||id.isEmpty()||nombre == null || nombre.isEmpty()) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención", "no se inserto el emsambladora"));
         return;
      }
      Emsambladora p = new Emsambladora();
      p.setId(id);
      p.setNombre(nombre);
      

      OperacionesEmsanbladora oper = new OperacionesEmsanbladora();
      int rta = oper.insertar(p);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro el emsambladora."));

      System.out.println("rta " + rta);
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




   public String salir() {
      return "index";
   }

}





