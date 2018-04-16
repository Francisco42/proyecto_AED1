/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_aed1;

/**
 *
 * @author Francisco
 */
public class Nodo {
    private Libro dato;
    private Nodo siguiente;

    public Nodo(Libro dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Libro dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void imprimir() {
        System.out.println(dato.toString());
    }
}
