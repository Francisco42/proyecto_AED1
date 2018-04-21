/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Implementa el TDA Lista con el tipo especifico Libro.
 * 
 * @author Francisco
 */
public class ListaLibros extends Lista<Libro> {

    public ListaLibros() {
    }

    public ListaLibros(INodo<Libro> unNodo) {
        super(unNodo);
    }
    
    /**
     * Busca todos los libros que tienen un cierto nombre. 
     * 
     * @param nombre - El nombre que se va a buscar.
     * @return Lista con los libros que cumplen el criterio
     */
    public ListaLibros buscarPorNombre(String nombre) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getNombre().equals(nombre)) {
                    listaAux.insertar(aux.clonar());
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * Busca todos los libros escritos por un cierto autor. 
     * 
     * @param autor - El autor que se va a buscar.
     * @return Lista con los libros que cumplen el criterio
     */
    public ListaLibros buscarPorAutor(String autor) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAutor().equals(autor)) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * Busca todos los libros de un cierto género. 
     * 
     * @param genero - El género que se va a buscar.
     * @return Lista con los libros que cumplen el criterio
     */
    public ListaLibros buscarPorGenero(String genero) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getGenero().equals(genero)) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
//    /**
//     * 
//     * @param isbn
//     * @return 
//     */
//    public ListaLibros buscarPorISBN(long isbn) {
//        ListaLibros listaAux = new ListaLibros();
//        if (!esVacia()) {
//            INodo<Libro> aux = primero;
//            while (aux != null) {
//                if (aux.getDato().getISBN() == isbn) {
//                    listaAux.insertar(aux);
//                }
//                aux = aux.getSiguiente();
//            }
//        }
//        return listaAux;
//    }
    
    /**
     * Busca todos los libros que se publicaron en un cierto año. 
     * 
     * @param año - El año que se va a buscar.
     * @return Lista con los libros que cumplen el criterio
     */
    public ListaLibros buscarPorAño(int año) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAño() == año) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * Busca todos los libros que se publicaron a partir de un cierto año. 
     * 
     * @param año - El año a partir del cual se va a buscar.
     * @return Lista con los libros que cumplen el criterio
     */
    public ListaLibros buscarAPartirDel(int año) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAño() >= año) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }    
}
