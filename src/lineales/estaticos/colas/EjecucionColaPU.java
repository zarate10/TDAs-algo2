package lineales.estaticos.colas;

import lineales.especificacion.ICola;
import lineales.estaticos.colas.implementacion.ColaPU;

public class EjecucionColaPU {
    public EjecucionColaPU()
    {
        ICola cola1 = new ColaPU();
        cola1.inicializar();

        cola1.acolar(1);
        cola1.acolar(5);
        cola1.acolar(7);
        cola1.acolar(2);
    }

}
