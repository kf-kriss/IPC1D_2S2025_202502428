/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAdmin;

import Logica.ModuloDeAutenticacion;
import InterfazDeControlDePrestamosDevoluciones.*;

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnDevolver)
                                .addGap(30, 30, 30)
                                .addComponent(btnListar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGestionEstudiantes)))
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
                .addContainerGap(112, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarOp;
    private javax.swing.JButton ListadoOp;
    private javax.swing.JButton RegistarOp;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
