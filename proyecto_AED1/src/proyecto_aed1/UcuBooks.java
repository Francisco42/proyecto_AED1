/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 * Clase que representa a la empresa gestora de la biblioteca.
 * 
 * @author Francisco
 */
public class UcuBooks {
    private ListaLibros biblioteca;
    
    public UcuBooks(){
        this.biblioteca = new ListaLibros();
    }
    
    /**
     * Método encargado de insertar un nuevo libro en la biblioteca.
     * 
     * @param libro - El libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        INodo<Libro> nuevoNodo = new Nodo<>(libro, libro.getISBN());
        if (biblioteca.buscar(nuevoNodo.getEtiqueta()) == null) {
            biblioteca.insertar(nuevoNodo);
            System.out.println("Se ha ingresado exitosamente el nuevo libro.");
        }
    }
    
    /**
     * Método encargado de eliminar un libro de la biblioteca.
     * 
     * @param isbn - La clave del libro a eliminar.
     */
    public void eliminarLibro(long isbn) {
        if (biblioteca.eliminar(isbn)) {
            System.out.println("Se ha eliminado exitosamente.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }
    
    /**
     * Muestra en pantalla los resultados de una busqueda de libros por nombre.
     * 
     * @param nombre - El nombre de libro que se busca.
     */
    public void mostrarPorNombre(String nombre) {
        biblioteca.buscarPorNombre(nombre).imprimirDatos();
    }
    
    /**
     * Muestra en pantalla los resultados de una busqueda de libros por autor.
     * 
     * @param autor - El autor que se busca.
     */
    public void mostrarPorAutor(String autor) {
        biblioteca.buscarPorAutor(autor).imprimirDatos();
    }
    
    /**
     * Muestra en pantalla los resultados de una busqueda de libros por año.
     * 
     * @param año - El año que se busca.
     */
    public void mostrarPorAño(int año) {
        biblioteca.buscarPorAño(año).imprimirDatos();
    }
    
    /**
     * Muestra en pantalla los resultados de una busqueda de libros por género.
     * 
     * @param genero - El género que se busca.
     */
    public void mostrarPorGenero(String genero) {
        biblioteca.buscarPorGenero(genero).imprimirDatos();
    }
    
    /**
     * Muestra en pantalla los detalles de un solo libro, despues de una busqueda por ISBN.
     * 
     * @param isbn - La clave del libro que se busca.
     */
    public void mostrarDetalles(long isbn) {
        biblioteca.buscar(isbn).imprimir();
    }
    
    /**
     * Muestra en pantalla los resultados de una busqueda de libros a partir de un cierto año.
     * 
     * @param año - El año a partir del cual se busca.
     */
    public void mostrarUltimasEdiciones(int año) {
        biblioteca.buscarAPartirDel(año).imprimirDatos();
    }
    
    /**
     * Vende una copia del libro especificado.
     * 
     * @param isbn - El código del libro a vender.
     */
    public void venderCopia(long isbn) {
        Libro libro = biblioteca.buscar(isbn).getDato();
        libro.aumentarVentas();
        System.out.println("Libro vendido exitosamente.");
    }  
    
    /**
     * Muestra en pantalla las ventas de un libro en particular.
     * 
     * @param isbn - El código del libro.
     */
    public void mostrarVentasLibro(long isbn) {
        Libro libro = biblioteca.buscar(isbn).getDato();
        System.out.println("Se han vendido " + libro.getVentas() + " copias del libro " + libro.getNombre());
    }
    
    /**
     * Muestra en pantalla las ventas de todos los libros de un autor en particular.
     * 
     * @param autor - El autor del cual de quiere saber sus ventas.
     */
    public void mostrarVentasAutor(String autor) {
        ListaLibros lista = biblioteca.buscarPorAutor(autor);
        int sumaVentas = 0;
        for (INodo<Libro> aux = lista.getPrimero(); aux != null; aux = aux.getSiguiente()) {
            sumaVentas += aux.getDato().getVentas();
        }
        System.out.println("Se han vendido " + sumaVentas + " copias de libros del autor " + autor);
    }
}
