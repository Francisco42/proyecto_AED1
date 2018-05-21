/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Extiende el TDALista, con el tipo Tag.
 * 
 * @author Francisco
 */
public class ListaTags extends Lista<Tag> {

    public ListaTags() {
    }

    public ListaTags(Nodo<Tag> unNodo) {
        super(unNodo);
    }
    
    /**
     * Busca todos los libros que llevan un cierto tag.
     * 
     * @param tag - El tag que se busca.
     * @return - Los libros que llevan ese tag.
     */
    public Lista<Libro> mostrarPorTag(String tag) {
        Nodo<Tag> aux = primero;
        while (aux != null) {
            if (aux.getDato().getTag().equals(tag)) {
                aux.imprimir();
                return aux.getDato().getLibrosTagged();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
