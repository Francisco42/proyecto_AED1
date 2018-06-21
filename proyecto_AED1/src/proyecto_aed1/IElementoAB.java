package proyecto_aed1;

import java.util.LinkedList;

/**
 * Interfaz a ser implementada por la entidad TElementoAB
 * 
 * @author Francisco
 * @param <T> El tipo del dato que almacena el elemento
 */
public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @param elemento El nuevo hijo izquierdo.
     */
    public void setHijoIzq(IElementoAB elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @param elemento El nuevo hijo derecho.
     */
    public void setHijoDer(IElementoAB elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB buscar(Comparable unaEtiqueta);

 
    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return El nuevo arbol con el elmento insertado.
     */
    public IElementoAB<T> insertar(IElementoAB elemento);

  
    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Pone las etiquetas del recorrido en inorden en una LinkedList.
     *
     * @param unaLista La lista a la que se agregan las claves.
     */
    public void inOrden(LinkedList<Comparable> unaLista);
    
    /**
     * Pone los datos del recorrido en inorden en una LinkedList.
     * 
     * @param unaLista La lista a la que se agregan los datos.
     */
    public void inOrdenDatos(LinkedList<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return El dato.
     */
    public T getDatos();
   
    /**
     * Elimina un elemento dada una etiqueta.
     * 
     * @param unaEtiqueta La clave del nodo a eliminar.
     * @return El nuevo arbol con el elemento eliminado.
     */
    public IElementoAB<T> eliminar(Comparable unaEtiqueta);
    
    /**
     * Imprime los datos del nodo
     * 
     * @return String con la etiqueta del nodo.
     */
    public String imprimir();
	
    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();
    
    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();
    
    /**
     * Imprime la informacion del dato en el elemento.
     * 
     * @return String con la informacion.
     */
    public String imprimirDato();
    
    /**
     * Retorna la altura del nodo.
     * 
     * @return La altura del nodo.
     */
    public int getAltura();
    
    /**
     * Actualiza la laltura del nodo.
     */
    public void actualizarAltura();
}
