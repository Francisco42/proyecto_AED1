/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import java.util.LinkedList;

/**
 * Extiende el TDALista, con el tipo Libro.
 * 
 * @author usuario
 */
public class ArbolLibros extends TArbolBB<Libro> {

    public ArbolLibros() {
    }
    
    /**
     * Busca todos los libros publicados a partir de cierto año.
     * 
     * @param año - El año de criterio.
     * @return La lista de libros que cumplen con el criterio.
     */
    public LinkedList<Libro> mostrarUltimasEdiciones(int año) {
        LinkedList<Libro> listaAux = new LinkedList<>();
        for (Libro aux : inordenDatos()) {
            if (aux.getAño() >= año) {
                listaAux.add(aux);
            }
        }
        return listaAux;
    }
    
    /**
     * Busca el libros que tiene un titulo dado.
     * 
     * @param titulo - El titulo que se busca.
     * @return El libro que cumplen con el criterio.
     */
    public Libro mostrarPorTitulo(String titulo) {
        IElementoAB<Libro> aux = buscar(titulo);
        if (aux != null) {
            return aux.getDatos();
        } else {
            return null;
        }
    }
    
    /**
     * Busca todos los libros que fueron publicados en un 
     * cierto año.
     * 
     * @param año - El año que se busca.
     * @return La lista de libros que cumplen con el criterio.
     */
    public LinkedList<Libro> mostrarPorAño(int año) {
        LinkedList<Libro> listaAux = new LinkedList<>();
        for (Libro aux : inordenDatos()) {
            if (aux.getAño() == año) {
                listaAux.add(aux);
            }
        }
        return listaAux;
    }
    
    /**
     * Busca el libro que tiene el ISBN13 dado.
     * 
     * @param isbn - El ISBN13 que se busca.
     * @return El libro que cumple con el criterio.
     */
    public Libro mostrarPorISBN(long isbn) {
        for (Libro aux : inordenDatos()) {
            if (aux.getISBN() == isbn) {
                return aux;
            }
        }
        return null;
    }
    
    /**
     * Busca toda la informacion de un libro, incluyendo sus autores y tags.
     * 
     * @param titulo - El titulo del libro que se busca.
     */
    public void mostrarDetalles(String titulo) {
        IElementoAB<Libro> aux = buscar(titulo);
        if (aux != null) {
            aux.imprimirDato();
            System.out.println("");
            System.out.println("Autores: ");
            aux.getDatos().getAutores().imprimirDatos();
            System.out.println("");
            System.out.println("Tags: ");
            aux.getDatos().getTags().imprimirDatos();
        } else {
            System.out.println("No se encontró el libro");
        }
    }
}
