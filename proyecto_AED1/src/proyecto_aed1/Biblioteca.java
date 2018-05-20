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
    private ListaLibros listaLibros;
    private ListaTags listaTags;
    private ListaAutores listaAutores;
    
    public Biblioteca() {
        listaLibros = new ListaLibros();
        listaTags = new ListaTags();
        listaAutores = new ListaAutores();
    }

    /**
     * Retorna la lista de libros de la biblioteca.
     * 
     * @return - La lista de libros.
     */
    public ListaLibros getListaLibros() {
        return listaLibros;
    }

    /**
     * Retorna la lista de tags de la biblioteca.
     * 
     * @return - La lista de tags.
     */
    public ListaTags getListaTags() {
        return listaTags;
    }

    /**
     * Retorna la lista de autores de la biblioteca.
     * 
     * @return - La lista de autores.
     */
    public ListaAutores getListaAutores() {
        return listaAutores;
    }
    
    /**
     * Inserta un nuevo libro en la biblioteca.
     * 
     * @param id - El id del libro a insertar.
     * @param libro - El libro a insertar.
     */
    public void insertarLibro(int id, Libro libro) {
        listaLibros.insertar(new Nodo<>(id, libro));
    }
    
    /**
     * Inserta un nuevo autor en la biblioteca.
     * 
     * @param id - El id del autor a insertar.
     * @param autor - El autor a insertar.
     */
    public void insertarAutor(int id, Autor autor) {
        listaAutores.insertar(new Nodo<>(id, autor));
    }
    
    /**
     * Inserta un nuevo tag en la biblioteca.
     * 
     * @param id - El id del tag a insertar.
     * @param tag - El tag a insertar.
     */
    public void insertarTag(int id, Tag tag) {
        listaTags.insertar(new Nodo<>(id, tag));
    }
    
    /**
     * Muestra en pantalla todos los libros publicados a partir de cierto año.
     * 
     * @param año - El año de criterio.
     */
    public void mostrarUltimasEdiciones(int año) {
        Lista<Libro> listaAux = listaLibros.mostrarUltimasEdiciones(año);
        if (listaAux != null) {
            listaAux.imprimirDatos();
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que tienen un titulo dado.
     * 
     * @param titulo - El titulo que se busca.
     */
    public void mostrarPorTitulo(String titulo) {
        Lista<Libro> listaAux = listaLibros.mostrarPorTitulo(titulo);
        if (listaAux != null) {
            listaAux.imprimirDatos();
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que fueron publicados en un 
     * cierto año.
     * 
     * @param año - El año que se busca.
     */
    public void mostrarPorAño(int año) {
        Lista<Libro> listaAux = listaLibros.mostrarPorAño(año);
        if (listaAux != null) {
            listaAux.imprimirDatos();
        }
    }
    
    /**
     * Muestra en pantalla el libro que tiene el ISBN13 dado.
     * 
     * @param isbn - El ISBN13 que se busca.
     */
    public void mostrarPorISBN(long isbn) {
        Libro aux = listaLibros.mostrarPorISBN(isbn);
        if (aux != null) {
            System.out.println(aux.toString());
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que fueron escritos por un 
     * cierto autor
     * 
     * @param autor - El autor que se busca.
     */
    public void mostrarPorAutor(String autor) {
        Lista<Libro> listaAux = listaAutores.mostrarPorAutor(autor);
        if (listaAux != null) {
            listaAux.imprimirDatos();
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que llevan un cierto tag.
     * 
     * @param tag - El tag que se busca.
     */
    public void mostrarPorTag(String tag) {
        Lista<Libro> listaAux = listaTags.mostrarPorTag(tag);
        if (listaAux != null) {
            listaAux.imprimirDatos();
        }
    }
    
    /**
     * Muestra toda la informacion de un libro, incluyendo sus autores y tags.
     * 
     * @param isbn - El ISBN13 del libro que se busca.
     */
    public void mostrarDetalles(long isbn) {
        listaLibros.mostrarDetalles(isbn);
    }
    
    /**
     * Elimina un autor de la biblioteca y todos los libros escritos por el.
     * 
     * @param autor - El autor a eliminar.
     */
    public void eliminarAutor(String autor) {
        
        Nodo<Autor> auxAutor = listaAutores.getPrimero();
        while (auxAutor != null) {
            if (auxAutor.getDato().getNombre().equals(autor)) {
                break;
            } else {
                auxAutor = auxAutor.getSiguiente();
            }
        }
        
        if (auxAutor != null) {
            Autor autorAEliminar = auxAutor.getDato();
            Lista<Libro> librosAEliminar = autorAEliminar.getLibrosEscritos();
            Nodo<Libro> aux = librosAEliminar.getPrimero();
            while (aux != null) {
                listaLibros.eliminar(aux.getEtiqueta());
                aux = aux.getSiguiente();
            }
            listaAutores.eliminar(autorAEliminar.getID());
            System.out.println("Eliminación realizada exitosamente.");
        } else {
            System.out.println("No se encontró el autor a eliminar.");
        }
    }
}
