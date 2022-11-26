
package main;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class vistaCliente extends javax.swing.JFrame {
    
    private vistaBanco vista;
    public cliente Comensal;
    private String TipoServicio;

    public vistaCliente(String NTipo, vistaBanco vistaGeneral) {
        TipoServicio = NTipo;
        vista = vistaGeneral;
        initComponents();
         if("Express".equals(TipoServicio)){
           txtDireccion.setEditable(true);
           txtTelefono.setEditable(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAsignarClientes = new javax.swing.JPanel();
        agregarCliente = new javax.swing.JButton();
        tituloAsignar = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        tituloDireccion = new javax.swing.JLabel();
        tituloTel = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();

        setLocationByPlatform(true);
        setPreferredSize(new Dimension(603, 392));
        getContentPane().setLayout(null);

        panelAsignarClientes.setBackground(new java.awt.Color(255, 204, 204));
        panelAsignarClientes.setLayout(null);

        agregarCliente.setText("Agregar cliente");
        agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarClienteActionPerformed(evt);
            }
        });
        panelAsignarClientes.add(agregarCliente);
        agregarCliente.setBounds(370, 110, 160, 110);

        tituloAsignar.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        tituloAsignar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloAsignar.setText("Asignar Cliente");
        panelAsignarClientes.add(tituloAsignar);
        tituloAsignar.setBounds(20, 20, 150, 30);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelAsignarClientes.add(txtNombre);
        txtNombre.setBounds(240, 20, 170, 50);
        txtNombre.setText("");

        tituloNombre.setText("Nombre:");
        panelAsignarClientes.add(tituloNombre);
        tituloNombre.setBounds(180, 30, 50, 20);

        tituloDireccion.setText("Direccion:");
        panelAsignarClientes.add(tituloDireccion);
        tituloDireccion.setBounds(70, 70, 60, 20);
        //tituloDireccion.setVisible(false);

        tituloTel.setText("Telefono:");
        panelAsignarClientes.add(tituloTel);
        tituloTel.setBounds(70, 260, 60, 20);
        //tituloTel.setVisible(false);

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        panelAsignarClientes.add(txtTelefono);
        txtTelefono.setBounds(130, 260, 130, 22);
        txtTelefono.setEditable(false);
        txtTelefono.setText("");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        panelAsignarClientes.add(txtDireccion);
        txtDireccion.setBounds(70, 100, 270, 130);
        //txtDireccion.setVisible(false);
        txtDireccion.setEditable(false);
        txtDireccion.setText("");

        getContentPane().add(panelAsignarClientes);
        panelAsignarClientes.setBounds(10, 10, 560, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed

    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void agregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarClienteActionPerformed
       
        if(txtDireccion.isEditable()){
            
             if("".equals(txtNombre.getText()) || "".equals(txtDireccion.getText()) || "".equals(txtTelefono.getText())){
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
            }else{
                Comensal = new cliente(txtNombre.getText());
                Comensal.clienteEx(txtTelefono.getText(), txtDireccion.getText());
                vista.cargarCliente(Comensal);
                 JOptionPane.showMessageDialog(null, "Se ha agregado el cliente");
                setVisible(false);
            }
            
        }else{
            
            if("".equals(txtNombre.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre por favor");
            }else{
            String nombre = txtNombre.getText();
            Comensal = new cliente(nombre);
            vista.cargarCliente(Comensal);
             JOptionPane.showMessageDialog(null, "Se ha agregado el cliente");
             setVisible(false);
            }
            
        }
        
    }//GEN-LAST:event_agregarClienteActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCliente;
    private javax.swing.JPanel panelAsignarClientes;
    private javax.swing.JLabel tituloAsignar;
    private javax.swing.JLabel tituloDireccion;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloTel;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
