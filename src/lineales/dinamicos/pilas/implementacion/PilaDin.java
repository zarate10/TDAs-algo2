package lineales.dinamicos.pilas.implementacion;

import lineales.especificacion.IPila;

public class PilaDin implements IPila {
    class Nodo {
        int x;
        Nodo next;
    }

    Nodo tope;

    public void inicializar() { // O(1)
        tope = null;
    }

    public void apilar(int x) { // O(1)
        Nodo nuevo = new Nodo();
        nuevo.x = x;
        nuevo.next = tope;
        tope = nuevo;
    }

    public void desapilar() { // O(1)
        tope = tope.next;
    }

    public int tope() { // O(1)
        return tope.x;
    }

    public boolean pilaVacia() { // O(1)
        return (tope == null);
    }
}
