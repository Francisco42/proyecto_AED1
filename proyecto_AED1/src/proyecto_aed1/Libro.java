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
    private final String nombre;
    private final String autor;
    private final long isbn;
    private final short año;
    private final String genero;
    private Libro siguiente;

    public Libro(String nombre, String autor, long isbn, short año, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.año = año;
        this.genero = genero;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public long getISBN() {
        return isbn;
    }

    public short getAño() {
        return año;
    }

    public String getGenero() {
        return genero;
    }

    public Libro getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Libro siguiente) {
        this.siguiente = siguiente;
    } 
}
