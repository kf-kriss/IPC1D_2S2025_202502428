/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

public class Usuarios {
    
    private String Rol;
    private String Usuarioo;
    private String Contraseña;
    private String NombreCompleto;
    private String Carrera;
    
    public Usuarios(String Rol, String Usuarioo, String Contraseña, String NombreCompleto, String Carrera){
        this.Rol = Rol;
        this.Usuarioo = Usuarioo;
        this.Contraseña = Contraseña;
        this.NombreCompleto = NombreCompleto;
        this.Carrera = Carrera;
    }
    
    public String getRol() { return Rol; }
    public String getUsuarioo() { return Usuarioo; }
    public String getContraseña() { return Contraseña; }
    public String getNombreCompleto() { return NombreCompleto; }
    public String getCarrera() { return Carrera; }
    
    public void setRol(String Rol){ this.Rol = Rol; }
    public void setUsuarioo(String Usuarioo) {this.Usuarioo = Usuarioo;}
    public void setContraseña(String Contraseña) {this.Contraseña = Contraseña;}
    public void setNombreCompleto(String NombreCompleto) {this.NombreCompleto = NombreCompleto;}
    public void setCarrera(String Carrera) {this.Carrera = Carrera; }
    
    public String toString(){
        return Rol + ", " + Usuarioo + ", " + Contraseña + ", " + NombreCompleto + ", " + Carrera; 
    }
}
