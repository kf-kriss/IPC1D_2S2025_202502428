/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import Modelos.Prestamos;
import Modelos.Usuarios;
import Modelos.Libros;

import javax.swing.JOptionPane;

import java.time.LocalDate;


public class ModuloDeAutenticacion {
    
    public Modelos.Libros[] LibrosTotales = new Modelos.Libros[100];
    public int ContadorLibros = 0;
    
    public Prestamos[] PrestamosTotales = new Prestamos[1000]; 
    public int ContadorPrestamos = 0;
    
    public Usuarios[] UsuarioRegistrados = new Usuarios[100];
    public int ContadorUsuariosR = 0;
    
    public Usuarios[] CuentasTotales = new Usuarios[100];
    public int ContadorDeCuentas = 0;
    
    private final String Cuentastx = "cuentas.txt";
    
    public String usuarioActual;
    
    public void CargarCuentasDesdeCuentastx(){
        File Archivo = new File(Cuentastx);
        if(!Archivo.exists()) {return;}
        try(BufferedReader br = new BufferedReader(new FileReader(Cuentastx))){
            String Linea;
            while((Linea = br.readLine()) != null){
                String[] Datos = Linea.split(", ");
                if(Datos.length >= 5){
                    Usuarios u = new Usuarios(Datos[0], Datos[1], Datos[2], Datos[3], Datos[4]);
                    CuentasTotales[ContadorDeCuentas] = u;
                    ContadorDeCuentas++;
                }
            }
        }catch(IOException e){}
    }
    
    public String validarIngreso(String VeUsu, String VeContra) {

        if (VeUsu.equalsIgnoreCase("admin") && VeContra.equals("admin")) {
            return "ADMIN";
        }
        
        for (int i = 0; i < ContadorDeCuentas; i++) {
            if (CuentasTotales[i].getUsuarioo().equals(VeUsu) && 
                CuentasTotales[i].getContraseña().equals(VeContra)) {
                return CuentasTotales[i].getRol().toUpperCase();
            }
        }
        
        return "ERROR";
    }
    
    
    public void EscribirEnCuentastx(Usuarios u){
        try(FileWriter fw = new FileWriter(Cuentastx, true);
            PrintWriter pw = new PrintWriter(fw)){
            pw.println(u.getRol()+ ", " + u.getUsuarioo()+ ", " + u.getContraseña() + ", " + u.getNombreCompleto() + ", "+ u.getCarrera());
        }catch (IOException e){}
    }
    
    public void ActualizarCuentastx(){
        try(FileWriter fw = new FileWriter(Cuentastx, false);
            PrintWriter pw = new PrintWriter(fw)){
            for(int i=0; i<ContadorDeCuentas; i++){
                Usuarios u = CuentasTotales[i];
                pw.println(u.getRol() + ", " + u.getUsuarioo() + ", " + u.getContraseña() + ", " + u.getNombreCompleto() + ", " + u.getCarrera());
            }
        } catch (IOException e){}
    }
    

    public boolean registrarEstudianteGUI(String carnet, String nombre, String carrera, String contraseña) {
        
        for(int i=0; i<ContadorDeCuentas; i++){
            if(CuentasTotales[i].getUsuarioo().equals(carnet)){
                return false;
            }
        }
        
        Usuarios NuevoUsuario = new Usuarios("Estudiante", carnet, contraseña, nombre, carrera);
        CuentasTotales[ContadorDeCuentas] = NuevoUsuario;
        ContadorDeCuentas++;
        EscribirEnCuentastx(NuevoUsuario);
        
        return true;
    }
    
    public Usuarios buscarEstudiantePorCarnet(String carnet) {
        for(int i=0; i<ContadorDeCuentas; i++){
            if(CuentasTotales[i].getRol().equalsIgnoreCase("Estudiante") && 
               CuentasTotales[i].getUsuarioo().equals(carnet)){
                return CuentasTotales[i];
            }
        }
        return null;
    }

    public void cargarPrestamos() {
    File archivo = new File("prestamos.txt");
    if (!archivo.exists()) return;
    
    try (BufferedReader br = new BufferedReader(new FileReader("prestamos.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length >= 7) {
                LocalDate fechaPrestamo = LocalDate.parse(datos[3]);
                LocalDate fechaLimite = LocalDate.parse(datos[4]);
                LocalDate fechaDevolucion = datos[5].equals("null") ? null : LocalDate.parse(datos[5]);
                
                Prestamos p = new Prestamos(
                    datos[0], datos[1], datos[2],
                    fechaPrestamo, fechaLimite, fechaDevolucion,
                    datos[6]
                );
                
                PrestamosTotales[ContadorPrestamos] = p;
                ContadorPrestamos++;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}    
}

