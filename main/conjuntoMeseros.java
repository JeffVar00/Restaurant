
package main;

import java.util.ArrayList;

public class conjuntoMeseros {
    
    public conjuntoMeseros(){
        meseros= new ArrayList <>();
    }
    
      public void agregarMesero(String nombre) {
        mesero nuevoMesero = new mesero(nombre);
        agregar(nuevoMesero);      
    }
      
    public int numMeseros() {
        return meseros.size();
    }
     public mesero escoger() {
         mesero aux = new mesero();
         for(int i=0; i < numMeseros(); i++){
             if(meseros.get(i).ocupado() == false){
                 aux = meseros.get(i);
                 meseros.get(i).ocupar();
                 break;
             } else  {
                 aux = null;
             }
         }
         return aux;
    }
     
     public void desocupar(String name){
       
         for(int i=0; i < numMeseros(); i++){
             if(meseros.get(i).nombre().equals(name)){
                 meseros.get(i).desocupar();
                 break;
            }
         }
         
     }

    public void agregar(mesero nuevoMesero) {
        meseros.add(nuevoMesero);
    }

    
    private ArrayList<mesero> meseros;
    
}
