
package main;

import java.util.ArrayList;

public class conjuntoMesas {
     public conjuntoMesas(){
        M = new ArrayList<>();
    }
    
    public int nMesas(){
        return M.size();
    }
    
    public mesa Recuperar(int R){
        return M.get(R);
    }
    
    public void Agregar(mesa p){
        M.add(p);
    }
    
    public void actualizar(mesa Mesa){
        for(int i = 0; i < nMesas(); i++){
            if(Mesa.numero() == M.get(i).numero()){
                Mesa = M.get(i);
                if(Mesa.cAsignado().equals("")){
                    Mesa.desocupar();
                }
                break;
            }
            
        }

    }
    
    private ArrayList<mesa> M;
}
