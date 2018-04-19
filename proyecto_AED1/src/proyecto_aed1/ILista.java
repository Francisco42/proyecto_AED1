package proyecto_aed1;

public interface ILista<E> {

    /**
     * Metodo encargado de agregar un elemento al final de la lista.
     *
     * @param elemento - Elemento a agregar
     */
    public void insertar(E elemento);

    /**
     * Metodo encargado de buscar un elemento cuya clave es la indicada.
     *
     * @param clave - Clave del elemento a buscar.
     * @return El elemento encontrado. En caso de no encontrarlo, retornar null.
     */
    public E buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un elemento cuya clave es la indicada.
     *
     * @param clave Clave del elemento a eliminar.
     * @return True en caso de que la eliminacion haya sido efectuada con exito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Metodo encargado de imprimir en consola las claves de los elementos
     * contenidos en la lista.
     * @return String con todas las claves
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parametro.
     *
     * @param separador Separa las claves
     * @return String con todas las claves separadas
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vacia, retornar 0.
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
    //public INodo<E> getPrimero();

}
