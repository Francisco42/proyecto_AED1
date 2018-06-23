package proyecto_aed1;

import java.util.LinkedList;

/**
 * Representa al TDA Elemento de Arbol Binario
 * 
 * @author Francisco
 * @param <T> El tipo del dato en el elemento.
 */
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;
    private int altura;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        altura = 0;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return hijoDer;
    }
    
    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    public IElementoAB<T> insertar(IElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.insertar(unElemento);
                actualizarAltura();
                return balancear();
            } else {
                hijoIzq = unElemento;
                actualizarAltura();
                return this;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.insertar(unElemento);
                actualizarAltura();
                return balancear();
            } else {
                hijoDer = unElemento;
                actualizarAltura();
                return this;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.
            return this;
        }
    }
    
    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }

    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }
    
    @Override
    public void inOrdenDatos(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrdenDatos(unaLista);
        }
        unaLista.add(datos);
        if (hijoDer != null) {
            hijoDer.inOrdenDatos(unaLista);
        }
    }
    
    @Override
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden()); 
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }
    
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String imprimir() {
        return (etiqueta.toString());
    }
    
    @Override
    public String imprimirDato() {
        return datos.toString();
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }
  
    @Override
    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if(hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
                actualizarAltura();
                return balancear();
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if(hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
                actualizarAltura();
                return balancear();
            }
            return this;
        }
        IElementoAB<T> nuevo = quitaElNodo();
        return nuevo;
    }

    /**
     * Reemplaza al nodo con el que tiene la clave lexicograficamente anterior.
     * 
     * @return El nodo que va a tomar el lugar del eliminado.
     */
    public IElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;
        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);
        return elHijo;   
    }
    
    @Override
    public void actualizarAltura() {
        int altL = -1;
        int altR = -1;
        if (hijoIzq != null) {
            altL = hijoIzq.getAltura();
        }
        if (hijoDer != null) {
            altR = hijoDer.getAltura();
        }
        altura = 1 + Math.max(altL, altR);
    }
    
    /**
     * Realiza la rotacion necesaria cuando la causa del desbalance viene del 
     * hijo izquierdo del hijo izquierdo.
     * 
     * @param k2 El nodo en el que se da el desbalance
     * @return El nodo que toma el lugar de k2.
     */
    private IElementoAB<T> rotacionLL(IElementoAB k2) {
        IElementoAB<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        k2.actualizarAltura();
        k1.actualizarAltura();
        return k1;
    }
    
    /**
     * Realiza la rotacion necesaria cuando la causa del desbalance viene del 
     * hijo derecho del hijo derecho.
     * 
     * @param k1 El nodo en el que se da el desbalance
     * @return El nodo que toma el lugar de k1.
     */
    private IElementoAB<T> rotacionRR(IElementoAB k1) {
        IElementoAB<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        k1.actualizarAltura();
        k2.actualizarAltura();
        return k2;
    }
    
    /**
     * Realiza la rotacion necesaria cuando la causa del desbalance viene del 
     * hijo derecho del hijo izquierdo.
     * 
     * @param k3 El nodo en el que se da el desbalance
     * @return El nodo que toma el lugar de k3.
     */
    private IElementoAB<T> rotacionLR(IElementoAB k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }
    
    /**
     * Realiza la rotacion necesaria cuando la causa del desbalance viene del 
     * hijo izquierdo del hijo derecho.
     * 
     * @param k1 El nodo en el que se da el desbalance
     * @return El nodo que toma el lugar de k1.
     */
    private IElementoAB<T> rotacionRL(IElementoAB k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }
    
    /**
     * Checkea si el nodo esta balanceado o no.
     * 
     * @return true si esta balanceado, false si no.
     */
    private boolean isBalanceado() {
        int altHI = -1;
        if (hijoIzq != null) {
            altHI = hijoIzq.getAltura();
        }
        int altHD = -1;
        if (hijoDer != null) {
            altHD = hijoDer.getAltura();
        }
        return Math.abs(altHD - altHI) <= 1;
    }
    
    /**
     * Detecta si un nodo esta desbalanceado y realiza las operaciones 
     * necesarias para rebalancear el subarbol.
     * 
     * @return El subarbol rebalanceado.
     */
    private IElementoAB<T> balancear() {
        if (!isBalanceado()) {
            int altLL = -2;
            int altLR = -2;
            int altRL = -2;
            int altRR = -2;
            
            if (hijoIzq != null) {
                if (hijoIzq.getHijoIzq() != null) {
                    altLL = hijoIzq.getHijoIzq().getAltura();
                } else {
                    altLL = -1;
                }
                if (hijoIzq.getHijoDer() != null) {
                    altLR = hijoIzq.getHijoDer().getAltura();
                } else {
                    altLR = -1;
                }
            }
            
            if (hijoDer != null) {
                if (hijoDer.getHijoIzq() != null) {
                    altRL = hijoDer.getHijoIzq().getAltura();
                } else {
                    altRL = -1;
                }
                if (hijoDer.getHijoDer() != null) {
                    altRR = hijoDer.getHijoDer().getAltura();
                } else {
                    altRR = -1;
                }
            }
            
            if ((altLL > altLR) && (altLL > altRL) && (altLL > altRR)) {
                return rotacionLL(this);
            } else if ((altLR > altRL) && (altLR > altRR)) {
                return rotacionLR(this);
            } else if (altRL > altRR) {
                return rotacionRL(this);
            } else {
                return rotacionRR(this);
            }
        }
        return this;
    }
}
