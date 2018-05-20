/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 *
 * @author Francisco
 */
public class ListaAutores extends Lista<Autor> {

    public ListaAutores() {
    }

    public ListaAutores(Nodo<Autor> unNodo) {
        super(unNodo);
    }
    
    /**
     * Busca todos los libros que fueron escritos por un 
     * cierto autor
     * 
     * @param autor - El autor que se busca.
     * @return - Los libros escritos por ese autor.
     */
    public Lista<Libro> mostrarPorAutor(String autor) {
        Nodo<Autor> aux = primero;
        while (aux != null) {
            if (aux.getDato().getNombre().equals(autor)) {
                aux.imprimir();
                return aux.getDato().getLibrosEscritos();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
