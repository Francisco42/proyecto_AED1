/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Representa la entidad Tag.
 * 
 * @author usuario
 */
public class Tag {
    private final String tag;
    private Lista<Libro> librosTagged;

    public Tag(String tag) {
        this.tag = tag;
        this.librosTagged = new Lista<>();
    }

    /**
     * Retorna el tag.
     * 
     * @return - Tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Retorna la lista de libros que llevan este tag.
     * 
     * @return - La lista de libros.
     */
    public Lista<Libro> getLibrosTagged() {
        return librosTagged;
    }
    
    /**
     * Inserta un libro en la lista de libros que llevan este tag.
     * 
     * @param id - El id del libro a insertar.
     * @param libro - El libro a insertar.
     */
    public void insertarLibro(int id, Libro libro) {
        librosTagged.insertar(new Nodo<>(id, libro));
    }
    
    @Override
    public String toString() {
        return tag;
    }
}
