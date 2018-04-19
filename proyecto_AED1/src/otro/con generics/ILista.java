package UT03.TA2;

public interface ILista<E> {

    /**
     * Método encargado de agregar un nodo en la lista, ordenado segun su etiqueta.
     *
     * @param nodo - Nodo a agregar
     */
    public void insertar(INodo<E> nodo);

    /**
     * Método encargado de buscar un nodo cuya etiqueta es la indicada.
     *
     * @param etiqueta - Etiqueta del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo buscar(Comparable etiqueta);

    /**
     * Método encargado de eliminar un nodo cuya etiqueta es la indicada.
     *
     * @param etiqueta - Etiqueta del nodo a eliminar.
     * @return True en caso de que la eliminación haya sido efectuada con éxito.
     */
    public boolean eliminar(Comparable etiqueta);

    /**
     * Método encargado de imprimir en consola las etiquetas de los nodos
     * contenidos en la lista.
     * 
     * @return String con todas las etiquetas.
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parámetro.
     *
     * @param separador - Separa las claves
     * @return String con todas las etiquetas separadas.
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacía, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public INodo<E> getPrimero();

}
