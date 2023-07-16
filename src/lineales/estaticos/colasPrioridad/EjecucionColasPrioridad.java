package lineales.estaticos.colasPrioridad;

import lineales.especificacion.IColaPrioridad;
import lineales.estaticos.colasPrioridad.implementacion.ColaPrioridad;

public class EjecucionColasPrioridad {
    public EjecucionColasPrioridad()
    {
        IColaPrioridad colap1 = new ColaPrioridad();
        colap1.inicializar();

        colap1.acolarPrioridad(3, 0);
        colap1.acolarPrioridad(5, 9);
        colap1.acolarPrioridad(0, 4);
    }
}
