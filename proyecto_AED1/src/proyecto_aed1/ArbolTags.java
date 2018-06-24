/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import java.util.LinkedList;

/**
 * Extiende el TArbolBB, con el tipo Tag.
 * 
 * @author Francisco
 */
public class ArbolTags extends TArbolBB<Tag> {

    public ArbolTags() {
    }
    
    /**
     * Busca todos los libros que llevan un cierto tag.
     * 
     * @param tag El tag que se busca.
     * @return Los libros que llevan ese tag.
     */
    public Lista<Libro> mostrarPorTag(String tag) {
        IElementoAB<Tag> aux = buscar(tag);
        if (aux != null) {
            return aux.getDatos().getLibrosTagged();
        } else {
            return null;
        }
    }
    
    /**
     * Busca todos los libros que llevan unos ciertos tags.
     * 
     * @param tags Los tags que se buscan.
     * @return Los libros que llevan esos tags.
     */
    public Lista<Libro> mostrarPorListaTags(String[] tags) {
        String primerTag = tags[0];
        IElementoAB<Tag> aux = buscar(primerTag);
        if (aux != null) {
            Lista<Libro> resultado = new Lista<>();
            Lista<Libro> libros = aux.getDatos().getLibrosTagged();
            Nodo<Libro> auxLibro = libros.getPrimero();
            while (auxLibro != null) {
                boolean seInserta = true;
                for (String tag : tags) {
                    if (auxLibro.getDato().getTags().buscar(tag) == null) {
                        seInserta = false;
                    }
                }
                if (seInserta) {
                    resultado.insertar(auxLibro.clonar());
                }
                auxLibro = auxLibro.getSiguiente();
            }
            return resultado;
        } else {
            return null;
        }
    }
}
