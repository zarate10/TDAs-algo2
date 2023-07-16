package lineales.dinamicos.linkedlist.implementacion;

import lineales.especificacion.ILinkedList;

public class LinkedList implements ILinkedList {
    class Nodo {
        int x;
        Nodo next;
    }

    Nodo head;
    int totalElementos;

    public void inicializar() {
        head = null;
        totalElementos = 0;
    }

    public void add(int x) {
        Nodo nuevo = new Nodo();
        nuevo.x = x;
        nuevo.next = null;

        if(head == null)
        {
            head = nuevo;
        } else {
            Nodo aux = head;
            while (aux.next != null)
            {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
        totalElementos++;
    }

    public void unshift(int x) {
        Nodo nuevo = new Nodo();
        nuevo.x = x;
        nuevo.next = head;
        head = nuevo;

        totalElementos++;
    }

    public void remove(int x) {
        Nodo aux = head;

        if(head.x == x)
        {
            head = head.next;
        } else {
            while (aux.next.x != x)
            {
                aux = aux.next;
            }
            aux.next = aux.next.next;
        }
        totalElementos--;
    }

    public int pop() {
        Nodo aux;
        aux = head;
        int x;

        if(!(aux.next == null)){
            while(aux.next != null)
            {
                if(aux.next.next == null)
                {
                    x = aux.next.x;
                    aux.next = null;

                    return x;
                }
                aux = aux.next;
            }
        }

        x = aux.x;
        head = null;
        return x;
    }

    public Integer get(int indice)
    {
        if (indice > -1 && indice < this.totalElementos)
        {
            int i = 0;
            Nodo aux = head;

            while(i < indice)
            {
                aux = aux.next;
                i++;
            }

            return aux.x;
        } else {
            return null;
        }
    }

    public int size() {
        return totalElementos;
    }

}
