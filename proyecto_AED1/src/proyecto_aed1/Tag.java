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
    private final int id;
    private final String tag;
    private Lista<Libro> librosTagged;

    public Tag(int id, String tag) {
        this.id = id;
        this.tag = tag;
        this.librosTagged = new Lista<>();
    }
    
    public int getID() {
        return id;
    }

    /**
     * Retorna el tag.
     * 
     * @return Tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Retorna la lista de libros que llevan este tag.
     * 
     * @return La lista de libros.
     */
    public Lista<Libro> getLibrosTagged() {
        return librosTagged;
    }
    
    /**
     * Inserta un libro en la lista de libros que llevan este tag.
     * 
     * @param libro El libro a insertar.
     */
    public void insertarLibro(Libro libro) {
        librosTagged.insertar(new Nodo<>(libro.getTitulo(), libro));
    }
    
    @Override
    public String toString() {
        return tag;
    }
}
