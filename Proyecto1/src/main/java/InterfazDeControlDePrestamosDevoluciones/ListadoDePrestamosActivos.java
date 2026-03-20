/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazDeControlDePrestamosDevoluciones;

import Logica.ModuloDeAutenticacion;
import Modelos.Prestamos;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ListadoDePrestamosActivos extends javax.swing.JFrame {
    
    ModuloDeAutenticacion Auten;
    private DefaultTableModel modelo;
    
    public ListadoDePrestamosActivos(ModuloDeAutenticacion Auten) {
        initComponents();
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
        configurarTabla();
        cargarPrestamos();
    }
    
    private void configurarTabla() {
        String[] columnas = {"Código", "Carnet", "ISBN", "F.Préstamo", "F.Límite", "Días", "Estado"};
        modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaPrestamos.setModel(modelo);
        
        // Para colorear las filas vencidas (así parece bien principiante)
        tablaPrestamos.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                String estado = table.getValueAt(row, 6).toString();
                if (estado.equals("VENCIDO")) {
                    c.setBackground(new Color(255, 200, 200)); // Rojo clarito
                } else {
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        });
    }
    
    private void cargarPrestamos() {
        modelo.setRowCount(0);
        LocalDate hoy = LocalDate.now();
        
        for (int i = 0; i < Auten.ContadorPrestamos; i++) {
            Prestamos p = Auten.PrestamosTotales[i];
            if (p.getEstado().equals("ACTIVO")) {
                boolean vencido = p.getFechaLimite().isBefore(hoy);
                long dias = ChronoUnit.DAYS.between(p.getFechaLimite(), hoy);
                if (dias < 0) dias = 0;
                
                Object[] fila = {
                    p.getCodigoDePrestamo(),
                    p.getCarnetEstudiante(),
                    p.getIsbnLibro(),
                    p.getFechaDePrestamo(),
                    p.getFechaLimite(),
                    vencido ? dias + " días" : "Vigente",
                    vencido ? "VENCIDO" : "ACTIVO"
                };
                modelo.addRow(fila);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

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
        jScrollPane1.setViewportView(tablaPrestamos);

        jLabel1.setText("Listado de Prestamos Activos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(btnRegresar)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarPrestamos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPrestamos;
    // End of variables declaration//GEN-END:variables
}
