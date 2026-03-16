/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import Modelos.Usuarios;
import Logica.MenuDeRol;

public class ModuloDeAutenticacion {
    
    Scanner S = new Scanner(System.in);
    
    MenuDeRol MenuRol = new MenuDeRol();
    
    public Usuarios[] CuentasTotales = new Usuarios[100];
    public int ContadorDeCuentas = 0;
    private final String Cuentastx = "Cuentas.txt";
    
    
    
    
    public void CargarCuentasDesdeCuentastx(){
        File Archivo = new File(Cuentastx);
        if(!Archivo.exists()) {return;}
        
        try(BufferedReader br = new BufferedReader(new FileReader(Cuentastx))){
            String Linea;
            while((Linea = br.readLine()) != null){
                String[] Datos = Linea.split(", ");
                if(Datos.length == 5){
                    Usuarios u = new Usuarios(Datos[0], Datos[1], Datos[2], Datos[3], Datos[4]);
                    CuentasTotales[ContadorDeCuentas] = u;
                    ContadorDeCuentas++;
                }
            }
        }catch(IOException e){
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    //No sirve Creo
    public void MenuInicial(){
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Crear cuenta de Estudiante");
        System.out.println("3. Salir ");
        System.out.println("Seleccione una opcion: ");
        int Opcion = S.nextInt(); S.nextLine();
        
        switch(Opcion){
            case 1:
                IniciarSesion();
                break;
            case 2:
                CrearCuentaDeEstudiante();
                break;
            case 3:
                System.out.println("Pues no...");
                break;
            default:
                System.out.println("Pues no...");
        }
    }
    
   


    
    
    
    
    // ----------------------------------------------------
    
    
    //Borrar
    public void IniciarSesion(){
        
        boolean Acceder = false;
        
        while(!Acceder){
        System.out.println("INICIO DE SESION");
        
        System.out.println("Ingrese CARNET");
        String Entrada = S.nextLine();
        
        System.out.println("Ingrese CONTRASEÑA");
        String Contra = S.nextLine();
        
        //para Validar Admin
        if(Entrada.equalsIgnoreCase("admin") && Contra.equals("admin") ){
            System.out.println(" Bienvenido Admin");
            
            MenuRol.MenuAdmin();
            
            Acceder = true;
            break;
        }
        
        //para Validar Estudiantes u Operadores
        for(int i=0; i<ContadorDeCuentas; i++){
            if(CuentasTotales[i].getUsuarioo().equals(Entrada) && CuentasTotales[i].getContraseña().equals(Contra)){
                System.out.println("Bienvenido" + CuentasTotales[i].getNombreCompleto());
                
                String Rol = CuentasTotales[i].getRol();
                if(Rol.equalsIgnoreCase("Operador")){
                    System.out.println("Bienvenido Operador");
                    MenuRol.MenuOperador();
                    return;
                }else{
                    System.out.println("Bienvenido Estudiante");
                    MenuRol.MenuEstudiante();
                    return;
                }
            }
        }
        
        if(!Acceder){
            System.out.println("Error. Datos equivocados");
        }

        }
    }
    
    
    
    
    public String validarIngreso(String VeUsu, String VeContra) {
    
    //Admin
    if (VeUsu.equalsIgnoreCase("admin") && VeContra.equals("admin")) {
        return "ADMIN";
    }

    //Est u Op
    for (int i = 0; i < ContadorDeCuentas; i++) {
        if (CuentasTotales[i].getUsuarioo().equals(VeUsu) && 
            CuentasTotales[i].getContraseña().equals(VeContra)) {
            
            return CuentasTotales[i].getRol().toUpperCase();
        }
    }

    //Si no encuentra
    return "ERROR";
    }
    
    
    
    
    
    
    
    // ----------------------------------------------------
    
    public void CrearCuentaDeEstudiante() {
        System.out.println("CREAN CUENTA DE ESTUDIANTE");
        
        System.out.println("Ingres su Carnet: ");
        String ValidarCarnet = S.nextLine();
        
        for(int i=0; i<ContadorDeCuentas; i++){
            if(CuentasTotales[i].getUsuarioo().equals(ValidarCarnet)){
                System.out.println("ERROR el carnet ya está registrado");
                return;
            }
        }
        
        System.out.println("Nombre Completo");
        String Nom = S.nextLine();
        System.out.println("Carrera:  ");
        String Carr = S.nextLine();
        System.out.println("Contraseña:  ");
        String Contr = S.nextLine();
        
        Usuarios NuevoUsuario = new Usuarios("Estudiante", ValidarCarnet, Contr, Nom, Carr);
        CuentasTotales[ContadorDeCuentas] = NuevoUsuario;
        ContadorDeCuentas++;
        
        EscribirEnCuentastx(NuevoUsuario);
        
        System.out.println("Estudiante registrado con exito");
        
    }    
        
    
    public void EscribirEnCuentastx(Usuarios u){
        try(FileWriter fw = new FileWriter(Cuentastx, true);
        PrintWriter pw = new PrintWriter(fw)){
                
            pw.println(u.getRol()+ ", " + u.getUsuarioo()+ ", " + u.getContraseña() + ", " +u.getNombreCompleto() + ", "+ u.getCarrera());
        }catch (IOException e){
            System.out.println("Error al escribir en " + e.getMessage());
        }
    }

    public void ActualizarCuentastx(){
        try(FileWriter fw = new FileWriter(Cuentastx, false);
            PrintWriter pw = new PrintWriter(fw)){
            
            for(int i=0; i<ContadorDeCuentas; i++){
                Usuarios u = CuentasTotales[i];
                pw.println(u.getRol() + ", " + u.getUsuarioo() + ", " + u.getContraseña() + ", " + u.getNombreCompleto() + ", " + u.getCarrera() + ", ");
            }
        } catch (IOException e){
            System.out.println("ERROR al actualizar el archivo " + e.getMessage());
        }
    }
    
}

