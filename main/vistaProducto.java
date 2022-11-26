
package main;

import javax.swing.JOptionPane;


public class vistaProducto extends javax.swing.JFrame {

    private vistaBanco vista;

    public vistaProducto(vistaBanco vista) {
        this.vista = vista;
        initComponents();
    }
    
    public void Limpiar(){
        ComboProducto.setSelectedIndex(-1);
        txtCodigo.setText("");
        txtNombreC.setText("");
        txtPrecio.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipalP = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbNuevoProducto = new javax.swing.JLabel();
        ComboProducto = new javax.swing.JComboBox<>();
        lbTProducto = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lbNombreC1 = new javax.swing.JLabel();
        lbNombreC = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelPrincipalP.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        lbNuevoProducto.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lbNuevoProducto.setText("Nuevo Producto");
        jPanel1.add(lbNuevoProducto);
        lbNuevoProducto.setBounds(150, 10, 178, 29);

        ComboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Platillo", "Bebida"}));
        jPanel1.add(ComboProducto);
        ComboProducto.setBounds(140, 60, 120, 22);

        lbTProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTProducto.setText("Tipo de Producto: ");
        jPanel1.add(lbTProducto);
        lbTProducto.setBounds(10, 60, 115, 17);
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(140, 100, 120, 22);

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCodigo.setText("Codigo: ");
        jPanel1.add(lbCodigo);
        lbCodigo.setBounds(80, 100, 52, 17);
        jPanel1.add(txtNombreC);
        txtNombreC.setBounds(140, 140, 120, 22);
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(140, 180, 120, 22);

        lbNombreC1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNombreC1.setText("Precio:");
        jPanel1.add(lbNombreC1);
        lbNombreC1.setBounds(80, 180, 42, 17);

        lbNombreC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNombreC.setText("Nombre:");
        jPanel1.add(lbNombreC);
        lbNombreC.setBounds(70, 140, 54, 17);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(170, 260, 130, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelPrincipalP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 499, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(ComboProducto.getSelectedItem() == "Platillo"){
            String c = txtCodigo.getText();
            String n = txtNombreC.getText();
            int p = Integer.parseInt(txtPrecio.getText());
            producto P = new producto(c,n,p);
            vista.agregarPlatillo(P);
            JOptionPane.showMessageDialog(null, "Se agrego un producto con exito");
            setVisible(false);
        }else if(ComboProducto.getSelectedItem() == "Bebida"){
            String c = txtCodigo.getText();
            String n = txtNombreC.getText();
            int p = Integer.parseInt(txtPrecio.getText());
            producto P = new producto(c,n,p);
            vista.agregarBebida(P);
            JOptionPane.showMessageDialog(null, "Se agrego un producto con exito");
            setVisible(false);
        }
        Limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

           
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
            java.util.logging.Logger.getLogger(vistaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboProducto;
    private javax.swing.JPanel PanelPrincipalP;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNombreC;
    private javax.swing.JLabel lbNombreC1;
    private javax.swing.JLabel lbNuevoProducto;
    private javax.swing.JLabel lbTProducto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
