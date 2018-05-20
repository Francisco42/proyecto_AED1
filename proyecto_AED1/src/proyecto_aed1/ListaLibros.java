/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 *
 * @author usuario
 */
public class ListaLibros extends Lista<Libro> {

    public ListaLibros() {
    }

    public ListaLibros(Nodo<Libro> unNodo) {
        super(unNodo);
    }
    
    /**
     * Busca todos los libros publicados a partir de cierto año.
     * 
     * @param año - El año de criterio.
     * @return La lista de libros que cumplen con el criterio.
     */
    public ListaLibros mostrarUltimasEdiciones(int año) {
        ListaLibros listaAux = new ListaLibros();
        Nodo<Libro> aux = primero;
        while (aux != null) {
            if (aux.getDato().getAño() >= año) {
                listaAux.insertar(aux.clonar());
            }
            aux = aux.getSiguiente();
        }
        return listaAux;
    }
    
    /**
     * Busca todos los libros que tienen un titulo dado.
     * 
     * @param titulo - El titulo que se busca.
     * @return La lista de libros que cumplen con el criterio.
     */
    public ListaLibros mostrarPorTitulo(String titulo) {
        ListaLibros listaAux = new ListaLibros();
        Nodo<Libro> aux = primero;
        while (aux != null) {
            if (aux.getDato().getTitulo().equals(titulo)) {
                listaAux.insertar(aux.clonar());
            }
            aux = aux.getSiguiente();
        }
        return listaAux;
    }
    
    /**
     * Busca todos los libros que fueron publicados en un 
     * cierto año.
     * 
     * @param año - El año que se busca.
     * @return La lista de libros que cumplen con el criterio.
     */
    public ListaLibros mostrarPorAño(int año) {
        ListaLibros listaAux = new ListaLibros();
        Nodo<Libro> aux = primero;
        while (aux != null) {
            if (aux.getDato().getAño() == año) {
                listaAux.insertar(aux.clonar());
            }
            aux = aux.getSiguiente();
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
        Nodo<Libro> aux = primero;
        while (aux != null) {
            if (aux.getDato().getISBN() == isbn) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    /**
     * Busca toda la informacion de un libro, incluyendo sus autores y tags.
     * 
     * @param isbn - El ISBN13 del libro que se busca.
     */
    public void mostrarDetalles(long isbn) {
        Nodo<Libro> aux = primero;
        while (aux != null) {
            if (aux.getDato().getISBN() == isbn) {
                aux.imprimir();
                System.out.println("");
                System.out.println("Autores: ");
                aux.getDato().getAutores().imprimirDatos();
                System.out.println("");
                System.out.println("Tags: ");
                aux.getDato().getTags().imprimirDatos();
            }
            aux = aux.getSiguiente();
        }
    }
}
