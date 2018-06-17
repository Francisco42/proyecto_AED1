/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

import java.util.LinkedList;

/**
 * Representa la entidad Biblioteca.
 * 
 * @author Francisco
 */
public class Biblioteca {
    private ArbolLibros arbolLibros;
    private ArbolTags arbolTags;
    private ArbolAutores arbolAutores;
    private ArbolLibros arbolLibrosUntagged;
    
    public Biblioteca() {
        arbolLibros = new ArbolLibros();
        arbolTags = new ArbolTags();
        arbolAutores = new ArbolAutores();
        arbolLibrosUntagged = new ArbolLibros();
    }

    /**
     * Retorna la lista de libros de la biblioteca.
     * 
     * @return - La lista de libros.
     */
    public ArbolLibros getArbolLibros() {
        return arbolLibros;
    }

    /**
     * Retorna la lista de tags de la biblioteca.
     * 
     * @return - La lista de tags.
     */
    public ArbolTags getArbolTags() {
        return arbolTags;
    }

    /**
     * Retorna la lista de autores de la biblioteca.
     * 
     * @return - La lista de autores.
     */
    public ArbolAutores getArbolAutores() {
        return arbolAutores;
    }
    
    public ArbolLibros getArbolLibrosUntagged() {
        return arbolLibrosUntagged;
    }
    
    /**
     * Inserta un nuevo libro en la biblioteca.
     * 
     * @param id - El id del libro a insertar.
     * @param libro - El libro a insertar.
     */
    public void insertarLibro(Libro libro) {
        arbolLibros.insertar(new TElementoAB<>(libro.getTitulo(), libro));
    }
    
    /**
     * Inserta un nuevo autor en la biblioteca.
     * 
     * @param id - El id del autor a insertar.
     * @param autor - El autor a insertar.
     */
    public void insertarAutor(Autor autor) {
        arbolAutores.insertar(new TElementoAB<>(autor.getNombre(), autor));
    }
    
    /**
     * Inserta un nuevo tag en la biblioteca.
     * 
     * @param id - El id del tag a insertar.
     * @param tag - El tag a insertar.
     */
    public void insertarTag(Tag tag) {
        arbolTags.insertar(new TElementoAB<>(tag.getTag(), tag));
    }
    
    /**
     * Muestra en pantalla todos los libros publicados a partir de cierto año.
     * 
     * @param año - El año de criterio.
     */
    public void mostrarUltimasEdiciones(int año) {
        LinkedList<Libro> listaAux = arbolLibros.mostrarUltimasEdiciones(año);
        if (listaAux.isEmpty()) {
            System.out.println("No se encontraron libros que cumplan con el criterio");
        }
        for (Libro libro : listaAux) {
            System.out.println(libro.toString());
        }   
    }
    
    /**
     * Muestra en pantalla todos los libros que tienen un titulo dado.
     * 
     * @param titulo - El titulo que se busca.
     */
    public void mostrarPorTitulo(String titulo) {
        Libro libro = arbolLibros.mostrarPorTitulo(titulo);
        if (libro != null) {
            System.out.println(libro.toString());
        } else {
            System.out.println("No se encontraron libros que cumplan con el criterio");
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que fueron publicados en un 
     * cierto año.
     * 
     * @param año - El año que se busca.
     */
    public void mostrarPorAño(int año) {
        LinkedList<Libro> listaAux = arbolLibros.mostrarPorAño(año);
        if (listaAux.isEmpty()) {
            System.out.println("No se encontraron libros que cumplan con el criterio");
        }
        for (Libro libro : listaAux) {
            System.out.println(libro.toString());
        }  
    }
    
    /**
     * Muestra en pantalla el libro que tiene el ISBN13 dado.
     * 
     * @param isbn - El ISBN13 que se busca.
     */
    public void mostrarPorISBN(long isbn) {
        Libro libro = arbolLibros.mostrarPorISBN(isbn);
        if (libro != null) {
            System.out.println(libro.toString());
        } else {
            System.out.println("No se encontraron libros que cumplan con el criterio");
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que fueron escritos por un 
     * cierto autor
     * 
     * @param autor - El autor que se busca.
     */
    public void mostrarPorAutor(String autor) {
        Lista<Libro> listaAux = arbolAutores.mostrarPorAutor(autor);
        if (listaAux != null) {
            listaAux.imprimirDatos();
            if (listaAux.esVacia()) {
                System.out.println("No se encontraron libros que cumplan con el criterio");
            }
        }
    }
    
    /**
     * Muestra en pantalla todos los libros que llevan un cierto tag.
     * 
     * @param tag - El tag que se busca.
     */
    public void mostrarPorTag(String tag) {
        Lista<Libro> listaAux = arbolTags.mostrarPorTag(tag);
        if (listaAux != null) {
            listaAux.imprimirDatos();
            if (listaAux.esVacia()) {
                System.out.println("No se encontraron libros que cumplan con el criterio");
            }
        }
    }
    
    /**
     * Muestra toda la informacion de un libro, incluyendo sus autores y tags.
     * 
     * @param isbn - El ISBN13 del libro que se busca.
     */
    public void mostrarDetalles(String titulo) {
        arbolLibros.mostrarDetalles(titulo);
    }
    
    /**
     * Elimina un autor de la biblioteca y todos los libros escritos por el.
     * 
     * @param autor - El autor a eliminar.
     */
    public void eliminarAutor(String autor) {
        
        IElementoAB<Autor> auxAutor = arbolAutores.buscar(autor);
        
        if (auxAutor != null) {
            Autor autorAEliminar = auxAutor.getDatos();
            Lista<Libro> librosAEliminar = autorAEliminar.getLibrosEscritos();
            Nodo<Libro> aux = librosAEliminar.getPrimero();
            while (aux != null) {
                arbolLibros.eliminar(aux.getEtiqueta());
                aux = aux.getSiguiente();
            }
            arbolAutores.eliminar(autor);
            System.out.println("Eliminación realizada exitosamente.");
        } else {
            System.out.println("No se encontró el autor a eliminar.");
        }
    }
    
    public void eliminarTag(String tag) {
        
        IElementoAB<Tag> auxTag = arbolTags.buscar(tag);
        
        if (auxTag != null) {
            Tag tagAEliminar = auxTag.getDatos();
            Lista<Libro> librosAUntaggear = tagAEliminar.getLibrosTagged();
            Nodo<Libro> aux = librosAUntaggear.getPrimero();
            while (aux != null) {
                IElementoAB<Libro> auxLibro = arbolLibros.buscar(aux.getEtiqueta());
                if (auxLibro != null) {
                    Libro libro = auxLibro.getDatos();
                    Lista<Tag> tags = libro.getTags();
                    tags.eliminar(tag);
                    if (tags.esVacia()) {
                        arbolLibrosUntagged.insertar(new TElementoAB<>(libro.getTitulo(), libro));
                        arbolLibros.eliminar(libro.getTitulo());
                    }
                }
            }
            arbolTags.eliminar(tag);
            System.out.println("Eliminacion realizada exitosamente.");
        } else {
            System.out.println("No se encontro el tag a eliminar.");
        }
    }
}
