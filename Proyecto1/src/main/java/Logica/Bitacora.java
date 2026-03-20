/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Bitacora {
    
    private static final String ARCHIVO = "bitacora.txt";
    
    public static void registrar(String operacion, String usuario, String modulo) {
        try (FileWriter fw = new FileWriter(ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();
            
            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yy");
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("hh:mm a");
            
            String linea = "[" + operacion + "][" + usuario + "][" + modulo + "][" + 
                          fecha.format(formatterFecha) + "][" + 
                          hora.format(formatterHora) + "]";
            
            pw.println(linea);
            
        } catch (Exception e) {
            // Si falla, que no detenga el programa
        }
    }
}
