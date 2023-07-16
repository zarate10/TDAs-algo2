package lineales.estaticos.diccionario.implementacion;

import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;
import lineales.especificacion.IDiccionario;

public class Diccionario implements IDiccionario {
    class Elemento {
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    public void inicializar() {
        elementos = new Elemento[100];
        cant = 0;
    }

    public void agregar(int clave, int valor) {
        int pos = clave2Ind(clave);
        if (pos == -1)
        {
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    private int clave2Ind(int clave) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave)
            i--;
        return i;
    }

    public int recuperar(int clave) {
        int pos = clave2Ind(clave);
        return elementos[pos].valor;
    }

    public void eliminar(int clave) {
        int pos = clave2Ind(clave);
        if (pos != -1)
        {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public IConjunto claves() {
        IConjunto c = new Conjunto();
        c.inicializar();
        for (int i = 0; i < cant; i++)
        {
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
