package proyecto_aed1;


import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;
    private int altura;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        altura = 0;
    }

    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    public IElementoAB getHijoDer() {
        return hijoDer;
    }
    
    public int getAltura() {
        return altura;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(IElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                boolean insertado = hijoIzq.insertar(unElemento);
                actualizarAltura();
                return insertado;
            } else {
                hijoIzq = unElemento;
                actualizarAltura();
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                boolean insertado = hijoDer.insertar(unElemento);
                actualizarAltura();
                return insertado;
            } else {
                hijoDer = unElemento;
                actualizarAltura();
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
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

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
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

    /**
     * @return
     */
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
        if (unaEtiqueta.compareTo(this.etiqueta) < 0){
            if(hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if(unaEtiqueta.compareTo(etiqueta) > 0){
            if(hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }

    public IElementoAB<T> quitaElNodo(){
        if(hijoIzq == null){
            return hijoDer;
        }
        if(hijoDer == null){
            return hijoIzq;
        }
        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;
        while (elHijo.getHijoDer() != null){
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if(elPadre != this){
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);
        return elHijo;
        
    }
    
    @Override
    public void actualizarAltura() {
        altura = 1 + hijoIzq.getAltura() + hijoDer.getAltura();
    }
    
    private IElementoAB<T> rotacionLL(IElementoAB k2) {
        IElementoAB<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        k2.actualizarAltura();
        k1.actualizarAltura();
        return k1;
    }
    
    private IElementoAB<T> rotacionRR(IElementoAB k1) {
        IElementoAB<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        k1.actualizarAltura();
        k2.actualizarAltura();
        return k2;
    }
    
    private IElementoAB<T> rotacionLR(IElementoAB k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }
    
    private IElementoAB<T> rotacionRL(IElementoAB k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }
    
//    @Override
//    public int obtenerAltura() {
//        int alturaIzq = 0;
//        if (hijoIzq != null) {
//            alturaIzq = hijoIzq.obtenerAltura();
//        }
//        int alturaDer = 0;
//        if (hijoDer != null) {
//            alturaDer = hijoDer.obtenerAltura();
//        }
//        return 1 + Math.max(alturaIzq, alturaDer);
//    }
//    
    private boolean isBalanceado() {
        int altHI = hijoIzq.getAltura();
        int altHD = hijoDer.getAltura();
        return Math.abs(altHD - altHI) <= 1;
    }
    
    private void balancear() {
        if (!isBalanceado()) {
            int altLL = hijoIzq.getHijoIzq().getAltura();
            int altLR = hijoIzq.getHijoDer().getAltura();
            int altRL = hijoDer.getHijoIzq().getAltura();
            int altRR = hijoDer.getHijoDer().getAltura();
            if ((altLL > altLR) && (altLL > altRL) && (altLL > altRR)) {
                rotacionLL(this);
            } else if ((altLR > altRL) && (altLR > altRR)) {
                rotacionLR(this);
            } else if (altRL > altRR) {
                rotacionRL(this);
            } else {
                rotacionRR(this);
            }
        }
    }
}
