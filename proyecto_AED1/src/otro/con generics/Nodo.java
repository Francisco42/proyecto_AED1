package UT03.TA2;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private final T dato;

    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

//    public INodo<T> clonar() {
//        return new Nodo<T>(this.dato, this.etiqueta);
//    }

    @Override
    public boolean equals(INodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
