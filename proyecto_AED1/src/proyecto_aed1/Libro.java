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
    
    public int getVentas() {
        return ventas;
    }
    
    public void aumentarVentas() {
        ventas++;
    }
    
    @Override
    public String toString() {
        return "Libro: " + nombre + " Autor: " + autor + " Año: " + año + " Genero: " + genero + " ISBN: " + isbn;
    }
}
