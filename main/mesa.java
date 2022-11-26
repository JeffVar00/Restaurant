
package main;

public class mesa {
    
    public mesa(int nMesa, int capacidad){
        this.capacidad = capacidad;
        this.nMesa = nMesa;
        meseroAsignado = new mesero();
        clienteAsignado = new cliente();
         factura = new recibo("Comer Aqui");
    }
    
    public recibo miFactura(){
        return factura;
    }
    
    public int capacidad(){
        return capacidad;
    }
    
    public int numero(){
        return nMesa;
    }
    
    public boolean estado(){
        return ocupado;
    }
    
    public String cAsignado(){
        return clienteAsignado.nombre();
    }
    
    public String mAsignado(){
        return meseroAsignado.nombre();
    }
    
    public mesero cargarMesero(){
        return meseroAsignado;
    }
    
    public cliente cargarCliente(){
        return clienteAsignado;
    }
    
    public void asignarMesero(mesero asignado){
        meseroAsignado = asignado;
        factura.agregarMesero(asignado.nombre());
    }
    
    public void asignarCliente(cliente asignado){
         clienteAsignado = asignado;
         factura.agregarCliente(asignado.nombre());
    }
    
    public void agregarProducto(producto x){
        factura.agregarPlatillo(x);
    }
    
    public void limpiar(){
        factura = new recibo("");
        meseroAsignado = new mesero();
        clienteAsignado = new cliente();
    }
    
    public void ocupar(){
        ocupado = true;
    }
    
    public void desocupar(){
        ocupado = false;
    }
    
    private int capacidad;
    private int  nMesa;
    private boolean ocupado = false;
    private recibo factura;
    private mesero meseroAsignado;
    private cliente clienteAsignado;

}
