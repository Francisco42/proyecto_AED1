package UT03.TA2;

public interface INodo<E> {

    /**
     * Retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    public E getDato();

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
    public boolean equals(INodo<E> unNodo);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
