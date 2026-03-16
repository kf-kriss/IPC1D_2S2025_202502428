/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAdmin;

import Logica.ModuloDeAutenticacion;

public class MenuAdminn extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    
    public MenuAdminn(ModuloDeAutenticacion Auten) {
        initComponents();
        
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistarOp = new javax.swing.JButton();
        EliminarOp = new javax.swing.JButton();
        ListadoOp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegistarOp.setText("Registrar Operador");
        RegistarOp.addActionListener(this::RegistarOpActionPerformed);

        EliminarOp.setText("Eliminar Operador");
        EliminarOp.addActionListener(this::EliminarOpActionPerformed);

        ListadoOp.setText("Listado de Operadores");
        ListadoOp.addActionListener(this::ListadoOpActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistarOp)
                            .addComponent(EliminarOp)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(ListadoOp)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(RegistarOp)
                .addGap(18, 18, 18)
                .addComponent(EliminarOp)
                .addGap(35, 35, 35)
                .addComponent(ListadoOp)
                .addContainerGap(84, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarOp;
    private javax.swing.JButton ListadoOp;
    private javax.swing.JButton RegistarOp;
    // End of variables declaration//GEN-END:variables
}
