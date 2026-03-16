/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;

public class Prestamos {
    private String CodigoDePrestamo;
    private String CarnetEstudiante;
    private String IsbnLibro;
    private LocalDate FechaDePrestamo;
    private LocalDate FechaLimite;
    private LocalDate FechaDeDevolucion;
    private String Estado;

    public Prestamos(String CodigoDePrestamo, String CarnetEstudiante, String IsbnLibro, LocalDate FechaDePrestamo, LocalDate FechaLimite, LocalDate FechaDeDevolucion, String Estado) {
        this.CodigoDePrestamo = CodigoDePrestamo;
        this.CarnetEstudiante = CarnetEstudiante;
        this.IsbnLibro = IsbnLibro;
        this.FechaDePrestamo = FechaDePrestamo;
        this.FechaLimite = FechaLimite;
        this.FechaDeDevolucion = FechaDeDevolucion;
        this.Estado = Estado;
    }

    public String getCodigoDePrestamo() {return CodigoDePrestamo;}
    public String getCarnetEstudiante() {return CarnetEstudiante;}
    public String getIsbnLibro() {return IsbnLibro;}
    public LocalDate getFechaDePrestamo() {return FechaDePrestamo;}
    public LocalDate getFechaLimite() {return FechaLimite;}
    public LocalDate getFechaDeDevolucion() {return FechaDeDevolucion;}
    public String getEstado() {return Estado;}

    public void setCodigoDePrestamo(String CodigoDePrestamo) {this.CodigoDePrestamo = CodigoDePrestamo;}
    public void setCarnetEstudiante(String CarnetEstudiante) {this.CarnetEstudiante = CarnetEstudiante;}
    public void setIsbnLibro(String IsbnLibro) {this.IsbnLibro = IsbnLibro;}
    public void setFechaDePrestamo(LocalDate FechaDePrestamo) {this.FechaDePrestamo = FechaDePrestamo;}
    public void setFechaLimite(LocalDate FechaLimite) {this.FechaLimite = FechaLimite;}
    public void setFechaDeDevolucion(LocalDate FechaDeDevolucion) {this.FechaDeDevolucion = FechaDeDevolucion;}
    public void setEstado(String Estado) {this.Estado = Estado;}
    
    public String toString(){
        return  CodigoDePrestamo + ", " +
                CarnetEstudiante + ", " +
                IsbnLibro + ", " + 
                FechaDePrestamo + ", " + 
                FechaLimite + ", " +
                FechaDeDevolucion + ", " + 
                Estado;
    }
}
