
package main;

import java.util.ArrayList;

public class conjuntoFacturas {
      public conjuntoFacturas(){
        F = new ArrayList<>();
    }
    
    public int nFacturas(){
        return F.size();
    }
    
    public recibo Recuperar(int R){
        return F.get(R);
    }
    
    public void Agregar(recibo p){
        F.add(p);
    }
    
    private ArrayList<recibo> F;
}
