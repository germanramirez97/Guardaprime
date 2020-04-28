
package co.german.bean;

import co.german.dao.OperacionePropietario;
import co.german.dao.OperacionesEmsanbladora;
import co.german.dao.Operacionesvehiculo;
import co.german.dto.Emsambladora;
import co.german.dto.Propietario;
import co.german.dto.Vehiculo;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Listabean {
   
   private List<Vehiculo> vehiculos;
   private List<Propietario> propietarios;
   private List<Emsambladora>emsambladoras;
   
   //@Inject
   private Operacionesvehiculo oper;
   private OperacionePropietario oper1;
   private OperacionesEmsanbladora oper2;

   public Listabean() {
      oper = new Operacionesvehiculo();
      oper1= new OperacionePropietario();
      oper2= new OperacionesEmsanbladora();
   }
   
   @PostConstruct
    public void init() {
        vehiculos = cargarVeh();
        propietarios= cargarProp();
        emsambladoras= cargarEMS();
          
               
                }
   public String salir(){
       return "index";
    }

   public List<Vehiculo> getVehiculos() {
      return vehiculos;
   }

    public List<Propietario> getPropietarios() {
        return propietarios;
        
    }

    public List<Emsambladora> getEmsambladoras() {
        return emsambladoras;
    }

    public void setEmsambladoras(List<Emsambladora> emsambladoras) {
        this.emsambladoras = emsambladoras;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

   public void setVehiculos(List<Vehiculo> vehiculos) {
      this.vehiculos = vehiculos;
   }

   private List<Vehiculo> cargarVeh() {
     
      return oper.consultaT();
      
   }
   private List<Propietario>cargarProp(){
      
       return oper1.consultaT();
       
   }
   
   private List<Emsambladora>cargarEMS(){
      
       return oper2.consultaT();
       
   }
    
}
    

