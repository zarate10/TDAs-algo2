package lineales.dinamicos.conjuntos;

import lineales.dinamicos.conjuntos.implementacion.ConjuntoDin;
import lineales.especificacion.IConjunto;

public class EjecucionConjuntoDin {
    public EjecucionConjuntoDin()
    {
        IConjunto c = new ConjuntoDin();
        c.inicializar();

        c.agregar(2);
        c.agregar(6);
        c.agregar(2);
    }
}
