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
public class Biblioteca {
    private Lista<Libro> listaLibros;
    private Lista<Tag> listaTags;
    private Lista<Autor> listaAutores;
    
    public Biblioteca() {
        listaLibros = new Lista<>();
        listaTags = new Lista<>();
        listaAutores = new Lista<>();
    }

    public Lista<Libro> getListaLibros() {
        return listaLibros;
    }

    public Lista<Tag> getListaTags() {
        return listaTags;
    }

    public Lista<Autor> getListaAutores() {
        return listaAutores;
    }
    
    public void insertarLibro(int id, Libro libro) {
        listaLibros.insertar(new Nodo<>(id, libro));
    }
    
    public void insertarAutor(int id, Autor autor) {
        listaAutores.insertar(new Nodo<>(id, autor));
    }
    
    public void insertarTag(int id, Tag tag) {
        listaTags.insertar(new Nodo<>(id, tag));
    }
    
    public void mostrarUltimasEdiciones(int año) {
        Nodo<Libro> aux = listaLibros.getPrimero();
        while (aux != null) {
            if (aux.getDato().getAño() >= año) {
                aux.imprimir();
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarPorTitulo(String titulo) {
        Nodo<Libro> aux = listaLibros.getPrimero();
        while (aux != null) {
            if (aux.getDato().getTitulo().equals(titulo)) {
                aux.imprimir();
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarPorAño(int año) {
        Nodo<Libro> aux = listaLibros.getPrimero();
        while (aux != null) {
            if (aux.getDato().getAño() == año) {
                aux.imprimir();
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarPorISBN(long isbn) {
        Nodo<Libro> aux = listaLibros.buscar(isbn);
        aux.imprimir();
    }
    
    public void mostrarPorAutor(String autor) {
        
    }
    
    public void mostrarPorTag(String tag) {
        
    }
    
    public void mostrarDetalles(long isbn) {
        
    }
    
    public void eliminarAutor(String autor) {
        Nodo<Autor> auxAutor = listaAutores.buscar(autor);
        if (auxAutor != null) {
            Autor autorAEliminar = auxAutor.getDato();
            Lista<Libro> librosAEliminar = autorAEliminar.getLibrosEscritos();
            Nodo<Libro> aux = librosAEliminar.getPrimero();
            while (aux != null) {
                listaLibros.eliminar(aux.getEtiqueta());
                aux = aux.getSiguiente();
            }
            listaAutores.eliminar(autor);
            System.out.println("Eliminación realizada exitosamente.");
        } else {
            System.out.println("No se encontró el autor a eliminar.");
        }
    }
}
