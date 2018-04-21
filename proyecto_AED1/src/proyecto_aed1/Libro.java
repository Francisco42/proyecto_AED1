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
    private int ventas;

    public Libro(String nombre, String autor, long isbn, short año, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.año = año;
        this.genero = genero;
        this.ventas = 0;
    }
    
    /**
     * Retorna el nombre del libro.
     * 
     * @return Nombre del libro.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Retorna el autor del libro.
     * 
     * @return Autor del libro.
     */
    public String getAutor() {
        return autor;
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
    public short getAño() {
        return año;
    }

    /**
     * Retorna el género del libro.
     * 
     * @return Género del libro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Retorna las ventas del libro.
     * 
     * @return Ventas del libro.
     */
    public int getVentas() {
        return ventas;
    }

    /**
     * Simula la venta de una copia del libro.
     */
    public void aumentarVentas() {
        ventas++;
    }
    
    @Override
    public String toString() {
        return "Libro: " + nombre + " Autor: " + autor + " Año: " + año + " Genero: " + genero + " ISBN: " + isbn;
    }
}
