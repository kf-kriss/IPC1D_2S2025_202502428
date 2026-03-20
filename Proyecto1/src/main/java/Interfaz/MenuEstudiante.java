/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.ModuloDeAutenticacion;
import InterfazDeControlDePrestamosDevoluciones.SolicitudPrestamo3;
import InterfazDeControlDePrestamosDevoluciones.HistorialDePrestamosDelEstudiante;
import Logica.Bitacora;

import javax.swing.JOptionPane;

public class MenuEstudiante extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    Modelos.Usuarios estudianteActual;
    
    public MenuEstudiante(ModuloDeAutenticacion Auten, Modelos.Usuarios estudiante) {
        initComponents();
        
        this.Auten = Auten;
        this.estudianteActual = estudiante;
        
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SolicitarPrestamo = new javax.swing.JButton();
        MiHistorial = new javax.swing.JButton();
        Cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVerDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SolicitarPrestamo.setText("Solicitar Prestamo");
        SolicitarPrestamo.addActionListener(this::SolicitarPrestamoActionPerformed);

        MiHistorial.setText("Mi Historial");
        MiHistorial.addActionListener(this::MiHistorialActionPerformed);

        Cerrar.setText("CerrarSesion");
        Cerrar.addActionListener(this::CerrarActionPerformed);

        jLabel1.setText("Menú de Estudiante");

        btnVerDatos.setText("Ver mis Datos");
        btnVerDatos.addActionListener(this::btnVerDatosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Cerrar)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(MiHistorial))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(SolicitarPrestamo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerDatos)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(SolicitarPrestamo)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerDatos)
                        .addGap(6, 6, 6)))
                .addComponent(MiHistorial)
                .addGap(45, 45, 45)
                .addComponent(Cerrar)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SolicitarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitarPrestamoActionPerformed
        
        new InterfazDeControlDePrestamosDevoluciones.SolicitudPrestamo3(Auten, estudianteActual).setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_SolicitarPrestamoActionPerformed

    private void MiHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiHistorialActionPerformed

        HistorialDePrestamosDelEstudiante ventana = new HistorialDePrestamosDelEstudiante(this.Auten, estudianteActual);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MiHistorialActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed

        Bitacora.registrar("CERRAR_SESION", estudianteActual.getUsuarioo(), "AUTENTICACION");
        InterfazIniciarSesion login = new InterfazIniciarSesion(this.Auten);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CerrarActionPerformed

    private void btnVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDatosActionPerformed
        new Interfaz.VerDatosEstudiante(Auten, estudianteActual).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVerDatosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton MiHistorial;
    private javax.swing.JButton SolicitarPrestamo;
    private javax.swing.JButton btnVerDatos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
