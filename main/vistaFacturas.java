
package main;

public class vistaFacturas extends javax.swing.JFrame {
    
    private conjuntoFacturas express = new conjuntoFacturas();
    private conjuntoFacturas paraLlevar = new conjuntoFacturas();
    private conjuntoFacturas comerAqui = new conjuntoFacturas();
    private modeloTablaFacturas modeloExpress;
    private modeloTablaFacturas modeloParaLLevar;  
    private modeloTablaFacturas modeloComerAqui;
    
    public vistaFacturas(conjuntoFacturas facturas) {
        
        for(int i =0; i < facturas.nFacturas(); i++){
            
            if("Comer Aqui".equals(facturas.Recuperar(i).getTServicio())){
                comerAqui.Agregar(facturas.Recuperar(i));
            }else if("Express".equals(facturas.Recuperar(i).getTServicio())){
                express.Agregar(facturas.Recuperar(i));
            }else if("Para llevar".equals(facturas.Recuperar(i).getTServicio())){
                paraLlevar.Agregar(facturas.Recuperar(i));
            }
            
        }
        
        modeloExpress = new modeloTablaFacturas(express);
        modeloComerAqui = new modeloTablaFacturas(comerAqui);
        modeloParaLLevar = new modeloTablaFacturas(paraLlevar);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        scrollTablaLLevar = new javax.swing.JScrollPane();
        tablaLLevar = new javax.swing.JTable();
        scrollTablaComerAqui = new javax.swing.JScrollPane();
        tablaComerAqui = new javax.swing.JTable();
        scrollTablaExpress = new javax.swing.JScrollPane();
        tablaExpress = new javax.swing.JTable();
        btnExpress = new javax.swing.JButton();
        btnComerAqui = new javax.swing.JButton();
        btnParaLlevar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        panelGeneral.setBackground(new java.awt.Color(255, 204, 204));
        panelGeneral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelGeneral.setLayout(null);

        tablaLLevar.setModel(modeloParaLLevar);
        scrollTablaLLevar.setViewportView(tablaLLevar);

        panelGeneral.add(scrollTablaLLevar);
        scrollTablaLLevar.setBounds(10, 0, 880, 560);
        scrollTablaLLevar.setVisible(false);

        tablaComerAqui.setModel(modeloComerAqui);
        scrollTablaComerAqui.setViewportView(tablaComerAqui);

        panelGeneral.add(scrollTablaComerAqui);
        scrollTablaComerAqui.setBounds(10, 0, 880, 560);
        scrollTablaComerAqui.setVisible(false);

        tablaExpress.setModel(modeloExpress);
        scrollTablaExpress.setViewportView(tablaExpress);

        panelGeneral.add(scrollTablaExpress);
        scrollTablaExpress.setBounds(10, 0, 880, 560);
        scrollTablaExpress.setVisible(false);

        btnExpress.setBackground(new java.awt.Color(255, 153, 153));
        btnExpress.setText("Facturas Express");
        btnExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpressActionPerformed(evt);
            }
        });
        panelGeneral.add(btnExpress);
        btnExpress.setBounds(30, 590, 140, 70);

        btnComerAqui.setBackground(new java.awt.Color(255, 153, 153));
        btnComerAqui.setText("Facturas comer en el local");
        btnComerAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComerAquiActionPerformed(evt);
            }
        });
        panelGeneral.add(btnComerAqui);
        btnComerAqui.setBounds(220, 590, 200, 70);

        btnParaLlevar.setBackground(new java.awt.Color(255, 153, 153));
        btnParaLlevar.setText("Facturas para Llevar");
        btnParaLlevar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaLlevarActionPerformed(evt);
            }
        });
        panelGeneral.add(btnParaLlevar);
        btnParaLlevar.setBounds(470, 590, 170, 70);

        btnSalir.setBackground(new java.awt.Color(255, 153, 153));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelGeneral.add(btnSalir);
        btnSalir.setBounds(770, 590, 110, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpressActionPerformed
        scrollTablaExpress.setVisible(true);
        scrollTablaComerAqui.setVisible(false);
        scrollTablaLLevar.setVisible(false);
    }//GEN-LAST:event_btnExpressActionPerformed

    private void btnComerAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComerAquiActionPerformed
        scrollTablaExpress.setVisible(false);
        scrollTablaComerAqui.setVisible(true);
        scrollTablaLLevar.setVisible(false);
    }//GEN-LAST:event_btnComerAquiActionPerformed

    private void btnParaLlevarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaLlevarActionPerformed
        scrollTablaExpress.setVisible(false);
        scrollTablaComerAqui.setVisible(false);
        scrollTablaLLevar.setVisible(true);
    }//GEN-LAST:event_btnParaLlevarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

   
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
    private javax.swing.JButton btnComerAqui;
    private javax.swing.JButton btnExpress;
    private javax.swing.JButton btnParaLlevar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JScrollPane scrollTablaComerAqui;
    private javax.swing.JScrollPane scrollTablaExpress;
    private javax.swing.JScrollPane scrollTablaLLevar;
    private javax.swing.JTable tablaComerAqui;
    private javax.swing.JTable tablaExpress;
    private javax.swing.JTable tablaLLevar;
    // End of variables declaration//GEN-END:variables
}
