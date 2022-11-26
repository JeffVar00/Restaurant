
package main;

import javax.swing.table.AbstractTableModel;

public class modeloTablaFacturas extends AbstractTableModel {
    
        public modeloTablaFacturas (conjuntoFacturas facturas){
        this.facturas= facturas;
    }

      @Override
    public String getColumnName(int col) {
        return recibo.Campos()[col];
    }
    
    @Override
    public int getRowCount() {
         return facturas.nFacturas();
    }

    @Override
    public int getColumnCount() {
        return recibo.Campos().length;
    }

    @Override
    public Object getValueAt(int fila, int col) {
         return facturas.Recuperar(fila).toArray()[col];
    }
    
    private conjuntoFacturas facturas;
}
