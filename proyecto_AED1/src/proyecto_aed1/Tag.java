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
public class Tag {
    private final String tag;
    private Lista<Libro> librosTagged;

    public Tag(String tag) {
        this.tag = tag;
        this.librosTagged = new Lista<>();
    }

    public String getTag() {
        return tag;
    }

    public Lista<Libro> getLibrosTagged() {
        return librosTagged;
    }
    
    public void insertarLibro(Libro libro) {
        librosTagged.insertar(new Nodo<>(libro.getISBN(), libro));
    }
}
