
package main;


public class recibo {
    
    public recibo(String Tipo){
        NFac = (int)(Math.random()*1000+1);
        TServicio = Tipo;
        STotal = 0;
        IVA = 0;
        Total = 0;
        mesero = "Sin mesero asignado";
        pedido = new conjuntoProductos();
        cliente = "";
    }
    
    public void aplicarDescuento(){
        Total -= Total * 0.05;
    }
    
    public void colocarTipo(String tipo){
        TServicio = tipo;
    }
    
    public void agregarPlatillo(producto plato){
        pedido.Agregar(plato);
    }
    
    public void agregarMesero(String name){
        mesero = name;
    }
    
      public void agregarCliente(String name){
        cliente = name;
    }
    
    public conjuntoProductos platos(){
        return pedido;
    }
    
    public String getCliente(){
        return cliente;
    }
    
    public String getMesero(){
        return mesero;
    }
    
    public int getNFac(){
        return NFac;
    }
    
    public String getTServicio(){
        return TServicio;
    }
    
    public void obtenerTotal(){
        STotal = 0;
        IVA = 0;
        Total = 0;
        for(int i = 0; i < pedido.NProductos(); i++){
            STotal += pedido.Recuperar(i).getPrecio() * pedido.Recuperar(i).cantidad();
        }
        IVA = (int) (STotal * 0.13);
        Total  = STotal + IVA;
    }
    
    public int getSTotal(){
        return STotal;
    }
    
    public int getIVA(){
        return IVA;
    }
    
    public int getTotal(){
        return Total;
    } 
    
    public static String[] Campos() {
        return CAMPOS;
    }
    
    public Object[] toArray() {
        Object[] r = new Object[5];
        r[0] = getNFac();
        r[1] = getTServicio();
        r[2] = getCliente();
        r[3] = getMesero();
        r[4] = getTotal();
        return r;
    }
    
    private static final String[] CAMPOS = {"# Factura","Tipo de Servicio", "Cliente", "Mesero","Total de Venta"};
    
    private int NFac;
    private String cliente;
    private String mesero;
    private String TServicio;
    private int STotal;
    private int IVA;
    private int Total;
    private conjuntoProductos pedido;
}
