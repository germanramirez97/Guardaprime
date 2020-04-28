/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dto;

import java.io.Serializable;
import java.util.List;


public class Propietario implements Serializable{
    
    
    private String cedula;
    private String nombres;
    private List<Vehiculo> vehi;
    
    public Propietario(){
        
    }

    public Propietario(String cedula, String nombres) {
        this.cedula = cedula;
        this.nombres = nombres;
    }

    public List<Vehiculo> getVehi() {
        return vehi;
    }

    public void setVehi(List<Vehiculo> vehi) {
        this.vehi = vehi;
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

    @Override
    public String toString() {
        return "Propietario{" + "cedula=" + cedula + ", nombres=" + nombres + '}';
    }

   
   
}

