/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.ModuloDeAutenticacion;

import javax.swing.JOptionPane;

public class InterMenuInicial extends javax.swing.JFrame {
    
    //Atributos
    ModuloDeAutenticacion Auten;
    
    //Constructor
    public InterMenuInicial(ModuloDeAutenticacion Atenticacion) {
        initComponents();
        
        this.Auten = Atenticacion;
        
        //Centrar ventana
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonIngresar = new javax.swing.JButton();
        BotonRegistrarse = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BiblioSystem");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        BotonIngresar.setBackground(new java.awt.Color(0, 153, 153));
        BotonIngresar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        BotonIngresar.setText("I n g r e s a r");
        BotonIngresar.addActionListener(this::BotonIngresarActionPerformed);

        BotonRegistrarse.setBackground(new java.awt.Color(0, 204, 204));
        BotonRegistrarse.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        BotonRegistrarse.setText("Registrarse");
        BotonRegistrarse.addActionListener(this::BotonRegistrarseActionPerformed);

        BotonSalir.setBackground(new java.awt.Color(0, 153, 153));
        BotonSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        BotonSalir.setText("S a l i r");
        BotonSalir.addActionListener(this::BotonSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(BotonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(BotonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngresarActionPerformed
        InterfazIniciarSesion Venses = new InterfazIniciarSesion(this.Auten);
        
        Venses.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_BotonIngresarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarseActionPerformed

        InterfazRegistroEstudiante VenReg = new InterfazRegistroEstudiante(this.Auten);
        
        VenReg.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_BotonRegistrarseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIngresar;
    private javax.swing.JButton BotonRegistrarse;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
