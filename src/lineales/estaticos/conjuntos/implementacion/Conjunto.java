package lineales.estaticos.conjuntos.implementacion;

import lineales.especificacion.IConjunto;

public class Conjunto implements IConjunto {
    private int[] a;
    private int cant;

    public void inicializar() {
        a = new int[100];
        cant = 0;
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            a[cant] = x;
            cant++;
        }
    }

    public int elegir() {
        return a[cant - 1];
    }

    public boolean conjuntoVacio() {
        return cant == 0;
    }

    public void sacar(int x) {
        int i = 0;
        while (i < cant && a[i] != x)
        {
            i++;
        }
        if(i < cant)
        {
            a[i] = a[cant - 1];
            cant--;
        }
    }

    public boolean pertenece(int x) {
        int i =0;
        while (i < cant && a[i] != x)
        {
            i++;
        }
        return (i < cant);
    }
}
