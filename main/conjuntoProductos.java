
package main;

import java.util.ArrayList;


public class conjuntoProductos {
    public conjuntoProductos(){
        P = new ArrayList<>();
    }
    
    public int NProductos(){
        return P.size();
    }
    
    public producto Recuperar(int R){
        return P.get(R);
    }
    
    public void Agregar(producto p){
        P.add(p);
    }
    
    private ArrayList<producto> P;
}
