/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelos.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GeneradorReportes {
    
    private ModuloDeAutenticacion Auten;
    
    public GeneradorReportes(ModuloDeAutenticacion Auten) {
        this.Auten = Auten;
    }
    
    
    public void prestamosVencidos() {
        String nombre = "Reporte_Prestamos_Vencidos_" + LocalDate.now() + ".html";
        LocalDate hoy = LocalDate.now();
        
        try (PrintWriter pw = new PrintWriter(nombre)) {
            pw.println("<html><body>");
            pw.println("<h1>Préstamos Vencidos</h1>");
            pw.println("<p>Fecha: " + LocalDate.now() + "</p>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>Código</th><th>Estudiante</th><th>Carnet</th><th>Libro</th><th>F.Límite</th><th>Días</th></tr>");
            
            for (int i = 0; i < Auten.ContadorPrestamos; i++) {
                Prestamos p = Auten.PrestamosTotales[i];
                
                if (p.getEstado().equals("ACTIVO") && p.getFechaLimite().isBefore(hoy)) {
                    
                    String nombreEst = "";
                    for (int j = 0; j < Auten.ContadorDeCuentas; j++) {
                        if (Auten.CuentasTotales[j].getUsuarioo().equals(p.getCarnetEstudiante())) {
                            nombreEst = Auten.CuentasTotales[j].getNombreCompleto();
                            break;
                        }
                    }
                    
                    String titulo = "";
                    for (int j = 0; j < Auten.ContadorLibros; j++) {
                        if (Auten.LibrosTotales[j].ISBN().equals(p.getIsbnLibro())) {
                            titulo = Auten.LibrosTotales[j].Titulo();
                            break;
                        }
                    }
                    
                    long dias = ChronoUnit.DAYS.between(p.getFechaLimite(), hoy);
                    
                    pw.println("<tr>");
                    pw.println("<td>" + p.getCodigoDePrestamo() + "</td>");
                    pw.println("<td>" + nombreEst + "</td>");
                    pw.println("<td>" + p.getCarnetEstudiante() + "</td>");
                    pw.println("<td>" + titulo + "</td>");
                    pw.println("<td>" + p.getFechaLimite() + "</td>");
                    pw.println("<td>" + dias + "</td>");
                    pw.println("</tr>");
                }
            }
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {}
    }
    
    
    public void librosDisponibles() {
        String nombre = "Reporte_Libros_Disponibles_" + LocalDate.now() + ".html";
        
        try (PrintWriter pw = new PrintWriter(nombre)) {
            pw.println("<html><body>");
            pw.println("<h1>Libros Disponibles</h1>");
            pw.println("<p>Fecha: " + LocalDate.now() + "</p>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>Código</th><th>Título</th><th>Autor</th><th>Disponibles</th></tr>");
            
            for (int i = 0; i < Auten.ContadorLibros; i++) {
                Libros l = Auten.LibrosTotales[i];
                if (l.Disponible() > 0) {
                    pw.println("<tr>");
                    pw.println("<td>" + l.Codigo() + "</td>");
                    pw.println("<td>" + l.Titulo() + "</td>");
                    pw.println("<td>" + l.Autor() + "</td>");
                    pw.println("<td>" + l.Disponible() + "</td>");
                    pw.println("</tr>");
                }
            }
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {}
    }
    
    
    public void top5Libros() {
        
        String nombre = "Reporte_Top5_Libros_" + LocalDate.now() + ".html";
        
        String[] isbnLibros = new String[100];
        int[] conteo = new int[100];
        String[] titulos = new String[100];
        int contador = 0;
        
        for (int i = 0; i < Auten.ContadorPrestamos; i++) {
            Prestamos p = Auten.PrestamosTotales[i];
            String isbn = p.getIsbnLibro();
            
            int pos = -1;
            for (int j = 0; j < contador; j++) {
                if (isbnLibros[j].equals(isbn)) {
                    pos = j;
                    break;
                }
            }
            
            if (pos == -1) {
                isbnLibros[contador] = isbn;
                conteo[contador] = 1;
                for (int j = 0; j < Auten.ContadorLibros; j++) {
                    if (Auten.LibrosTotales[j].ISBN().equals(isbn)) {
                        titulos[contador] = Auten.LibrosTotales[j].Titulo();
                        break;
                    }
                }
                contador++;
            } else {
                conteo[pos]++;
            }
        }
        
    
        for (int i = 0; i < contador - 1; i++) {
            for (int j = i + 1; j < contador; j++) {
                if (conteo[i] < conteo[j]) {
                    int tempConteo = conteo[i];
                    conteo[i] = conteo[j];
                    conteo[j] = tempConteo;
                    
                    String tempTitulo = titulos[i];
                    titulos[i] = titulos[j];
                    titulos[j] = tempTitulo;
                }
            }
        }
        
        try (PrintWriter pw = new PrintWriter(nombre)) {
            pw.println("<html><body>");
            pw.println("<h1>Top 5 Libros Más Prestados</h1>");
            pw.println("<p>Fecha: " + LocalDate.now() + "</p>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>#</th><th>Título</th><th>Préstamos</th></tr>");
            
            int max = Math.min(5, contador);
            for (int i = 0; i < max; i++) {
                pw.println("<tr>");
                pw.println("<td>" + (i + 1) + "</td>");
                pw.println("<td>" + titulos[i] + "</td>");
                pw.println("<td>" + conteo[i] + "</td>");
                pw.println("</tr>");
            }
            
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {}
    }
    

    public void estudiantesConPrestamos() {
        
        String nombre = "Reporte_Estudiantes_Prestamos_" + LocalDate.now() + ".html";
        LocalDate hoy = LocalDate.now();
        
        try (PrintWriter pw = new PrintWriter(nombre)) {
            pw.println("<html><body>");
            pw.println("<h1>Estudiantes con Préstamos Activos</h1>");
            pw.println("<p>Fecha: " + LocalDate.now() + "</p>");
            pw.println("<table border='1'>");
            pw.println("<tr><th>Carnet</th><th>Nombre</th><th>Préstamos Activos</th><th>Tiene Vencidos</th></tr>");
            
            for (int i = 0; i < Auten.ContadorDeCuentas; i++) {
                Usuarios u = Auten.CuentasTotales[i];
                if (!u.getRol().equalsIgnoreCase("Estudiante")) continue;
                
                int activos = 0;
                boolean tieneVencidos = false;
                
                for (int j = 0; j < Auten.ContadorPrestamos; j++) {
                    Prestamos p = Auten.PrestamosTotales[j];
                    if (p.getCarnetEstudiante().equals(u.getUsuarioo()) && p.getEstado().equals("ACTIVO")) {
                        activos++;
                        if (p.getFechaLimite().isBefore(hoy)) {
                            tieneVencidos = true;
                        }
                    }
                }
                
                if (activos > 0) {
                    pw.println("<tr>");
                    pw.println("<td>" + u.getUsuarioo() + "</td>");
                    pw.println("<td>" + u.getNombreCompleto() + "</td>");
                    pw.println("<td>" + activos + "</td>");
                    pw.println("<td>" + (tieneVencidos ? "Sí" : "No") + "</td>");
                    pw.println("</tr>");
                }
            }
            
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {}
    }
}
