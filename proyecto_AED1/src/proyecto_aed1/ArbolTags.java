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
public class ArbolTags extends TArbolBB<Tag> {

    public ArbolTags() {
    }
    
    /**
     * Busca todos los libros que llevan un cierto tag.
     * 
     * @param tag - El tag que se busca.
     * @return - Los libros que llevan ese tag.
     */
    public Lista<Libro> mostrarPorTag(String tag) {
        IElementoAB<Tag> aux = buscar(tag);
        if (aux != null) {
            return aux.getDatos().getLibrosTagged();
        } else {
            return null;
        }
    }
}
