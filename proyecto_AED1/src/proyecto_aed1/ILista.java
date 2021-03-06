package proyecto_aed1;

/**
 * Interfaz a ser implentada por el TDALista.
 * 
 * @author Francisco
 * @param <T> El tipo de los datos de los nodos de la lista.
 */
public interface ILista<T> {

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo Nodo a agregar
     */
    public void insertar(Nodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminacion haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Metodo encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     * @return 
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * parametro.
     *
     * @param separador Separa las claves
     * @return
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
    public Nodo<T> getPrimero();

    /**
     * Remueve y retorna el primer nodo de la lista.
     * 
     * @return Primer nodo de la lista.
     */
    public Nodo<T> quitarPrimero();
}
