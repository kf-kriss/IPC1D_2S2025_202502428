/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.ModuloDeAutenticacion;
import InterfazAdmin.MenuAdminn;
import IntefazOperador.MenuOperador;

import Logica.Bitacora;

import javax.swing.JOptionPane;

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
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeguirAdelante)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(IngreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IngreContra, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IngreUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IngreContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(SeguirAdelante)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguirAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirAdelanteActionPerformed
    String VeUsu = IngreUsu.getText();
    String VeContra = new String(IngreContra.getPassword());
    
    String QueSoy = Auten.validarIngreso(VeUsu, VeContra);
    
    switch (QueSoy) {
        case "ADMIN":
            Auten.usuarioActual = VeUsu;
            
            Bitacora.registrar("INICIAR SESION", VeUsu, "AUTENTICACION");
            
            MenuAdminn VenAdminn = new MenuAdminn(this.Auten);
            VenAdminn.setVisible(true);
            this.dispose();
            break;
            
        case "OPERADOR":
            
            Auten.usuarioActual = VeUsu;
            
            Bitacora.registrar("INICIAR SESION", VeUsu, "AUTENTICACION");
            
            MenuOperador VenOpe = new MenuOperador(this.Auten,VeUsu);
            VenOpe.setVisible(true);
            this.dispose();
            break;
            
        case "ESTUDIANTE":
            
            Auten.usuarioActual = VeUsu;
            
            Bitacora.registrar("INICIAR SESION", VeUsu, "AUTENTICACION");
            
            Modelos.Usuarios estudiante = Auten.buscarEstudiantePorCarnet(VeUsu);
            
            new MenuEstudiante(this.Auten, estudiante).setVisible(true);
            this.dispose();
            break;
        default:
            Bitacora.registrar("INICIAR SESION FALLIDO", "DESCONOCIDO", "AUTENTICACION");
            javax.swing.JOptionPane.showMessageDialog(this, "Datos Incorrectos");
            
            IngreUsu.setText("");
            IngreContra.setText("");
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
