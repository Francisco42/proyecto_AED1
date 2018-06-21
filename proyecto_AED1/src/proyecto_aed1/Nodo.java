package proyecto_aed1;

/**
 * Representa la entidad Nodo.
 * 
 * @author ernesto
 * @param <T> El tipo del dato que lleva el nodo.
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /**
     * Retorna el dato del nodo.
     * 
     * @return El dato del nodo. 
     */
    public T getDato() {
        return this.dato;
    }

    /**
     * Retorna la etiqueta del nodo.
     * 
     * @return La etiqueta.
     */
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    /**
     * Crea un nuevo nodo con el mismo dato y etiqueta.
     * 
     * @return El nuevo nodo.
     */
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

    @Override
    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    /**
     * Retorna el siguiente nodo en la lista.
     * 
     * @return El siguiente nodo.
     */
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Le asigna a este nodo un siguiente nuevo.
     * 
     * @param nodo El nuevo siguiente.
     */
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

}
