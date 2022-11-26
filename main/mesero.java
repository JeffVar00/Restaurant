
package main;

public class mesero extends persona{
    
    public mesero(){
        super();
        ocupado = false;
    }
    
    public mesero(String nombre){
        super(nombre);
        ocupado = false;
    }
    
    public boolean ocupado(){
        return ocupado;
    }
    
    public void desocupar(){
        ocupado = false;
    }
    
    public void ocupar(){
        ocupado = true;
    }
  
    boolean ocupado;
    
}
