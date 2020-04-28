/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.german.dto;

import java.io.Serializable;


public class Vehiculo  implements Serializable{
    private String placa;
    private long precio;
    private String marca;

   public Vehiculo(String placa, long precio, String marca) {
      this.placa = placa;
      this.precio = precio;
      this.marca = marca;
   }

    public Vehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

   @Override
   public String toString() {
      return "placa: "+this.placa +" marca: "+this.marca+" precio: "+this.precio;
   }
    
    
    
}

