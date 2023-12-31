package lineales.dinamicos.linkedlist;

import lineales.dinamicos.linkedlist.implementacion.LinkedList;
import lineales.dinamicos.linkedlist.implementacion.ListaDoblementeEnlazada;
import lineales.especificacion.ILinkedList;

public class EjecucionLinkedList {
    private void print(ILinkedList list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
        }
        System.out.print("]\n");
    }

    public EjecucionLinkedList()
    {
        /*
        ILinkedList list = new LinkedList();
        list.add(5);
        list.add(56);
        list.add(2);
        list.unshift(22);
        list.unshift(33);

        print(list);
        list.remove(5);
        list.remove(2);
        list.remove(33);
        print(list);
*/
        ILinkedList ListaDE = new ListaDoblementeEnlazada();

        ListaDE.add(3);
        ListaDE.add(6);
        ListaDE.add(1);
        ListaDE.add(8);
        ListaDE.add(2);
        ListaDE.add(5);
        ListaDE.add(1);

    }
}
