package lineales.estaticos.colasPrioridad.implementacion;

import lineales.especificacion.IColaPrioridad;

public class ColaPrioridad implements IColaPrioridad {
    class Elemento {
        int valor;
        int prioridad;
    }

    Elemento[] elementos;
    int indice;

    public void inicializar() {
        indice = 0;
        elementos = new Elemento[100];
    }

    public void acolarPrioridad(int x, int prioridad) {
        /* recibe como argumento los valores para componer un elemento
         * "j" va a ser el índice de cada uno de los elementos en el vector. Va decrementando en uno, o sea, de fin a inicio (en términos de vector)
         * el fin, representa el primer elemento de la cola, en este caso, es el que mayor prioridad tenga.
         * Si "j" es 0, dícese de un vector sin elementos, por lo tanto, el primero se coloca en ese índice.
         *
         * elementos[j - 1] agarra el elemento con mayor prioridad en la cola. (El último del vector), a su vez compara la prioridad de ese elemento
         * con la nueva prioridad insertada. Si la prioridad nueva es mayor a la prioridad del el elemento con mayor prioridad, entonces se inserta a lo último
         * es decir, con el valor almacenado en el índice.
         *
         * si la prioridad del primero es mayor a la prioridad del último elemento ingresado, (en términos de vector): corre al último elemento uno a la derecha con la asignación
         * de elementos[j](puntero) = elementos[j - 1](ultimo elemento), dejando el espacio correspondiente para el nuevo elemento.
         */
        int j = indice;
        while (j > 0 && elementos[j - 1].prioridad > prioridad)
        {
            elementos[j] = elementos[j - 1];
            j--;
        }
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;
    }

    public void desacolar() {
        /* borrado lógico.*/
        indice--;
    }

    public int primero() {
        /* agarramos el primer elemento en ingresar a la cola -el ultimo elemento en el vector- y traemos su valor.*/
        return elementos[indice - 1].valor;
    }

    public int prioridad() {
        /* agarramos el primer elemento en ingresar a la cola -el ultimo elemento en el vector- y traemos su prioridad.*/
        return elementos[indice - 1].prioridad;
    }

    public boolean colaVacia() {
        return indice == 0;
    }
}
