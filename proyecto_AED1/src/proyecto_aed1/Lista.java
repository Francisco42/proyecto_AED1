package proyecto_aed1;


public class Lista<T> implements ILista<T> {

    protected Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public Lista(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) {
            setPrimero(unNodo);
        } else {
            Nodo<T> aux = getPrimero();
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = getPrimero();
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo aux = getPrimero();
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    @Override
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
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp1 = aux;
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = getPrimero();
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta() + " ";
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }
    
    public void imprimirDatos() {
        if (!esVacia()) {
            Nodo<T> temp = getPrimero();
            while (temp != null) {
                temp.imprimir();
                temp = temp.getSiguiente();
            }
        }
    }

    @Override
    public String imprimir(String separador) {
        String aux;
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = getPrimero();
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public Nodo<T> quitarPrimero() {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            primero = primero.getSiguiente();
            aux.setSiguiente(null);
            return aux;
        }
    }
    
    public boolean equals(Lista<T> otraLista) {
        Nodo<T> aux1 = this.primero;
        Nodo<T> aux2 = otraLista.getPrimero();
        while ((aux1 != null) && (aux2 != null)) {
            if (!aux1.getDato().equals(aux2.getDato())) {
                return false;
            }
            aux1 = aux1.getSiguiente();
            aux2 = aux2.getSiguiente();
        }
        return !((aux1 != null) || (aux2 != null));
    }

}
