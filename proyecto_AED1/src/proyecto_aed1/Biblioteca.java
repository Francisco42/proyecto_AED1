/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Representa la entidad Biblioteca.
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

    /**
     * 
     * 
     * @return 
     */
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
        Nodo<Libro> aux = listaLibros.getPrimero();
        while (aux != null) {
            if (aux.getDato().getISBN() == isbn) {
                aux.imprimir();
                break;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarPorAutor(String autor) {
        Nodo<Autor> aux = listaAutores.getPrimero();
        while (aux != null) {
            if (aux.getDato().getNombre().equals(autor)) {
                aux.imprimir();
                aux.getDato().getLibrosEscritos().imprimirDatos();
                break;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarPorTag(String tag) {
        Nodo<Tag> aux = listaTags.getPrimero();
        while (aux != null) {
            if (aux.getDato().getTag().equals(tag)) {
                aux.imprimir();
                aux.getDato().getLibrosTagged().imprimirDatos();
                break;
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarDetalles(String nombre) {
        Nodo<Libro> aux = listaLibros.getPrimero();
        while (aux != null) {
            if (aux.getDato().getTitulo().equals(nombre)) {
                aux.imprimir();
                aux.getDato().getAutores().imprimirDatos();
                aux.getDato().getTags().imprimirDatos();
            }
            aux = aux.getSiguiente();
        }
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
