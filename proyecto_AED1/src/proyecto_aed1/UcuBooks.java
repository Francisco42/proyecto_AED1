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
public class UcuBooks {
    private ListaLibros biblioteca;
    
    public UcuBooks(){
        this.biblioteca = new ListaLibros();
    }
    
    /**
     * 
     * @param libro 
     */
    public void agregarLibro(Libro libro) {
        INodo<Libro> nuevoNodo = new Nodo<>(libro, libro.getISBN());
        if (biblioteca.buscar(nuevoNodo.getEtiqueta()) == null) {
            biblioteca.insertar(nuevoNodo);
            System.out.println("Se ha ingresado exitosamente el nuevo libro.");
        }
    }
    
    /**
     * 
     * @param isbn 
     */
    public void eliminarLibro(long isbn) {
        if (biblioteca.eliminar(isbn)) {
            System.out.println("Se ha eliminado exitosamente.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }
    
    /**
     * 
     * @param nombre 
     */
    public void mostrarPorNombre(String nombre) {
        biblioteca.buscarPorNombre(nombre).imprimirDatos();
    }
    
    /**
     * 
     * @param autor 
     */
    public void mostrarPorAutor(String autor) {
        biblioteca.buscarPorAutor(autor).imprimirDatos();
    }
    
    /**
     * 
     * @param año 
     */
    public void mostrarPorAño(int año) {
        biblioteca.buscarPorAño(año).imprimirDatos();
    }
    
    /**
     * 
     * @param genero 
     */
    public void mostrarPorGenero(String genero) {
        biblioteca.buscarPorGenero(genero).imprimirDatos();
    }
    
    /**
     * 
     * @param isbn 
     */
    public void mostrarDetalles(long isbn) {
        biblioteca.buscar(isbn).imprimir();
    }
    
    /**
     * 
     * @param año 
     */
    public void mostrarUltimasEdiciones(int año) {
        biblioteca.buscarAPartirDel(año).imprimirDatos();
    }
    
    /**
     * 
     * @param isbn 
     */
    public void venderCopia(long isbn) {
        Libro libro = biblioteca.buscar(isbn).getDato();
        libro.aumentarVentas();
        System.out.println("Libro vendido exitosamente.");
    }  
    
    /**
     * 
     * @param isbn 
     */
    public void mostrarVentasLibro(long isbn) {
        Libro libro = biblioteca.buscar(isbn).getDato();
        System.out.println("Se han vendido " + libro.getVentas() + " copias del libro " + libro.getNombre());
    }
    
    /**
     * 
     * @param autor 
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
