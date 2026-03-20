/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAdmin;

import Logica.ModuloDeAutenticacion;
import Logica.ModuloDeAdministrador;

public class EliminacionDeOperador extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    
    public EliminacionDeOperador(ModuloDeAutenticacion Auten) {
        initComponents();
        
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtElimUsu = new javax.swing.JTextField();
        btnElim = new javax.swing.JButton();
        btonRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnElim.setText("Eliminar");
        btnElim.addActionListener(this::btnElimActionPerformed);

        btonRegresar.setText("Regresar");
        btonRegresar.addActionListener(this::btonRegresarActionPerformed);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Eliminar Operador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnElim)
                            .addComponent(txtElimUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btonRegresar))
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtElimUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnElim)
                .addGap(27, 27, 27)
                .addComponent(btonRegresar)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
    String usuario = txtElimUsu.getText();

    int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "¿Eliminar a " + usuario + "?");

    if (confirmar == 0) { 
        Logica.ModuloDeAdministrador logica = new Logica.ModuloDeAdministrador();
        boolean exito = logica.EliminacionDeOperador(this.Auten, usuario);

        if (exito) {
            javax.swing.JOptionPane.showMessageDialog(this, "Eliminado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No encontrado");
        }
    }
    }//GEN-LAST:event_btnElimActionPerformed

    private void btonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonRegresarActionPerformed
        new MenuAdminn(this.Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btonRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtElimUsu;
    // End of variables declaration//GEN-END:variables
}
