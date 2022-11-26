
package main;

public class producto {
       public producto(String codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 1;
    }
    
       public void asignarCantidad(int cantidad){
        this.cantidad += cantidad;
      }
       
       public void ajustarCantidad(int cantidad){
        this.cantidad = cantidad;
      }
       
    public String getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public int cantidad(){
        return cantidad;
    }
    
    public static int numCampos() {
        return producto.class.getClass().getFields().length;
    }

    public static String[] Campos() {
        return CAMPOS;
    }
    
    public Object[] toArray() {
        Object[] r = new Object[4];
        r[0] = getCodigo();
        r[1] = getNombre();
        r[2] = getPrecio();
        r[3] = cantidad();
        return r;
    }
    
    private static final String[] CAMPOS = {"Codigo","Descripcion","Precio", "Cantidad"};
    private int cantidad;
    private String codigo;
    private String nombre;
    private double precio;
}
