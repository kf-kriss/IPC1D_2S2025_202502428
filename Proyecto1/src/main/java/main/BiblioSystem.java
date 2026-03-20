/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Logica.ModuloDeAutenticacion;

public class BiblioSystem {

    public static void main(String[] args) {
        
        ModuloDeAutenticacion Atenticacion = new ModuloDeAutenticacion();
        
        Atenticacion.CargarCuentasDesdeCuentastx();
        Atenticacion.cargarPrestamos();
        
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz.InterMenuInicial(Atenticacion).setVisible(true);
        });
        
    }
}
