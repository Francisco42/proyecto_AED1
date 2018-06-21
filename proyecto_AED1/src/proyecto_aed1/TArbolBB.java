package proyecto_aed1;


import java.util.LinkedList;

/**
 * Representa al TDA Arbol Binario.
 * 
 * @author Francisco
 * @param <T> El tipo de los datos en los nodos del arbol.
 */
public class TArbolBB<T> implements IArbolBB<T> {

    protected IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public void insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
        } else {
            raiz = raiz.insertar(unElemento);
        }
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }
    
    @Override
    public String preOrden() {
        if (raiz == null ) {
            return "Arbol vacio.";
        } else {
            return raiz.preOrden();
        }
    }
    
    @Override
    public String postOrden() {
        if (raiz == null ) {
            return "Arbol vacio.";
        } else {
            return raiz.postOrden();
        }
    }

    /**
     * @return true si el arbol esta vacio, false en caso contrario.
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }
    
    @Override
    public LinkedList<T> inordenDatos() {
        LinkedList<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrdenDatos(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }
}
