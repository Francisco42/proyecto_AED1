package proyecto_aed1;


import java.util.LinkedList;

public class TArbolBB<T> implements IArbolBB<T> {

    protected IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }
    
    public String preOrden() {
        if (raiz == null ) {
            return "Arbol vacio.";
        } else {
            return raiz.preOrden();
        }
    }
    
    public String postOrden() {
        if (raiz == null ) {
            return "Arbol vacio.";
        } else {
            return raiz.postOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
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
