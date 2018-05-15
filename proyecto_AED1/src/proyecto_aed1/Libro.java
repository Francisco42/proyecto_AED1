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
public class Libro {
    private final String titulo;
    private final long isbn;
    private final short año;
    private final float puntaje;
    private final int cantidadPuntajes;
    private Lista<Tag> tags;
    private Lista<Autor> autores;

    public Libro(String titulo, long isbn, short año, float puntaje, int cantidadPuntajes) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.año = año;
        this.puntaje = puntaje;
        this.cantidadPuntajes = cantidadPuntajes;
        this.tags = new Lista<>();
        this.autores = new Lista<>();
    }
    
    /**
     * Retorna el nombre del libro.
     * 
     * @return Nombre del libro.
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Retorna el autor del libro.
     * 
     * @return Lista con los autores del libro.
     */
    public Lista<Autor> getAutores() {
        return autores;
    }

    /**
     * Retorna el ISBN del libro.
     * 
     * @return ISBN del libro.
     */
    public long getISBN() {
        return isbn;
    }

    /**
     * Retorna el año del libro.
     * 
     * @return Año del libro.
     */
    public int getAño() {
        return año;
    }

    /**
     * Retorna el género del libro.
     * 
     * @return Lista con los tags del libro.
     */
    public Lista<Tag> getTags() {
        return tags;
    }

    /**
     * Retorna el puntaje del libro
     * 
     * @return Puntaje del libro
     */
    public float getPuntaje() {
        return puntaje;
    }

    /**
     * Retorna la cantidad de puntuaciones del libro
     * 
     * @return Cantidad de puntucaiones
     */
    public int getCantidadPuntajes() {
        return cantidadPuntajes;
    }
    
    public void insertarAutor(int id, Autor autor) {
        autores.insertar(new Nodo<>(id, autor));
    }
    
    public void insertarTag(int id, Tag tag) {
        tags.insertar(new Nodo<>(id, tag));
    }
    
    @Override
    public String toString() {
        return "Libro: " + titulo + " Año: " + año + " ISBN: " + isbn;
    }
}
