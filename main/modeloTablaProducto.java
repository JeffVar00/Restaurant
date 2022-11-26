
package main;

import javax.swing.table.AbstractTableModel;

public class modeloTablaProducto extends AbstractTableModel{
    
        public modeloTablaProducto (conjuntoProductos productos){
        this.productos= productos;
    }
        
        public void reasignar(conjuntoProductos productos){
            this.productos = productos;
        }

      @Override
    public String getColumnName(int col) {
        return producto.Campos()[col];
    }
    
    @Override
    public int getRowCount() {
         return productos.NProductos();
    }

    @Override
    public int getColumnCount() {
        return producto.Campos().length;
    }

    @Override
    public Object getValueAt(int fila, int col) {
         return productos.Recuperar(fila).toArray()[col];
    }
    
    private conjuntoProductos productos;
}
