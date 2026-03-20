/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazDeControlDePrestamosDevoluciones;

import Modelos.*;
import Logica.*;

import javax.swing.JOptionPane;

public class MenuDeControDePrestamosYDevoluciones extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    ModuloPrestamos logic;
    
    public MenuDeControDePrestamosYDevoluciones() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistroP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegistroP.setText("Registro de Prestamo");
        RegistroP.addActionListener(this::RegistroPActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(RegistroP)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(RegistroP)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistroPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroPActionPerformed
RegistroDePrestamo ventana = new RegistroDePrestamo(Auten); 
ventana.setVisible(true);
    }//GEN-LAST:event_RegistroPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistroP;
    // End of variables declaration//GEN-END:variables
}
