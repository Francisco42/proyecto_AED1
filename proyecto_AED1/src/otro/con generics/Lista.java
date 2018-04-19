package UT03.TA2;

public class Lista<E> implements ILista<E> {

    private INodo<E>[] arreglo;
    private int ultimoIndice;

    public Lista() {
        this.arreglo = (INodo<E>[])new Object[100];
        this.ultimoIndice = 0;
    }

    public void insertar(INodo<E> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            INodo<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }
    
    /**
     * 
     */
    private void redimensionar() {
        int nuevoLength = arreglo.length * 2;
        INodo<E>[] nuevoArreglo = (INodo<E>[])new Object[nuevoLength];
        for (int i = 0; i < arreglo.length; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }
    
    /**
     * 
     * @param posicion - Posicion a partir de la cual se desplazan los elementos del arreglo (inclusive).
     */
    private void desplazarHaciaDerecha(int posicion) {
        if (ultimoIndice == arreglo.length) {
            redimensionar();
        }
        
    }
     /**
      * 
      * @param posicion 
      */
    private void desplazarHaciaIzquierda(int posicion) {
        
    }

    public INodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp1 = aux;
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public INodo<E> getPrimero() {
        return primero;
    }
}
