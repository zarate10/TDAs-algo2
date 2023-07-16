package lineales.estaticos.colas.implementacion;

import lineales.especificacion.ICola;
// primero es el último. Corre todos los elementos a la derecha.
public class ColaPU implements ICola {
    int[] vector;
    int cantidad; // cantidad de elementos

    public void inicializar() {
        cantidad = 0;
        vector = new int[100];
    }

    public void acolar(int x) {
        for(int i = cantidad - 1; i >= 0; i--) {
            vector[i + 1] = vector[i];
        }
        vector[0] = x;
        cantidad++;
    }

    public void desacolar() {
        cantidad--;
    }

    public int primero() {
        return vector[cantidad - 1];
    }

    public boolean colaVacia() {
        return (cantidad == 0);
    }
}
