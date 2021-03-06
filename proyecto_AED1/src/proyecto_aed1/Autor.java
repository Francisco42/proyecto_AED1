/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Representa la entidad Autor
 * 
 * @author Francisco
 */
public class Autor {
    private final int id;
    private final String nombre;
    private Lista<Libro> librosEscritos;

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosEscritos = new Lista<>();
    }

    /**
     * Retorna el ID del autor.
     * 
     * @return El ID del autor.
     */
    public int getID() {
        return id;
    }

    /**
     * Retorna el nombre completo del autor.
     * 
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la lista de libros escritos por este autor.
     * 
     * @return La lista de libros.
     */
    public Lista<Libro> getLibrosEscritos() {
        return librosEscritos;
    }
    
    /**
     * Inserta un libro en la lista de libros escritos por este autor.
     * 
     * @param libro El libro insertar.
     */
    public void insertarLibro(Libro libro) {
        librosEscritos.insertar(new Nodo<>(libro.getTitulo(), libro));
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
