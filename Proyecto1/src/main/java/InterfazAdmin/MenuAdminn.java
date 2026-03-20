/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAdmin;

import Interfaz.*;
import Logica.Bitacora;
import Logica.ModuloDeAutenticacion;
import InterfazDeControlDePrestamosDevoluciones.*;
import ModuloGestionDeLibross.ModuloDeGestionDeLibrosss;

public class MenuAdminn extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    
    public MenuAdminn(ModuloDeAutenticacion Auten) {
        initComponents();
        
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegistarOp = new javax.swing.JButton();
        EliminarOp = new javax.swing.JButton();
        ListadoOp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGestionEstudiantes = new javax.swing.JButton();
        tbnCerrar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnMLibros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        RegistarOp.setText("Registrar Operador");
        RegistarOp.addActionListener(this::RegistarOpActionPerformed);

        EliminarOp.setText("Eliminar Operador");
        EliminarOp.addActionListener(this::EliminarOpActionPerformed);

        ListadoOp.setText("Listado de Operadores");
        ListadoOp.addActionListener(this::ListadoOpActionPerformed);

        jLabel1.setText("Menú Exclusivo de Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RegistarOp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarOp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListadoOp))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistarOp)
                    .addComponent(EliminarOp)
                    .addComponent(ListadoOp))
                .addContainerGap())
        );

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(this::btnDevolverActionPerformed);

        btnListar.setText("Listado de Préstamos Activos");
        btnListar.addActionListener(this::btnListarActionPerformed);

        jLabel2.setText("Módulo de Gestión de Estudiantes");

        btnGestionEstudiantes.setText("Ir");
        btnGestionEstudiantes.addActionListener(this::btnGestionEstudiantesActionPerformed);

        tbnCerrar.setText("Cerrar Sesión");
        tbnCerrar.addActionListener(this::tbnCerrarActionPerformed);

        btnReporte.setText("Reportes");
        btnReporte.addActionListener(this::btnReporteActionPerformed);

        btnMLibros.setText("Modulo Gestion de Libros");
        btnMLibros.addActionListener(this::btnMLibrosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnDevolver)
                                .addGap(48, 48, 48)
                                .addComponent(btnListar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(82, 82, 82)
                                        .addComponent(btnGestionEstudiantes)
                                        .addGap(0, 82, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tbnCerrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnMLibros)
                                                .addGap(34, 34, 34)))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver)
                    .addComponent(btnListar))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnGestionEstudiantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnMLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbnCerrar)
                    .addComponent(btnReporte))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListadoOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoOpActionPerformed

        ListadoDeOperadores VenList = new ListadoDeOperadores(this.Auten);
        
        VenList.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_ListadoOpActionPerformed

    private void RegistarOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistarOpActionPerformed

        RegistroDeOperador VenRegistro = new RegistroDeOperador(this.Auten);
        
        VenRegistro.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_RegistarOpActionPerformed

    private void EliminarOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarOpActionPerformed
        
        EliminacionDeOperador VenElim = new EliminacionDeOperador(this.Auten);
        
        VenElim.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_EliminarOpActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed

        RegistroDeDevolucion ventana = new RegistroDeDevolucion(Auten);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
        ListadoDePrestamosActivos ventana = new ListadoDePrestamosActivos(Auten);
        ventana.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnGestionEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEstudiantesActionPerformed
        new GestionEstudiantes(Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionEstudiantesActionPerformed

    private void tbnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnCerrarActionPerformed
    
        Bitacora.registrar("CERRAR SESION", "ADMIN", "AUTENTICACION");
        
        Interfaz.InterfazIniciarSesion login = new Interfaz.InterfazIniciarSesion(this.Auten);
    
        login.setVisible(true);
    
        this.dispose();
    }//GEN-LAST:event_tbnCerrarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        new VentanaReportes(Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnMLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMLibrosActionPerformed
        new ModuloGestionDeLibross.ModuloDeGestionDeLibrosss(Auten, Auten.usuarioActual).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMLibrosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarOp;
    private javax.swing.JButton ListadoOp;
    private javax.swing.JButton RegistarOp;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMLibros;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tbnCerrar;
    // End of variables declaration//GEN-END:variables
}
