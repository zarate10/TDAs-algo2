package lineales.estaticos.pilas;

import lineales.especificacion.IPila;
import lineales.estaticos.pilas.implementacion.PilaTF;

public class EjecucionPilaTF {

    private IPila printPila(IPila pila)
    {
        PilaTF aux = new PilaTF();
        aux.inicializar();

        if (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            System.out.println(pila.tope());
            pila.desapilar();
            printPila(pila);
        }

        return aux;
    }

    private void cargarPila(IPila pila, int[] valores)
    {
        for (int valor: valores)
        {
            pila.apilar(valor);
        }
    }

    public EjecucionPilaTF()
    {
        PilaTF pila1 = new PilaTF();
        pila1.inicializar();
        cargarPila(pila1, new int[]{ 1, 5, 6, 19, 2 });

        printPila(pila1);
    }
}
