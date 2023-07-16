package lineales.dinamicos.colas;

import lineales.dinamicos.colas.implementacion.ColaDin;
import lineales.especificacion.ICola;

public class EjecucionColaDin {
    public EjecucionColaDin()
    {
        ICola cola = new ColaDin();
        cola.inicializar();

        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(5);
    }
}
