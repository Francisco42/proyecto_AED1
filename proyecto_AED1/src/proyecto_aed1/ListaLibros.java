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

    public ListaLibros() {
    }

    public ListaLibros(INodo<Libro> unNodo) {
        super(unNodo);
    }
    
    /**
     * 
     * @param nombre
     * @return 
     */
    public ListaLibros buscarPorNombre(String nombre) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getNombre().equals(nombre)) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * 
     * @param autor
     * @return 
     */
    public ListaLibros buscarPorAutor(String autor) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAutor().equals(autor)) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * 
     * @param genero
     * @return 
     */
    public ListaLibros buscarPorGenero(String genero) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getGenero().equals(genero)) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
//    /**
//     * 
//     * @param isbn
//     * @return 
//     */
//    public ListaLibros buscarPorISBN(long isbn) {
//        ListaLibros listaAux = new ListaLibros();
//        if (!esVacia()) {
//            INodo<Libro> aux = primero;
//            while (aux != null) {
//                if (aux.getDato().getISBN() == isbn) {
//                    listaAux.insertar(aux);
//                }
//                aux = aux.getSiguiente();
//            }
//        }
//        return listaAux;
//    }
    
    /**
     * 
     * @param año
     * @return 
     */
    public ListaLibros buscarPorAño(int año) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAño() == año) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }
    
    /**
     * 
     * @param año
     * @return 
     */
    public ListaLibros buscarAPartirDel(int año) {
        ListaLibros listaAux = new ListaLibros();
        if (!esVacia()) {
            INodo<Libro> aux = primero;
            while (aux != null) {
                if (aux.getDato().getAño() >= año) {
                    listaAux.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaAux;
    }    
}
