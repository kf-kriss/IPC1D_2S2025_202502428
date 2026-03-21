/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ModuloGestionDeLibross;

import Logica.Bitacora;
import Modelos.Libros;
import Logica.ModuloDeAutenticacion;
import Logica.ModuloGestionDeLibros;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import IntefazOperador.MenuOperador;

public class ModuloDeGestionDeLibrosss extends javax.swing.JFrame {
    

    Logica.ModuloGestionDeLibros logica = new ModuloGestionDeLibros();
    ModuloDeAutenticacion Auten;
    DefaultTableModel modelo;
    private String usuarioActual;
    

    public ModuloDeGestionDeLibrosss(ModuloDeAutenticacion Auten, String usuarioActual) {
        
        
        initComponents();
        
        this.Auten = Auten;
        this.usuarioActual = usuarioActual;
        
        this.setLocationRelativeTo(null);
        refrescarTabla();
    }

    
    private void refrescarTabla() {
        String[] cabecera = {"Codigo", "ISBN", "Titulo", "Autor", "Genero", "Anio", "Disp"};
        modelo = new DefaultTableModel(null, cabecera);
        
        Libros[] lista = logica.FiltrarLibros(this.Auten, "", -1);
        
        for (Libros l : lista) {
            Object[] dato = {l.Codigo(), l.ISBN(), l.Titulo(), l.Autor(), l.Genero(), l.AñoDePublicacion(), l.Disponible()};
            modelo.addRow(dato);
        }
        tablaLibros.setModel(modelo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNuevo.setText("Nuevo +");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        txtBusqueda.addActionListener(this::txtBusquedaActionPerformed);

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaLibros);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnModificar)
                                        .addGap(70, 70, 70)
                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(5, 5, 5)
                .addComponent(btnRegresar)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            int cod = Integer.parseInt(JOptionPane.showInputDialog("Código:"));
            String is = JOptionPane.showInputDialog("ISBN:");
            String ti = JOptionPane.showInputDialog("Título:");
            String au = JOptionPane.showInputDialog("Autor:");
            String ge = JOptionPane.showInputDialog("Género:");
            int an = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
            int ej = Integer.parseInt(JOptionPane.showInputDialog("Ejemplares:"));

            int res = logica.RegistroDeLibroG(this.Auten, cod, is, ti, au, ge, an, ej);
            if(res == 0) {
                Bitacora.registrar("REGISTRO_DE_LIBRO", usuarioActual, "GESTION_DE_LIBROS");
                refrescarTabla();
            }
            else JOptionPane.showMessageDialog(null, "Error: Código/ISBN duplicado o cupo lleno.");
        } catch(Exception e) { JOptionPane.showMessageDialog(null, "Error en los datos."); }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tablaLibros.getSelectedRow();
        
        if (fila != -1) {
            String cod = tablaLibros.getValueAt(fila, 0).toString();
            int res = logica.EliminarLibroG(this.Auten, cod);
            
            if (res == 0) {
                Bitacora.registrar("ELIMINAR_LIBRO", usuarioActual, "GESTION_DE_LIBROS");
                refrescarTabla();
            }
            else if (res > 0) JOptionPane.showMessageDialog(null, "No se puede eliminar: tiene " + res + " préstamos.");
            else JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int fila = tablaLibros.getSelectedRow();
        
        if (fila != -1) {
            String cod = tablaLibros.getValueAt(fila, 0).toString();
            int indice = logica.BuscarLibroG(this.Auten, cod);
            
            String is = JOptionPane.showInputDialog("Nuevo ISBN:", tablaLibros.getValueAt(fila, 1));
            String ti = JOptionPane.showInputDialog("Nuevo Título:", tablaLibros.getValueAt(fila, 2));
            String au = JOptionPane.showInputDialog("Nuevo Autor:", tablaLibros.getValueAt(fila, 3));
            String ge = JOptionPane.showInputDialog("Nuevo Género:", tablaLibros.getValueAt(fila, 4));
            int an = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Año:", tablaLibros.getValueAt(fila, 5)));
            int ej = Integer.parseInt(JOptionPane.showInputDialog("Nueva Cantidad:"));

            boolean ok = logica.ModificarLibroG(this.Auten, indice, is, ti, au, ge, an, ej);
            if(ok) {
                Bitacora.registrar("MODIFICACION_DE_LIBRO", usuarioActual, "GESTION_DE_LIBROS");
                refrescarTabla();
            }
            else JOptionPane.showMessageDialog(null, "Error: No puede haber menos ejemplares que los prestados.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
    String texto = txtBusqueda.getText().trim();
    
    if (texto.isEmpty()) {
        refrescarTabla();
        return;
    }
    
    Modelos.Libros[] resultados = logica.FiltrarLibros(Auten, texto, 1);
    
    String[] cabecera = {"Codigo", "ISBN", "Titulo", "Autor", "Genero", "Anio", "Disp"};
    modelo = new DefaultTableModel(null, cabecera);
    
    for (Modelos.Libros l : resultados) {
        Object[] dato = {l.Codigo(), l.ISBN(), l.Titulo(), l.Autor(), 
                        l.Genero(), l.AñoDePublicacion(), l.Disponible()};
        modelo.addRow(dato);
    }
    tablaLibros.setModel(modelo);
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuOperador Regresar = new MenuOperador(Auten, usuarioActual);
        
        Regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
