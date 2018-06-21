/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;



/**
 * Clase encargada de las operaciones de carga de archivos en la biblioteca.
 * 
 * @author Francisco
 */
public class CargadorArchivosBiblioteca {
    
    /**
     * Metodo encargado de transferir la informacion de los libros a la lista
     * de libros de la biblioteca.
     * 
     * @param biblioteca La biblioteca a la cual se van a agregar libros.
     */
    public void cargarLibros(Biblioteca biblioteca) {
        String[] libros = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/books.csv");
        //String[] libros = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/booksTest.txt");
        for (String libro : libros) {
            String[] partesLibro = libro.split("\\|");
            
            if ((partesLibro.length == 6) && (checkearVacios(partesLibro))) {
                try {
                    int id = Integer.parseInt(partesLibro[0]);
                    String titulo = partesLibro[1];
                    short año = Short.parseShort(partesLibro[2]);
                    float puntaje = Float.parseFloat(partesLibro[3]);
                    int cantidadPuntajes = Integer.parseInt(partesLibro[4]);
                    long isbn13 = Long.parseLong(partesLibro[5].split("\\/")[1]);
                    
                    Libro lib = new Libro(id, titulo, isbn13, año, puntaje, cantidadPuntajes);
                    biblioteca.insertarLibro(lib);
                } catch (NumberFormatException ex) {}
            }
        }
    }
    
    /**
     * Metodo encargado de transferir la informacion del archivo de autores
     * a la lista de autores de la biblioteca.
     * 
     * @param biblioteca La biblioteca a la cual se van a agregar autores.
     */
    public void cargarAutores(Biblioteca biblioteca) {
        String[] autores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/authors.csv");
        //String[] autores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/authorsTest.txt");
        for (String autor : autores) {
            String[] partesAutor = autor.split("\\|");
            
            if ((partesAutor.length == 2) && (checkearVacios(partesAutor))) {
                try {
                    int id = Integer.parseInt(partesAutor[0]);
                    String nombre = partesAutor[1];
                    
                    Autor aut = new Autor(id, nombre);
                    biblioteca.insertarAutor(aut);
                } catch (NumberFormatException ex) {}
            }
        }
    }
    
    /**
     * Metodo encargado de transeferir la informacion del archivo de tags 
     * a la lista de tags de la biblioteca.
     * 
     * @param biblioteca La biblioteca a la cual se van a agregar tags.
     */
    public void cargarTags(Biblioteca biblioteca) {
        String[] tags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/tags.csv");
        //String[] tags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/tagsTest.txt");
        for (String tag : tags) {
            String[] partesTag = tag.split("\\|");
            
            if ((partesTag.length == 2) && (checkearVacios(partesTag))) {
                try {
                    int id = Integer.parseInt(partesTag[0]);
                    String nombre = partesTag[1];
                    
                    Tag tg = new Tag(id, nombre);
                    biblioteca.insertarTag(tg);
                } catch (NumberFormatException ex) {}
            }
        }
    }
    
    /**
     * Metodo encargado de agregar las referencias a autores en sus 
     * respectivos libros y vice versa.
     * 
     * @param biblioteca La biblioteca en la cual se van a realizar las 
     * asociaciones.
     */
    public void asociarLibrosAutores(Biblioteca biblioteca) {
        
        ArbolLibros arbolLibros = biblioteca.getArbolLibros();
        ArbolAutores arbolAutores = biblioteca.getArbolAutores();
        String[] librosAutores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/bookauthors.csv");
        //String[] librosAutores = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/bookauthorsTest.txt");
        for (String libroAutor : librosAutores) {
            String[] partes = libroAutor.split("\\|");
            
            if ((partes.length == 2) && (checkearVacios(partes))) {
                try {
                    int idLibro = Integer.parseInt(partes[0]);
                    int idAutor = Integer.parseInt(partes[1]);
                    
                    Libro libro = null;
                    Autor autor = null;
                    
                    for (Libro libroAux : arbolLibros.inordenDatos()) {
                        if (libroAux.getID() == idLibro) {
                            libro = libroAux;
                            break;
                        }
                    }
                    for (Autor autorAux : arbolAutores.inordenDatos()) {
                        if (autorAux.getID() == idAutor) {
                            autor = autorAux;
                            break;
                        }
                    }

                    libro.insertarAutor(autor);
                    autor.insertarLibro(libro);

                } catch (NumberFormatException | NullPointerException ex) {}
            }
        }
    }
    
    /**
     * Metdod encargado de agregar las referencias a tags en sus 
     * respectivos libros y vice versa.
     * 
     * @param biblioteca La biblioteca en la cual se van a realizar las 
     * asociaciones.
     */
    public void asociarLibrosTags(Biblioteca biblioteca) {
        
        ArbolLibros arbolLibros = biblioteca.getArbolLibros();
        ArbolTags arbolTags = biblioteca.getArbolTags();
        String[] librosTags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/booktags.csv");
        //String[] librosTags = ManejadorArchivosGenerico.leerArchivo("src/proyecto_aed1/booktagsTest.txt");
        for (String libroTag : librosTags) {
            String[] partes = libroTag.split("\\|");
            
            if ((partes.length == 2) && (checkearVacios(partes))) {
                try {
                    int idLibro = Integer.parseInt(partes[0]);
                    int idTag = Integer.parseInt(partes[1]);
                    
                    Libro libro = null;
                    Tag tag = null;
                    
                    for (Libro libroAux : arbolLibros.inordenDatos()) {
                        if (libroAux.getID() == idLibro) {
                            libro = libroAux;
                            break;
                        }
                    }
                    for (Tag tagAux : arbolTags.inordenDatos()) {
                        if (tagAux.getID() == idTag) {
                            tag = tagAux;
                            break;
                        }
                    }
                    
                    libro.insertarTag(tag);
                    tag.insertarLibro(libro);
                } catch (NumberFormatException | NullPointerException ex) {}
            }
        }
    }
    
    /**
     * Checkea si una arreglo de strings tiene algun string vacio.
     * 
     * @param lista La lista a checkear.
     * @return true si la lista no tiene ningun string vacio, false en caso
     * contrario.
     */
    private boolean checkearVacios(String[] lista) {
        for (String s : lista) {
            if (s.equals("")) {
                return false;
            }
        }
        return true;
    }
}
