package lineales.dinamicos.linkedlist.implementacion;

import lineales.especificacion.ILinkedList;

public class ListaDoblementeEnlazada implements ILinkedList {
    class Nodo {
        int value;
        Nodo next;
        Nodo previous;
    }

    Nodo head;
    Nodo cola;

    public void inicializar() {
        head = null;
        cola = null;
    }

    public void add(int x) {
        Nodo nodo = new Nodo();
        nodo.value = x;

        if (head == null) {
            nodo.next = null;
            nodo.previous = null;
            head = nodo;
            cola = nodo;
        } else {
            Nodo aux = head;

            while (aux.next != null)
                aux = aux.next;

            nodo.next = null;
            nodo.previous = cola;

            cola = nodo;
            aux.next = cola;
        }
    }

    public void unshift(int x) {

    }

    public void remove(int x) {

    }

    public int pop() {
        return 0;
    }

    public int size() {
        return 0;
    }

    public Integer get(int indice) {
        return null;
    }
}
