/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Extiende el TArbolBB, con el tipo Autor.
 * 
 * @author Francisco
 */
public class ArbolAutores extends TArbolBB<Autor> {

    public ArbolAutores() {
    }
    
    /**
     * Busca todos los libros que fueron escritos por un 
     * cierto autor
     * 
     * @param autor El autor que se busca.
     * @return Los libros escritos por ese autor.
     */
    public Lista<Libro> mostrarPorAutor(String autor) {
        IElementoAB<Autor> aux = buscar(autor);
        if (aux != null) {
            return aux.getDatos().getLibrosEscritos();
        } else {
            return null;
        }
    }
}
