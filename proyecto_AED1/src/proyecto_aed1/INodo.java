package proyecto_aed1;

/**
 * Interfaz a ser implementada por al entidad Nodo.
 * 
 * @author Francisco
 * @param <T> - El tipo del dato del nodo.
 */
public interface INodo<T> {

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     * 
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(Nodo<T> unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
