/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazAdmin;

import Logica.*;

import javax.swing.table.DefaultTableModel;

public class GestionEstudiantes extends javax.swing.JFrame {

    private ModuloDeAutenticacion Auten;
    private DefaultTableModel modelo;

    public GestionEstudiantes(ModuloDeAutenticacion Auten) {
        initComponents();
        this.Auten = Auten;
        this.setLocationRelativeTo(null);
        configurarTabla();
        listarTodos();
    }

private void configurarTabla() {
    String[] columnas = {"Carnet", "Nombre", "Carrera", "Préstamos", "Vencidos"};
    modelo = new DefaultTableModel(null, columnas);
    jTable1.setModel(modelo);
}

private void listarTodos() {
    modelo.setRowCount(0);
    for (int i = 0; i < Auten.ContadorDeCuentas; i++) {
        Modelos.Usuarios u = Auten.CuentasTotales[i];
        if (u.getRol().equalsIgnoreCase("Estudiante")) {
            int activos = 0;
            int vencidos = 0;
            
            for (int j = 0; j < Auten.ContadorPrestamos; j++) {
                Modelos.Prestamos p = Auten.PrestamosTotales[j];
                if (p.getCarnetEstudiante().equals(u.getUsuarioo()) && p.getEstado().equals("ACTIVO")) {
                    activos++;
                    if (p.getFechaLimite().isBefore(java.time.LocalDate.now())) {
                        vencidos++;
                    }
                }
            }
            
            Object[] fila = {u.getUsuarioo(), u.getNombreCompleto(), u.getCarrera(), activos, vencidos};
            modelo.addRow(fila);
        }
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestión de Estudiantes");

        btnBuscar.setText("Buscar por Carnet");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnActualizar.setText("Actualizar Lista");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar Estudiante");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        jButton4.setText("Regresar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminar))))
                .addGap(11, 11, 11)
                .addComponent(btnBuscar)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String carnet = jTextField1.getText().trim();
    
    if (!carnet.isEmpty()) {
        modelo.setRowCount(0);
        for (int i = 0; i < Auten.ContadorDeCuentas; i++) {
            Modelos.Usuarios u = Auten.CuentasTotales[i];
            if (u.getRol().equalsIgnoreCase("Estudiante") && u.getUsuarioo().equals(carnet)) {
                Object[] fila = {u.getUsuarioo(), u.getNombreCompleto(), u.getCarrera(), 0, 0};
                modelo.addRow(fila);
                return;
            }
        }
        javax.swing.JOptionPane.showMessageDialog(this, "No encontrado");
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int fila = jTable1.getSelectedRow();
    if (fila >= 0) {
        String carnet = modelo.getValueAt(fila, 0).toString();
        int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "¿Eliminar?");
        if (confirmar == 0) {
            
            Bitacora.registrar("ELIMINAR_ESTUDIANTE", Auten.usuarioActual, "GESTION_DE_ESTUDIANTES_DE_BIBLIOTECA");
            
            for (int i = 0; i < Auten.ContadorDeCuentas; i++) {
                if (Auten.CuentasTotales[i].getUsuarioo().equals(carnet)) {
                    for (int j = i; j < Auten.ContadorDeCuentas - 1; j++) {
                        Auten.CuentasTotales[j] = Auten.CuentasTotales[j + 1];
                    }
                    Auten.ContadorDeCuentas--;
                    Auten.ActualizarCuentastx();
                    break;
                }
            }
            listarTodos();
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        listarTodos();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
