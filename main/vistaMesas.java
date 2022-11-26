
package main;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class vistaMesas extends javax.swing.JFrame {
    
    conjuntoMesas disponibles = new conjuntoMesas();
    ArrayList <JButton> botones;
    vistaBanco principal;
  
    public vistaMesas(vistaBanco principal) {
        this.principal = principal;
        cargarMesas();
        initComponents();
         cargarBotones();
    }
    
    private void cargarBotones(){
        botones = new ArrayList<>();
        botones.add(btnMesa1);
        botones.add(btnMesa2);
        botones.add(btnMesa3);
        botones.add(btnMesa4);
        botones.add(btnMesa5);
        botones.add(btnMesa6);
        botones.add(btnMesa7);
        botones.add(btnMesa8);
        botones.add(btnMesa9);
        botones.add(btnMesa10);
        botones.add(btnMesa11);
        botones.add(btnMesa12);
        botones.add(btnMesa13);
        botones.add(btnMesa14);
        botones.add(btnMesa15);
        botones.add(btnMesa16);
    }
    
    private void cargarMesas(){
        mesa Mesa1 = new mesa(1,4);
        mesa Mesa2 = new mesa(2,6);
        mesa Mesa3 = new mesa(3,6);
        mesa Mesa4 = new mesa(4,4);
        mesa Mesa5 = new mesa(5,4);
        mesa Mesa6 = new mesa(6,6);
        mesa Mesa7 = new mesa(7,6);
        mesa Mesa8 = new mesa(8,4);
        mesa Mesa9 = new mesa(9,6);
        mesa Mesa10 = new mesa(10,4);
        mesa Mesa11 = new mesa(11,4);
        mesa Mesa12 = new mesa(12,4);
        mesa Mesa13 = new mesa(13,4);
        mesa Mesa14 = new mesa(14,4);
        mesa Mesa15 = new mesa(15,4);
        mesa Mesa16 = new mesa(16,6);
        disponibles.Agregar(Mesa1);
        disponibles.Agregar(Mesa2);
        disponibles.Agregar(Mesa3);
        disponibles.Agregar(Mesa4);
        disponibles.Agregar(Mesa5);
        disponibles.Agregar(Mesa6);
        disponibles.Agregar(Mesa7);
        disponibles.Agregar(Mesa8);
        disponibles.Agregar(Mesa9);
        disponibles.Agregar(Mesa10);
        disponibles.Agregar(Mesa11);
        disponibles.Agregar(Mesa12);
        disponibles.Agregar(Mesa13);
        disponibles.Agregar(Mesa14);
        disponibles.Agregar(Mesa15);
        disponibles.Agregar(Mesa16);
    }
    
    public void actualizarMesa(mesa Mesa){
        if("".equals(Mesa.cAsignado())){
            disponibles.actualizar(Mesa);
            for(int i = 0; i < disponibles.nMesas(); i++){
                if(Mesa.numero() == disponibles.Recuperar(i).numero()){
                botones.get(i).setBackground(new java.awt.Color(102, 255, 102));
                break;
                }
            }
        }else{
            disponibles.actualizar(Mesa);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tituloMesas = new javax.swing.JLabel();
        btnMesa1 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        btnMesa12 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa16 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa9 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa10 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa15 = new javax.swing.JButton();
        btnMesa11 = new javax.swing.JButton();
        btnMesa13 = new javax.swing.JButton();
        btnMesa14 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tituloComensales = new javax.swing.JLabel();
        txtComensales = new javax.swing.JTextField();

        jLabel8.setText("Ventana");

        setLocationByPlatform(true);
        setPreferredSize(new Dimension(813, 650));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        tituloMesas.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        tituloMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMesas.setText("Mesas del restaurante");
        jPanel1.add(tituloMesas);
        tituloMesas.setBounds(280, 20, 220, 22);

        btnMesa1.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa1.setText("1");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa1);
        btnMesa1.setBounds(50, 70, 80, 60);

        btnMesa5.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa5.setText("5");
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa5);
        btnMesa5.setBounds(50, 190, 80, 60);

        btnMesa3.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa3.setText("3");
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa3);
        btnMesa3.setBounds(430, 70, 130, 60);

        btnMesa8.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa8.setText("8");
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa8);
        btnMesa8.setBounds(640, 190, 90, 60);

        btnMesa12.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa12.setText("12");
        btnMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa12ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa12);
        btnMesa12.setBounds(480, 300, 80, 60);

        btnMesa4.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa4.setText("4");
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa4);
        btnMesa4.setBounds(640, 70, 90, 60);

        btnMesa16.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa16.setText("16");
        btnMesa16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa16ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa16);
        btnMesa16.setBounds(640, 320, 80, 140);

        btnMesa2.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa2.setText("2");
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa2);
        btnMesa2.setBounds(210, 70, 130, 60);

        btnMesa9.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa9.setText("9");
        btnMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa9ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa9);
        btnMesa9.setBounds(50, 320, 80, 140);

        btnMesa6.setBackground(new java.awt.Color(153, 255, 153));
        btnMesa6.setText("6");
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa6);
        btnMesa6.setBounds(210, 180, 130, 60);

        btnMesa10.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa10.setText("10");
        btnMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa10ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa10);
        btnMesa10.setBounds(220, 300, 80, 60);

        btnMesa7.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa7.setText("7");
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa7);
        btnMesa7.setBounds(430, 180, 130, 60);

        btnMesa15.setBackground(new java.awt.Color(51, 255, 51));
        btnMesa15.setText("15");
        btnMesa15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa15ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa15);
        btnMesa15.setBounds(480, 400, 80, 60);

        btnMesa11.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa11.setText("11");
        btnMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa11ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa11);
        btnMesa11.setBounds(350, 300, 80, 60);

        btnMesa13.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa13.setText("13");
        btnMesa13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa13ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa13);
        btnMesa13.setBounds(220, 400, 80, 60);

        btnMesa14.setBackground(new java.awt.Color(102, 255, 102));
        btnMesa14.setText("14");
        btnMesa14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa14ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMesa14);
        btnMesa14.setBounds(350, 400, 80, 60);

        jLabel2.setText("Entrada");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(580, 10, 50, 16);

        jLabel3.setText("Ventana");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(710, 280, 47, 16);

        jLabel4.setText("Ventana");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 10, 50, 16);

        jLabel5.setText("Recepcion");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(660, 10, 60, 16);

        jLabel6.setText("Ventana");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 280, 50, 16);

        jLabel7.setText("Ventana");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(150, 480, 50, 16);

        jLabel9.setText("Ventana");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(580, 480, 50, 16);

        tituloComensales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloComensales.setText("Cantidad de comensales:");
        jPanel1.add(tituloComensales);
        tituloComensales.setBounds(240, 520, 160, 20);

        txtComensales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComensalesActionPerformed(evt);
            }
        });
        jPanel1.add(txtComensales);
        txtComensales.setBounds(400, 520, 70, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 770, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        if(escogerMesa(4)){
            btnMesa5.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void txtComensalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComensalesActionPerformed

    }//GEN-LAST:event_txtComensalesActionPerformed

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
       if(escogerMesa(0)){
            btnMesa1.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
       if(escogerMesa(1)){
            btnMesa2.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        if(escogerMesa(2)){
            btnMesa3.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
       if(escogerMesa(3)){
            btnMesa4.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
        if(escogerMesa(5)){
            btnMesa6.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
       if(escogerMesa(6)){
            btnMesa7.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
        if(escogerMesa(7)){
            btnMesa8.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa9ActionPerformed
       if(escogerMesa(8)){
            btnMesa9.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa9ActionPerformed

    private void btnMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa10ActionPerformed
       if(escogerMesa(9)){
            btnMesa10.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa10ActionPerformed

    private void btnMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa11ActionPerformed
        if(escogerMesa(10)){
            btnMesa11.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa11ActionPerformed

    private void btnMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa12ActionPerformed
        if(escogerMesa(11)){
            btnMesa12.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa12ActionPerformed

    private void btnMesa13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa13ActionPerformed
        if(escogerMesa(12)){
            btnMesa13.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa13ActionPerformed

    private void btnMesa14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa14ActionPerformed
        if(escogerMesa(13)){
            btnMesa14.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa14ActionPerformed

    private void btnMesa15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa15ActionPerformed
        if(escogerMesa(14)){
            btnMesa15.setBackground(new java.awt.Color(255, 102, 102));
        }
    }//GEN-LAST:event_btnMesa15ActionPerformed

    private void btnMesa16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa16ActionPerformed
        escogerMesa(15);
    }//GEN-LAST:event_btnMesa16ActionPerformed

    private boolean escogerMesa(int x){
        boolean validacion = false;
        mesa aux = disponibles.Recuperar(x);
         if(aux.estado() == true){
                principal.cargarMesa(aux);
                validacion = true;
                txtComensales.setText("");
               JOptionPane.showMessageDialog(null, "Se ha cargado la mesa");
         }else  if(!validarTxt()){
             if(Integer.parseInt(txtComensales.getText()) > aux.capacidad()){
                    JOptionPane.showMessageDialog(null, "Lo sentimos la cantidad de comensales excede la capacidad");
              }else{
                aux.ocupar();
                principal.cargarMesa(aux);
                validacion = true;
                txtComensales.setText("");
                JOptionPane.showMessageDialog(null, "Se eligio esta mesa");
                }
            }
        return validacion;
    }
        
    private boolean validarTxt(){
        boolean validacion = false;
        if(txtComensales.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad de comensales");
            validacion = true;
        }
        return validacion;
       }
    
    
    public void init() {
        setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(vistaMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
    private javax.swing.JButton btnMesa13;
    private javax.swing.JButton btnMesa14;
    private javax.swing.JButton btnMesa15;
    private javax.swing.JButton btnMesa16;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tituloComensales;
    private javax.swing.JLabel tituloMesas;
    private javax.swing.JTextField txtComensales;
    // End of variables declaration//GEN-END:variables
}
