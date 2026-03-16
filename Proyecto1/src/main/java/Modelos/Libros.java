/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

public class Libros {
    
    //Atributos
    private int Codigo;
    private String ISBN;
    private String Titulo;
    private String Autor;
    private String Genero;
    private int AñoDePublicacion;
    private int TotalDeEjemplares;
    
    //Constructor
    public Libros(int Codigo, String ISBN, String Titulo, String Autor, String Genero, int AñoDePublicacion, int TotalDeEjemplares){
        this.Codigo = Codigo;
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Genero = Genero;
        this.AñoDePublicacion = AñoDePublicacion;
        this.TotalDeEjemplares = TotalDeEjemplares;
    }
    
    //Getters (leer datos)
    public int Codigo() { return Codigo; }
    public String ISBN() { return ISBN; }
    public String Titulo() { return Titulo; } 
    public String Autor() { return Autor; }
    public String Genero() { return Genero; }
    public int AñoDePublicacion() { return AñoDePublicacion; }
    public int TotalDeEjemplares() { return TotalDeEjemplares; }
    
    //Setter (modificar datos)
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setTitulo(String Titulo) { this.Titulo = Titulo; }
    public void setAutor(String Autor) { this.Autor = Autor; }
    public void setGenero(String Genero) { this.Genero = Genero; }
    public void setAñoDePublicacion(int AñoDePublicacion) { this.AñoDePublicacion = AñoDePublicacion; }
    public void setTotalDeEjemplares(int TotalDeEjemplares) { this.TotalDeEjemplares = TotalDeEjemplares; }
    
}
