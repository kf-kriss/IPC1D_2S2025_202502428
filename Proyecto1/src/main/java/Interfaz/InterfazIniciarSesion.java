/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.ModuloDeAutenticacion;

import InterfazAdmin.MenuAdminn;

public class InterfazIniciarSesion extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    
    public InterfazIniciarSesion(ModuloDeAutenticacion Auten) {
        initComponents();
        
        this.Auten = Auten;
        
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        IngreUsu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IngreContra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        SeguirAdelante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario :");

        jLabel2.setText("Contraseña :");

        jLabel3.setText("Inicio de Sesion");

        SeguirAdelante.setText("E n t r a r");
        SeguirAdelante.addActionListener(this::SeguirAdelanteActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(IngreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeguirAdelante)
                            .addComponent(jLabel1))))
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(IngreContra, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(IngreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(IngreContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(SeguirAdelante)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguirAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirAdelanteActionPerformed
        String VeUsu = IngreUsu.getText();
        String VeContra = IngreContra.getText();
        
        
        String QueSoy = Auten.validarIngreso(VeUsu, VeContra);
        
        switch (QueSoy) {
        case "ADMIN":
            
            MenuAdminn VenAdminn = new MenuAdminn(this.Auten);
            
            VenAdminn.setVisible(true);
            
            this.dispose();
            break;
        case "OPERADOR":
            
            new MenuOperador(this.Auten).setVisible(true);
            
            this.dispose();
            break;
        case "ESTUDIANTE":
            
            new MenuEstudiante(this.Auten).setVisible(true);
            
            this.dispose();
            break;
        default:
            javax.swing.JOptionPane.showMessageDialog(this, "Datos Incorrectos");
            break;
        }
    }//GEN-LAST:event_SeguirAdelanteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField IngreContra;
    private javax.swing.JTextField IngreUsu;
    private javax.swing.JButton SeguirAdelante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
