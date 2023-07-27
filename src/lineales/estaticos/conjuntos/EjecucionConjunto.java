package lineales.estaticos.conjuntos;

import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class EjecucionConjunto {

    public static void printConjunto(IConjunto conjunto)
    {
        IConjunto aux = conjunto;
        while(!aux.conjuntoVacio())
        {
            int element = aux.elegir();
            System.out.println(element);
            aux.sacar(element);
        }
    }

    public static void unirConjunto(IConjunto c1, IConjunto c2)
    {
        while (!c2.conjuntoVacio())
        {
            int x = c2.elegir();
            c1.agregar(x);
            c2.sacar(x);
        }
    }

    public EjecucionConjunto()
    {
        IConjunto conjunto = new Conjunto();
        conjunto.inicializar();

        conjunto.agregar(2);
        conjunto.agregar(6);
        conjunto.agregar(1);
        conjunto.agregar(4);
    }
}
