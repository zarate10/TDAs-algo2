package lineales.estaticos.pilas.implementacion;

import lineales.especificacion.IPila;

public class PilaTF implements IPila {
    int[] vector;
    int indice;

    public void inicializar() { // O(1)
        indice = 0;
        vector = new int[100];
    }

    public void apilar(int x) { // O(1)
        vector[indice] = x;
        indice++;
    }

    public void desapilar() { // O(1)
        indice--;
    }

    public int tope() { // O(1)
        return vector[indice - 1];
    }

    public boolean pilaVacia() { // O(1)
        return (indice == 0);
    }
}
