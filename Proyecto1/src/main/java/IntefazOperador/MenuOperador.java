/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IntefazOperador;

import InterfazDeControlDePrestamosDevoluciones.*;
import Logica.ModuloDeAutenticacion;
import InterfazAdmin.*;

import ModuloGestionDeLibross.ModuloDeGestionDeLibrosss;

public class MenuOperador extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    
    public MenuOperador(ModuloDeAutenticacion Auten) {
        initComponents();
        
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        tbnListar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGestionEstudiantes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Modulos de Gestion de Libros");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        btnDevolver.setText("Devolver Libro");
        btnDevolver.addActionListener(this::btnDevolverActionPerformed);

        tbnListar.setText("Listado de Prestamos Activos");
        tbnListar.addActionListener(this::tbnListarActionPerformed);

        jLabel2.setText("Módulo de Gestión de Estudiantes");

        btnGestionEstudiantes.setText("Ir");
        btnGestionEstudiantes.addActionListener(this::btnGestionEstudiantesActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDevolver)
                                .addGap(76, 76, 76))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(tbnListar)))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(btnGestionEstudiantes)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnListar)
                .addGap(30, 30, 30)
                .addComponent(btnDevolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnGestionEstudiantes))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        ModuloDeGestionDeLibrosss ventanaLibros = new ModuloDeGestionDeLibrosss(this.Auten);
    
        ventanaLibros.setVisible(true);
    
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        RegistroDeDevolucion ventana = new RegistroDeDevolucion(Auten);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void tbnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnListarActionPerformed
        
        ListadoDePrestamosActivos ventana = new ListadoDePrestamosActivos(Auten);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbnListarActionPerformed

    private void btnGestionEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEstudiantesActionPerformed
        new GestionEstudiantes(Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionEstudiantesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton tbnListar;
    // End of variables declaration//GEN-END:variables
}
