/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazDeControlDePrestamosDevoluciones; 

import Logica.ModuloDeAutenticacion;
import Interfaz.MenuEstudiante;

import Modelos.Prestamos;
import Modelos.NodoPrestamo;
import Modelos.Usuarios;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class HistorialDePrestamosDelEstudiante extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    Usuarios estudianteActual;
    
    public HistorialDePrestamosDelEstudiante(ModuloDeAutenticacion Auten, Usuarios estudiante) {
        initComponents();
        
        this.Auten = Auten;
        this.estudianteActual = estudiante;
        this.setLocationRelativeTo(null);
        cargarHistorial();
    }
    
    private void cargarHistorial() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Código");
        modelo.addColumn("ISBN");
        modelo.addColumn("Fecha Préstamo");
        modelo.addColumn("Fecha Límite");
        modelo.addColumn("Fecha Devolución");
        modelo.addColumn("Estado");
        
        if (estudianteActual == null) {
            JOptionPane.showMessageDialog(this, "No hay estudiante seleccionado");
            tblHistorial.setModel(modelo);
            return;
        }
        
        NodoPrestamo actual = estudianteActual.getHistorial();
        
        if (actual == null) {
            JOptionPane.showMessageDialog(this, "No hay préstamos en el historial");
        } else {
            while (actual != null) {
                Prestamos p = actual.prestamo;
                Object[] fila = {
                    p.getCodigoDePrestamo(),
                    p.getIsbnLibro(),
                    p.getFechaDePrestamo(),
                    p.getFechaLimite(),
                    p.getFechaDeDevolucion() != null ? p.getFechaDeDevolucion() : "No devuelto",
                    p.getEstado()
                };
                modelo.addRow(fila);
                actual = actual.siguiente;
            }
        }
        tblHistorial.setModel(modelo);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        new MenuEstudiante(this.Auten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorial;
    // End of variables declaration//GEN-END:variables
}
