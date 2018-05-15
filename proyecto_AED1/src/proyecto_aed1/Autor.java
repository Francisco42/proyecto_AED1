/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Representa la entidad Autor
 * 
 * @author usuario
 */
public class Autor {
    private final String nombre;
    private Lista<Libro> librosEscritos;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.librosEscritos = new Lista<>();
    }

    /**
     * Retorna el nombre completo del autor.
     * 
     * @return - El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la lista de libros escritos por este autor.
     * 
     * @return - La lista de libros.
     */
    public Lista<Libro> getLibrosEscritos() {
        return librosEscritos;
    }
    
    /**
     * Inserta un libro en la lista de libros escritos por este autor.
     * 
     * @param id - El id del libro a insertar.
     * @param libro - El libro insertar.
     */
    public void insertarLibro(int id, Libro libro) {
        librosEscritos.insertar(new Nodo<>(id, libro));
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
