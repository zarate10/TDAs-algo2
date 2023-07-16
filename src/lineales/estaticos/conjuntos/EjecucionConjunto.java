package lineales.estaticos.conjuntos;

import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class EjecucionConjunto {
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
