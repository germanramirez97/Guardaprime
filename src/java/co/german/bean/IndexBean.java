/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class IndexBean  implements Serializable{
    
    public String irCrear(){
      //System.out.println("Ingreso ..");
      return "Vehiculo";
   }
   public String irLista(){
      //System.out.println("Ingreso ..");
      return "listavehiculos";
   }
   
     public String irCrear1(){
      //System.out.println("Ingreso ..");
      return "Propietario";
   }
   public String irLista1(){
      //System.out.println("Ingreso ..");
      return "listapropietarios";
   }
   public String irCrear2(){
      //System.out.println("Ingreso ..");
      return "Emsambladora";
   }
   public String irLista2(){
      //System.out.println("Ingreso ..");
      return "listaemsambladora";
   }
}
