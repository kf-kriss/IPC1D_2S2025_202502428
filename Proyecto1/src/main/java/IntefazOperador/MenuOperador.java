/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IntefazOperador;

import Interfaz.VentanaReportes;
import InterfazDeControlDePrestamosDevoluciones.*;
import Logica.ModuloDeAutenticacion;
import InterfazAdmin.*;
import Logica.Bitacora;
import ModuloGestionDeLibross.ModuloDeGestionDeLibrosss;

public class MenuOperador extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    private String usuarioActual;
    
    public MenuOperador(ModuloDeAutenticacion Auten, String usuario) {
        initComponents();
        
        this.Auten = Auten;
        this.usuarioActual = usuario;
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        tbnListar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGestionEstudiantes = new javax.swing.JButton();
        tbnCerrar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

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

        tbnCerrar.setText("Cerrar Sesión");
        tbnCerrar.addActionListener(this::tbnCerrarActionPerformed);

        btnReporte.setText("Reportes");
        btnReporte.addActionListener(this::btnReporteActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnDevolver)
                        .addGap(28, 28, 28)
                        .addComponent(tbnListar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(btnGestionEstudiantes)))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(tbnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnListar)
                    .addComponent(btnDevolver))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnGestionEstudiantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReporte)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tbnCerrar)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        ModuloDeGestionDeLibrosss ventanaLibros = new ModuloDeGestionDeLibrosss(this.Auten, usuarioActual);
    
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

    private void tbnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnCerrarActionPerformed

        Bitacora.registrar("CERRAR SESION", this.usuarioActual, "AUTENTICACION");

        Interfaz.InterfazIniciarSesion login = new Interfaz.InterfazIniciarSesion(this.Auten);

        login.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_tbnCerrarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        new VentanaReportes(Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton tbnCerrar;
    private javax.swing.JButton tbnListar;
    // End of variables declaration//GEN-END:variables
}
