/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Francisco
 */
public class Proyecto_AED1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here  
//        String h = "asd|sder||wrg";
//        String[] hs = h.split("\\|");
//        for (String s : hs) {
//            System.out.println(s);
//        }
//        //hs.removeAll(Arrays.asList("\\|", null));
//        
//        for (String s : hs) {
//            System.out.println(s);
//        }
        Biblioteca biblioteca = new Biblioteca();
        CargadorArchivosBiblioteca cargador = new CargadorArchivosBiblioteca();
        
        System.out.println("Cargando archivo \"Libros\" (1/5)...");
        cargador.cargarLibros(biblioteca);
        System.out.println("Archivo \"Libros\" cargado exitosamente!");
        System.out.println("");
        
        System.out.println("Cargando archivo \"Autores\" (2/5)...");
        cargador.cargarAutores(biblioteca);
        System.out.println("Archivo \"Autores\" cargado exitosamente!");
        System.out.println("");
        
        System.out.println("Cargando archivo \"Tags\" (3/5)...");
        cargador.cargarTags(biblioteca);
        System.out.println("Archivo \"Tags\" cargado exitosamente!");
        System.out.println("");
        
        System.out.println("Cargando archivo \"LibrosAutores\" (4/5)...");
        cargador.asociarLibrosAutores(biblioteca);
        System.out.println("Archivo \"LibrosAutores\" cargado exitosamente!");
        System.out.println("");
        
        System.out.println("Cargando archivo \"LibrosTags\" (5/5)...");
        cargador.asociarLibrosTags(biblioteca);
        System.out.println("Archivo \"LibrosTags\" cargado exitosamente!");
        System.out.println("");
        
        String menu = "------------------------------------------------"
                + "\n"
                + "Menu Principal\n"
                + "Elija una opcion y presione enter\n"
                + "1 - Buscar un libro por titulo\n"
                + "2 - Buscar libros por año\n"
                + "3 - Buscar un libro por ISBN13\n"
                + "4 - Buscar libros por autor\n"
                + "5 - Buscar libros por tag\n"
                + "6 - Buscar las ultimas ediciones a partir de una año\n"
                + "7 - Mostrar los detalles de un libro en particular (a partir de su ISBN13)\n"
                + "8 - Eliminar un autor de la biblioteca y todos sus libros asociados\n"
                + "9 - Salir del programa\n";
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println(menu);
            String linea1 = buffer.readLine();
            String linea2;
            switch (linea1) {
                
                case "1":
                    System.out.println("Ingrese el titulo a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarPorTitulo(linea2);
                    break;
                    
                case "2":
                    System.out.println("Ingrese el año a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarPorAño(Integer.parseInt(linea2));
                    break;
                    
                case "3":
                    System.out.println("Ingrese el ISBN13 a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarPorISBN(Long.parseLong(linea2));
                    break;
                    
                case "4":
                    System.out.println("Ingrese el autor a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarPorAutor(linea2);
                    break;
                    
                case "5":
                    System.out.println("Ingrese el tag a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarPorTag(linea2);
                    break;
                    
                case "6":
                    System.out.println("Ingrese el año a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarUltimasEdiciones(Integer.parseInt(linea2));
                    break;
                    
                case "7":
                    System.out.println("Ingrese el ISBN13 del libro a buscar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.mostrarDetalles(Long.parseLong(linea2));
                    break;
                    
                case "8":
                    System.out.println("Ingrese el autor a eliminar");
                    linea2 = buffer.readLine();
                    System.out.println("");
                    biblioteca.eliminarAutor(linea2);
                    break;
                    
                case "9":
                    salir = true;
                    break;
                    
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
        }
    }  
}
