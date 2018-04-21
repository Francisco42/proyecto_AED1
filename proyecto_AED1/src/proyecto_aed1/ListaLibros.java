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
public class ListaLibros extends Lista<Libro> {
    private int ventas = 0;

    public ListaLibros() {
    }

    public ListaLibros(INodo<Libro> unNodo) {
        super(unNodo);
    }

    public int getVentas() {
        return ventas;
    }
    
    public INodo<Libro> buscarPorNombre(String nombre) {
        if (esVacia()) {
            return null;
        } else {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getNombre().equals(nombre)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public INodo<Libro> buscarPorAutor(String autor) {
        if (esVacia()) {
            return null;
        } else {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAutor().equals(autor)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public INodo<Libro> buscarPorGenero(String genero) {
        if (esVacia()) {
            return null;
        } else {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getGenero().equals(genero)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public INodo<Libro> buscarPorISBN(long isbn) {
        if (esVacia()) {
            return null;
        } else {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getISBN() == isbn) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public INodo<Libro> buscarPorAño(int año) {
        if (esVacia()) {
            return null;
        } else {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAño() == año) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    @Override
    public boolean eliminar(Comparable clave) {
        ventas++;
        return super.eliminar(clave);
    }
    
        
        
}
