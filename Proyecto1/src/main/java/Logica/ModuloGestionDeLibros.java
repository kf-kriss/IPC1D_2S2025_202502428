/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;
import Modelos.Libros;

public class ModuloGestionDeLibros {
    
    Scanner S = new Scanner(System.in);
    
    //Cantidad
    private Libros[] CantidadDeLibros = new Libros[100];
    private int ContadorDeLibros = 0;
    
    
    
    
    
    // -------------------------------------------------------------------
    // SubModulo
    
    public void RegistroDeLibro(){
        if(ContadorDeLibros < 100){
            PedirDatosDeRegistroDeLibro();
            System.out.println("Libro Registrado con Exito");
        }else{
            System.out.println("Error:");
            System.out.println("  Ya no hay espacio para mas Libros ");
        }
    }
    
    public void PedirDatosDeRegistroDeLibro(){
        System.out.println(" -- INGRESE LOS DATOS DEL LIBRO --");
        
        System.out.println("Ingrese el Codigo:  ");
        int Cod = S.nextInt(); S.nextLine();
        
        System.out.println("Ingrese el ISBN:  ");
        String Is = S.nextLine();
        
        System.out.println("Ingrese el Titulo:  ");
        String Ti = S.nextLine();
        
        System.out.println("Ingrese el Autor:  ");
        String Au = S.nextLine();
        
        System.out.println("Ingrese el Genero:  ");
        String Gen = S.nextLine();
        
        System.out.println("Ingrese el Año de Publicacion:  ");
        int Año = S.nextInt(); S.nextLine();
        
        System.out.println("Ingrese el Cantidad de Ejemplares:  ");
        int Ejem = S.nextInt(); S.nextLine();
        
        Libros NuevoLibro = new Libros(Cod, Is, Ti, Au, Gen, Año, Ejem);
        
        CantidadDeLibros[ContadorDeLibros] = NuevoLibro;
        ContadorDeLibros++;
    }
    
    
    
    
    
    // -------------------------------------------------------------------
    // SubModulo 
    
    public void ModificacionDeLibro(){
        
        //Llamo al Buscador de Libro por Codigo o ISBN
        int Encontrado = BuscarLibro();
        
        if(Encontrado != -1){
            
            System.out.println("Modifica del Libro: " + CantidadDeLibros[Encontrado].Titulo());
            Libros LibroAEditar = CantidadDeLibros[Encontrado];
            
            NuevosDatosDelLibro(LibroAEditar);
            
        }     
    }
    
    public int BuscarLibro(){
        
        //Pedir el dato del libro
        System.out.println("Ingrese el Codigo o ISBN del Libro:  ");
        String DatoABuscar = S.nextLine();
        
        //por si no lo encuentra
        int IndiceEncontrado = -1;  
        
        for(int i=0; i<ContadorDeLibros; i++){
            Libros Actual = CantidadDeLibros[i];
            
            //Codigo int a String
            String CodString = String.valueOf(Actual.Codigo());
            
            //Comparar
            if (CodString.equals(DatoABuscar) || Actual.ISBN().equals(DatoABuscar)){
                IndiceEncontrado = i;
                System.out.println(" ¡Libro ENCONTRADO con Exito!");
                break;
            } 
        }
        
        if (IndiceEncontrado == -1){
            System.out.println("ERROR: ");
            System.out.println("  NO se encontro Ningun Libro ");
        }
        
        return IndiceEncontrado;
    }
    
    public void NuevosDatosDelLibro(Libros LibroAEditar){
        System.out.println("Ingrese los Nuevos Datos del Libro:");
        
        System.out.println("Nuevo ISBN:  ");
        LibroAEditar.setISBN(S.nextLine());
        
        System.out.println("Nuevo Titulo:  ");
        LibroAEditar.setTitulo(S.nextLine());
        
        System.out.println("Nuevo Autor:  ");
        LibroAEditar.setAutor(S.nextLine());
        
        System.out.println("Nuevo Genero:  ");
        LibroAEditar.setGenero(S.nextLine());
        
        System.out.println("Nuevo Año de Publicacion:  ");
        LibroAEditar.setAñoDePublicacion(S.nextInt());
        
        System.out.println("Nueva Cantidad Total de Ejemplares:  ");
        LibroAEditar.setTotalDeEjemplares(S.nextInt());
        
        S.nextLine();
        
        System.out.println("Datos ACTUALIZADOS con Exito");
    }
    
    
    
    
    
    
    
    // -------------------------------------------------------------------
    // SubModulo
    
    public void EliminarLibro(){
        int Encontrado = BuscarLibro();
        
        if(Encontrado != -1){
            
            System.out.println("Libro  " + CantidadDeLibros[Encontrado].Titulo());
            
            System.out.println(" Estas seguro que deseas ELIMINAR el libro? ");
            System.out.print("Si / No");
            String Confirmar = S.nextLine();
            
            if(Confirmar.equalsIgnoreCase("Si")){
                for(int i=Encontrado; i<ContadorDeLibros - 1; i++){
                    CantidadDeLibros[i] = CantidadDeLibros[i + 1];
                }
                
                CantidadDeLibros[ContadorDeLibros - 1] = null;
                ContadorDeLibros--;
                
                System.out.println("Libro ELIMINADO con Exito");
            }else{
                System.out.println("Eliminacion CANCELADA");
            }
        }
    }
    
    
    
    
    
    
    
    
    // -------------------------------------------------------------------
    // SubModulo
    
    public void BusquedaYListadoDeLibros(){
        System.out.println("Busqueda y Listado de Libros");
        System.out.println("1. Busqueda por ISBN");
        System.out.println("2. Busqueda por Titulo o Autor");
        System.out.println("3. Listar todos los Libros ");
        int Opcion = S.nextInt(); S.nextLine();
        
        switch(Opcion){
            case 1:
                BusquedaPorISBN();
                break;
            case 2:
                BusquedaPorTituloAutor();
                break;
            case 3:
                ListarTodosLosLibros();
                break;
            default:
                System.out.println("Opcion INVALIDA");
        }
    }
    
    public void BusquedaPorISBN(){
        System.out.println("Ingrese el ISBN");
        String isbnEncontrar = S.nextLine();
        int IndiceIsbn = -1;
        
        for(int i=0; i<ContadorDeLibros; i++){
            if(CantidadDeLibros[i].ISBN().equalsIgnoreCase(isbnEncontrar)){
                IndiceIsbn = i;
                ImprimirDatosPorISBN(IndiceIsbn);
            }
        }
        
        if(IndiceIsbn == -1){
            System.out.println("Libro NO encontrado");
        }
    }
    
    public void ImprimirDatosPorISBN(int IndiceIsbn){
        System.out.println(CantidadDeLibros[IndiceIsbn].Codigo());
        System.out.println(CantidadDeLibros[IndiceIsbn].Titulo());
        System.out.println(CantidadDeLibros[IndiceIsbn].Autor());
        System.out.println(CantidadDeLibros[IndiceIsbn].Genero());
        System.out.println(CantidadDeLibros[IndiceIsbn].AñoDePublicacion());
        System.out.println(CantidadDeLibros[IndiceIsbn].TotalDeEjemplares());
    }
    
    public void BusquedaPorTituloAutor(){
        System.out.println("Ingrese titulo o Autor: ");
        String TituloAutorEncontrar = S.nextLine().toLowerCase();
        int IndiceTituloAutor = -1;
        
        for(int i=0; i<ContadorDeLibros; i++){
            
            String Tit = CantidadDeLibros[i].Titulo().toLowerCase();
            String Aut = CantidadDeLibros[i].Autor().toLowerCase();
            
            if(Tit.contains(TituloAutorEncontrar) || Aut.contains(TituloAutorEncontrar)){
                IndiceTituloAutor = i;
                ImprimirDatosPorTituloAutor(IndiceTituloAutor);
            }
        }
        
        if(IndiceTituloAutor == -1){
            System.out.println("Libro NO encontrado");
        }
    }
    
    public void ImprimirDatosPorTituloAutor(int IndiceTituloAutor){
        System.out.println(CantidadDeLibros[IndiceTituloAutor].Codigo());
        System.out.println(CantidadDeLibros[IndiceTituloAutor].Titulo());
        System.out.println(CantidadDeLibros[IndiceTituloAutor].Autor());
        System.out.println(CantidadDeLibros[IndiceTituloAutor].Genero());
        System.out.println(CantidadDeLibros[IndiceTituloAutor].AñoDePublicacion());
        System.out.println(CantidadDeLibros[IndiceTituloAutor].TotalDeEjemplares());
    }
    
    public void ListarTodosLosLibros(){
        if(ContadorDeLibros == 0){
            System.out.println("La biblioteca. NO tiene Libros");
        }else{
            System.out.println("-- Listado de Libros --");
            for(int i=0; i<ContadorDeLibros; i++){
                System.out.println("Libro No." + (i+1) + " :");
                System.out.println(CantidadDeLibros[i].Codigo());
                System.out.println(CantidadDeLibros[i].Titulo());
                System.out.println(CantidadDeLibros[i].Autor());
                System.out.println(CantidadDeLibros[i].Genero());
                System.out.println(CantidadDeLibros[i].AñoDePublicacion());
                System.out.println(CantidadDeLibros[i].TotalDeEjemplares());
            }
        }
    }   
}
