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
public class CargadorArchivosBiblioteca {
    
    /**
     * Metodo encargado de transferir la informacion de los libros a la lista
     * de libros de la biblioteca.
     * 
     * @param biblioteca - La biblioteca a la cual se van a agregar libros.
     */
    public void cargarLibros(Biblioteca biblioteca) {
        String[] libros = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/books.csv");
        for (String libro : libros) {
            String[] partesLibro = libro.split("|");
            
            int id = Integer.parseInt(partesLibro[0]);
            String titulo = partesLibro[1];
            short año = Short.parseShort(partesLibro[2]);
            float puntaje = Float.parseFloat(partesLibro[3]);
            int cantidadPuntajes = Integer.parseInt(partesLibro[4]);
            long isbn13 = Long.parseLong(partesLibro[5].split("/")[1]);
            
            Libro lib = new Libro(titulo, isbn13, año, puntaje, cantidadPuntajes);
            biblioteca.insertarLibro(id, lib);
        }
    }
    
    /**
     * Metodo encargado de transferir la informacion del archivo de autores
     * a la lista de autores de la biblioteca.
     * 
     * @param biblioteca - La biblioteca a la cual se van a agregar autores.
     */
    public void cargarAutores(Biblioteca biblioteca) {
        String[] autores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/authors.csv");
        for (String autor : autores) {
            String[] partesAutor = autor.split("|");
            
            int id = Integer.parseInt(partesAutor[0]);
            String nombre = partesAutor[1];
            
            Autor aut = new Autor(nombre);
            biblioteca.insertarAutor(id, aut);
        }
    }
    
    /**
     * Metodo encargado de transeferir la informacion del archivo de tags 
     * a la lista de tags de la biblioteca.
     * 
     * @param biblioteca - La biblioteca a la cual se van a agregar tags.
     */
    public void cargarTags(Biblioteca biblioteca) {
        String[] tags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/tags.csv");
        for (String tag : tags) {
            String[] partesTag = tag.split("|");
            
            int id = Integer.parseInt(partesTag[0]);
            String nombre = partesTag[1];
            
            Tag tg = new Tag(nombre);
            biblioteca.insertarTag(id, tg);
        }
    }
    
    /**
     * Metodo encargado de agregar las referencias a autores en sus 
     * respectivos libros y vice versa.
     * 
     * @param biblioteca - La biblioteca en la cual se van a realizar las 
     * asociaciones.
     */
    public void asociarLibrosAutores(Biblioteca biblioteca) {
        
        Lista<Libro> listaLibros = biblioteca.getListaLibros();
        
        Lista<Autor> listaAutores = biblioteca.getListaAutores();
        
        String[] librosAutores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/bookauthors.csv");
        
        for (String libroAutor : librosAutores) {
            String[] partes = libroAutor.split("|");
            
            int idLibro = Integer.parseInt(partes[0]);
            int idAutor = Integer.parseInt(partes[1]);
            
            Libro libro = listaLibros.buscar(idLibro).getDato();
            Autor autor = listaAutores.buscar(idAutor).getDato();
            
            libro.insertarAutor(idAutor, autor);
            autor.insertarLibro(idLibro, libro);
        }
    }
    
    /**
     * Metdod encargado de agregar las referencias a tags en sus 
     * respectivos libros y vice versa.
     * 
     * @param biblioteca - La biblioteca en la cual se van a realizar las 
     * asociaciones.
     */
    public void asociarLibrosTags(Biblioteca biblioteca) {
        
        Lista<Libro> listaLibros = biblioteca.getListaLibros();
        
        Lista<Tag> listaTags = biblioteca.getListaTags();
        
        String[] librosTags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/booktags.csv");
        
        for (String libroTag : librosTags) {
            String[] partes = libroTag.split("|");
            
            int idLibro = Integer.parseInt(partes[0]);
            int idTag = Integer.parseInt(partes[1]);
            
            Libro libro = listaLibros.buscar(idLibro).getDato();
            Tag tag = listaTags.buscar(idTag).getDato();
            
            libro.insertarTag(idTag, tag);
            tag.insertarLibro(idLibro, libro);
        }
    }
}
