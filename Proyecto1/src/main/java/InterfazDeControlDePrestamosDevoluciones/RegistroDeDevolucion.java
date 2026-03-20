/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazDeControlDePrestamosDevoluciones;

import Logica.Bitacora;
import Logica.ModuloDeAutenticacion;
import Modelos.Prestamos;
import Modelos.Libros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class RegistroDeDevolucion extends javax.swing.JFrame {
    
    private ModuloDeAutenticacion Auten;
    private DefaultTableModel modelo;
    private Prestamos prestamoSeleccionado;
    

    
    public RegistroDeDevolucion(ModuloDeAutenticacion Auten) {
        
        initComponents();
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
        configurarTabla();
        buscarPrestamosActivos();
    }
    
    private void configurarTabla() {
        String[] columnas = {"Código", "Carnet", "ISBN", "Fecha Préstamo", "Fecha Límite", "Estado"};
        modelo = new DefaultTableModel(null, columnas);
        tablaPrestamos.setModel(modelo);
    }
    
    private void buscarPrestamosActivos() {
        modelo.setRowCount(0);
        String busqueda = txtBuscar.getText().trim();
        
        for (int i = 0; i < Auten.ContadorPrestamos; i++) {
            Prestamos p = Auten.PrestamosTotales[i];
            if (p.getEstado().equals("ACTIVO")) {
                if (busqueda.isEmpty() || 
                    p.getCodigoDePrestamo().contains(busqueda) ||
                    p.getCarnetEstudiante().contains(busqueda)) {
                    
                    Object[] fila = {
                        p.getCodigoDePrestamo(),
                        p.getCarnetEstudiante(),
                        p.getIsbnLibro(),
                        p.getFechaDePrestamo(),
                        p.getFechaLimite(),
                        p.getEstado()
                    };
                    modelo.addRow(fila);
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        btnDevolver = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPrestamosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPrestamos);

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(this::btnDevolverActionPerformed);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        jLabel1.setText("Registro de Devolucion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnDevolver)
                                .addGap(72, 72, 72)
                                .addComponent(btnRegresar)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnBuscar)
                        .addGap(40, 40, 40)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver)
                    .addComponent(btnRegresar))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPrestamosActivos(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrestamosMouseClicked

        int fila = tablaPrestamos.getSelectedRow();
        if (fila != -1) {
            String codPrestamo = modelo.getValueAt(fila, 0).toString();
            for (int i = 0; i < Auten.ContadorPrestamos; i++) {
                if (Auten.PrestamosTotales[i].getCodigoDePrestamo().equals(codPrestamo)) {
                    prestamoSeleccionado = Auten.PrestamosTotales[i];
                    break;
                }
            }
        }

    }//GEN-LAST:event_tablaPrestamosMouseClicked

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed

        if (prestamoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un préstamo de la tabla");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(this, 
            "¿Registrar devolución del préstamo " + prestamoSeleccionado.getCodigoDePrestamo() + "?");
        
        if (confirmar == 0) {
            
            Bitacora.registrar("REGISTRO_DE_DEVOLUCION", Auten.usuarioActual, "CONTROL_DE_PRESTAMOS_Y_DEVOLUCIONES");

            prestamoSeleccionado.setEstado("DEVUELTO");
            prestamoSeleccionado.setFechaDeDevolucion(LocalDate.now());
            

            for (int i = 0; i < Auten.ContadorLibros; i++) {
                Libros libro = Auten.LibrosTotales[i];
                if (libro.ISBN().equals(prestamoSeleccionado.getIsbnLibro())) {
                    libro.setDisponible(libro.Disponible() + 1);
                    break;
                }
            }
            
            Logica.ModuloPrestamos logica = new Logica.ModuloPrestamos();
            logica.actualizarArchivoCompleto(Auten);
            
            buscarPrestamosActivos();
            prestamoSeleccionado = null;
            
            JOptionPane.showMessageDialog(this, "Devolución registrada");
        }
    
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
