/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelos.Libros;

public class ModuloGestionDeLibros {
    

    public int RegistroDeLibroG(ModuloDeAutenticacion Auten, int Cod, String Is, String Ti, String Au, String Gen, int Año, int Ejem) {

        if (Auten.ContadorLibros >= 100) {
            return -2; 
        }

        for (int i = 0; i < Auten.ContadorLibros; i++) {
            if (Auten.LibrosTotales[i].Codigo() == Cod || Auten.LibrosTotales[i].ISBN().equals(Is)) {
                return -1; 
            }
        }

        Libros NuevoLibro = new Libros(Cod, Is, Ti, Au, Gen, Año, Ejem);
        Auten.LibrosTotales[Auten.ContadorLibros] = NuevoLibro;
        Auten.ContadorLibros++;
        return 0; 
    }

    
    public int BuscarLibroG(ModuloDeAutenticacion Auten, String DatoABuscar) {
        for (int i = 0; i < Auten.ContadorLibros; i++) {
            Libros Actual = Auten.LibrosTotales[i];
            if (String.valueOf(Actual.Codigo()).equals(DatoABuscar) || Actual.ISBN().equals(DatoABuscar)) {
                return i; 
            }
        }
        return -1; 
    }

    
    public boolean ModificarLibroG(ModuloDeAutenticacion Auten, int indice, String Is, String Ti, String Au, String Gen, int Año, int Ejem) {
        Libros lib = Auten.LibrosTotales[indice];

        int prestados = lib.TotalDeEjemplares() - lib.Disponible();
        if (Ejem < prestados) {
            return false; 
        }

        lib.setISBN(Is);
        lib.setTitulo(Ti);
        lib.setAutor(Au);
        lib.setGenero(Gen);
        lib.setAñoDePublicacion(Año);
        lib.setTotalDeEjemplares(Ejem);
        
        lib.setDisponible(Ejem - prestados);
        
        return true;
    }

    
    public int EliminarLibroG(ModuloDeAutenticacion Auten, String DatoABuscar) {
        int encontrado = BuscarLibroG(Auten, DatoABuscar);

        if (encontrado != -1) {
            Libros lib = Auten.LibrosTotales[encontrado];
            
            //Si tiene prestamo
            if (lib.Disponible() != lib.TotalDeEjemplares()) {
                return lib.TotalDeEjemplares() - lib.Disponible();
            }

            for (int i = encontrado; i < Auten.ContadorLibros - 1; i++) {
                Auten.LibrosTotales[i] = Auten.LibrosTotales[i + 1];
            }
            Auten.LibrosTotales[Auten.ContadorLibros - 1] = null;
            Auten.ContadorLibros--;
            return 0; 
        }
        
        return -1;
    }

    
    public Libros[] FiltrarLibros(ModuloDeAutenticacion Auten, String filtro, int tipo) {
        Libros[] temporal = new Libros[Auten.ContadorLibros];
        int cont = 0;

        for (int i = 0; i < Auten.ContadorLibros; i++) {
            Libros l = Auten.LibrosTotales[i];
            boolean match = false;

            if (tipo == 0) {
                match = l.ISBN().equals(filtro);
            }
            else if (tipo == 1) {
                match = l.Titulo().toLowerCase().contains(filtro.toLowerCase());
            } 
            else if (tipo == 2) {
                match = l.Autor().toLowerCase().contains(filtro.toLowerCase());
            } 
            else {
                match = true;
            }

            if (match) {
                temporal[cont] = l;
                cont++;
            }
        }

        Libros[] resultado = new Libros[cont];
        for (int j = 0; j < cont; j++) resultado[j] = temporal[j];
        return resultado;
    }
}
