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
public class Autor {
    private final String nombre;
    private Lista<Libro> librosEscritos;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.librosEscritos = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Lista<Libro> getLibrosEscritos() {
        return librosEscritos;
    }
    
    public void insertarLibro(Libro libro) {
        librosEscritos.insertar(new Nodo<>(libro.getISBN(), libro));
    }
}
