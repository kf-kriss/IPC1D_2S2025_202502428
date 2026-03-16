/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


import Modelos.Usuarios;
import Logica.ModuloDeAutenticacion;


public class ModuloDeAdministrador {

    
    public boolean EliminacionDeOperador(ModuloDeAutenticacion Auten, String ElimUsu){
        int IndiceEcontrado = -1;
        
        for(int i=0; i<Auten.ContadorDeCuentas; i++){
            if(Auten.CuentasTotales[i].getUsuarioo().equals(ElimUsu) && Auten.CuentasTotales[i].getRol().equalsIgnoreCase("Operador")){
                IndiceEcontrado = i;
                break;
            }
        }
        
        if(IndiceEcontrado != -1){
            for(int j=IndiceEcontrado; j<Auten.ContadorDeCuentas - 1; j++){
                Auten.CuentasTotales[j] = Auten.CuentasTotales[j + 1];
            }
            
            Auten.ContadorDeCuentas--;
            Auten.ActualizarCuentastx();
            return true;
        }
        return false;
    }
    
}
