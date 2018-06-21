package proyecto_aed1;

import java.util.LinkedList;

/**
 * Interfaz a ser implementada por el TArbolBB.
 * 
 * @author Francisco
 * @param <T> El tipo de los datos de los nodos del arbol.
 */
public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", no hace nada.
     *
     * @param unElemento Elemento a insertar
     */
    public void insertar(IElementoAB<T> unElemento);

 

    /**
     * Busca un elemento dentro del arbol.
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

   
    /**
     * Elimina un elemento dada una etiqueta.
     * 
     * @param unaEtiqueta
     */
    public void eliminar(Comparable unaEtiqueta);

    
    
    /**
     * Imprime en InOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();
    
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
     * Pasa en inorden las claves del arbol a una LinkedList
     * 
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> inorden( );

    /**
     * Pasa en inorden los datos de los nodos del arbol a una LinkedList.
     * 
     * @return una LinkedList con los datos del recorrido.
     */
    public LinkedList<T> inordenDatos();
}

