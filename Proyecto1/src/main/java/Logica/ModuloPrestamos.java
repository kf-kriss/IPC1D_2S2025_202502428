/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelos.Prestamos;
import Modelos.Libros;
import Modelos.Usuarios;
import java.time.LocalDate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class ModuloPrestamos {
    
    private String validarReglas(ModuloDeAutenticacion Auten, String carnet, String isbn) {
        
        ModuloGestionDeLibros mLibros = new ModuloGestionDeLibros();
        int idxLibro = mLibros.BuscarLibroG(Auten, isbn);
        
        if (idxLibro == -1) {
            return "ERROR: El libro con ISBN " + isbn + " no existe.";
        }

        Libros lib = Auten.LibrosTotales[idxLibro];

        if (lib.Disponible() <= 0) {
            return "ERROR: El libro '" + lib.Titulo() + "' no tiene ejemplares disponibles.";
        }
        
        
        int prestamosActivos = 0;
        boolean tieneVencidos = false;
        LocalDate hoy = LocalDate.now();

        for (int i = 0; i < Auten.ContadorPrestamos; i++) {
            Prestamos p = Auten.PrestamosTotales[i];
            
            if (p.getCarnetEstudiante().equals(carnet) && p.getEstado().equals("ACTIVO")) {
                prestamosActivos++;
                
                if (p.getFechaLimite().isBefore(hoy)) {
                    tieneVencidos = true;
                }
            }
        }

        
        if (prestamosActivos >= 3) {
            return "RECHAZADO: El estudiante ya tiene 3 préstamos activos (Límite alcanzado).";
        }

        if (tieneVencidos) {
            return "RECHAZADO: El estudiante tiene préstamos VENCIDOS. Debe regularizar su situación.";
        }

        return "OK";
    }

    
    public String registrarPrestamoOperador(ModuloDeAutenticacion Auten, String carnet, String isbn) {
        String resultado = validarReglas(Auten, carnet, isbn);
        if (!resultado.equals("OK")) {
            return resultado;
        }

        return ejecutarRegistro(Auten, carnet, isbn);
    }


    public String solicitarPrestamoEstudiante(ModuloDeAutenticacion Auten, String carnetLogueado, String isbn) {
        String resultado = validarReglas(Auten, carnetLogueado, isbn);
        if (!resultado.equals("OK")) {
            return resultado;
        }

        return ejecutarRegistro(Auten, carnetLogueado, isbn);
    }

private String ejecutarRegistro(ModuloDeAutenticacion Auten, String carnet, String isbn) {
    String id = "PR-" + (Auten.ContadorPrestamos + 1);
    Prestamos nuevo = new Prestamos(id, carnet, isbn, LocalDate.now(), LocalDate.now().plusDays(15), null, "ACTIVO");

    Auten.PrestamosTotales[Auten.ContadorPrestamos] = nuevo;
    Auten.ContadorPrestamos++;

for (int i = 0; i < Auten.ContadorUsuariosR; i++) {
    if (Auten.UsuarioRegistrados[i].getUsuarioo().equals(carnet)) {
        Auten.UsuarioRegistrados[i].agregarAlHistorial(nuevo);
        break;
    }
}

    actualizarStockLibro(Auten, isbn, -1);
    guardarIndividualTxt(nuevo);
    
    return "EXITO: Código " + id;
}

    private void actualizarStockLibro(ModuloDeAutenticacion Auten, String isbn, int cambio) {
        ModuloGestionDeLibros mLibros = new ModuloGestionDeLibros();
        int idx = mLibros.BuscarLibroG(Auten, isbn);
        if (idx != -1) {
            Auten.LibrosTotales[idx].setDisponible(Auten.LibrosTotales[idx].Disponible() + cambio);
        }
    }

    public void guardarIndividualTxt(Prestamos p) {
        try (FileWriter fw = new FileWriter("prestamos.txt", true); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(p.getCodigoDePrestamo() + "," + p.getCarnetEstudiante() + "," + p.getIsbnLibro() + "," +
                       p.getFechaDePrestamo() + "," + p.getFechaLimite() + "," + p.getFechaDeDevolucion() + "," + p.getEstado());
        } catch (IOException e) { }
    }

    public void actualizarArchivoCompleto(ModuloDeAutenticacion Auten) {
        try (FileWriter fw = new FileWriter("prestamos.txt", false); PrintWriter pw = new PrintWriter(fw)) {
            for (int i = 0; i < Auten.ContadorPrestamos; i++) {
                Prestamos p = Auten.PrestamosTotales[i];
                pw.println(p.getCodigoDePrestamo() + "," + p.getCarnetEstudiante() + "," + p.getIsbnLibro() + "," +
                           p.getFechaDePrestamo() + "," + p.getFechaLimite() + "," + p.getFechaDeDevolucion() + "," + p.getEstado());
            }
        } catch (IOException e) { }
    }
}

