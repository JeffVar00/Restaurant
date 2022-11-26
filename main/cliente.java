
package main;

public class cliente extends persona{
    
    public cliente(){
        super();
        telefono = "";
        direccion = " ";
    }
    
    public cliente(String nombre){
        super(nombre);
        telefono = "";
        direccion = "";
    }
    public void clienteEx(String tel, String dir){
        this.telefono = tel;
        this.direccion = dir;
    }
    
    public String tel(){
        return telefono;
    }
    
    public String dir(){
        return direccion;
    }
    
    private String telefono;
    private String direccion;
    
}
