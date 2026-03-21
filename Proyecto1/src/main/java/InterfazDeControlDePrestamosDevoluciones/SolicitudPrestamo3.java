/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazDeControlDePrestamosDevoluciones;

import Logica.*;
import Modelos.*;
import Interfaz.*;

import javax.swing.JOptionPane;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SolicitudPrestamo3 extends javax.swing.JFrame {

    ModuloDeAutenticacion Auten;
    Usuarios estudianteActual;
    
    public SolicitudPrestamo3(ModuloDeAutenticacion Auten, Usuarios estudiante) {
        initComponents();
        this.Auten = Auten;
        this.estudianteActual = estudiante;
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Solicitar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        txtCodIsbn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese Código o ISBN");

        Solicitar.setText("Solicitar");
        Solicitar.addActionListener(this::SolicitarActionPerformed);

        Regresar.setText("Regresar");
        Regresar.addActionListener(this::RegresarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Regresar)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(Solicitar))
                        .addComponent(txtCodIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(txtCodIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Solicitar)
                .addGap(50, 50, 50)
                .addComponent(Regresar)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitarActionPerformed
        String valor = txtCodIsbn.getText().trim();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese código o ISBN");
            return;
        }

        String isbnEncontrado = null;
        for (int i = 0; i < Auten.ContadorLibros; i++) {
            if (Auten.LibrosTotales[i].ISBN().equals(valor) || 
                String.valueOf(Auten.LibrosTotales[i].Codigo()).equals(valor)) {
                isbnEncontrado = Auten.LibrosTotales[i].ISBN();
                break;
            }
        }

        if (isbnEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Libro no encontrado");
            return;
        }

        Logica.ModuloPrestamos logica = new Logica.ModuloPrestamos();
        String resultado = logica.solicitarPrestamoEstudiante(Auten, estudianteActual.getUsuarioo(), isbnEncontrado);

        if (resultado.contains("EXITO")) {
            String codigo = resultado.replace("EXITO: Código ", "");
            for (int i = 0; i < Auten.ContadorPrestamos; i++) {
                if (Auten.PrestamosTotales[i].getCodigoDePrestamo().equals(codigo)) {
                    JOptionPane.showMessageDialog(this, 
                        "Préstamo exitoso\n" +
                        "Código: " + codigo + "\n" +
                        "Fecha límite: " + Auten.PrestamosTotales[i].getFechaLimite());
                    break;
                }
            }
            txtCodIsbn.setText("");
        } else {
            JOptionPane.showMessageDialog(this, resultado);
        }
    
    }//GEN-LAST:event_SolicitarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed

        new MenuEstudiante(this.Auten, estudianteActual).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regresar;
    private javax.swing.JButton Solicitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCodIsbn;
    // End of variables declaration//GEN-END:variables
}
