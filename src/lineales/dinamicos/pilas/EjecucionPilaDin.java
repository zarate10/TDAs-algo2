package lineales.dinamicos.pilas;

import lineales.dinamicos.pilas.implementacion.PilaDin;
import lineales.especificacion.IPila;

public class EjecucionPilaDin {
    public EjecucionPilaDin()
    {
        IPila pila = new PilaDin();
        pila.inicializar();

        pila.apilar(4);
        pila.apilar(1);
        pila.apilar(0);

        while (!pila.pilaVacia())
        {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }
}
