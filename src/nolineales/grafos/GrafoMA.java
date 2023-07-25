package nolineales.grafos;

import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class GrafoMA implements GrafoTDA {
    static int n = 100;
    int[][] mAdy; // matriz de adyacencia
    int[] etiqs; // vector para mapeo de valores a índice
    int cantNodos;

    public void inicializarGrafo() {
        mAdy = new int[n][n];
        etiqs = new int[n];

        cantNodos = 0;
    }

    public void agregarVertice(int v) {
        etiqs[cantNodos] = v; // guardamos el valor del vértice a donde apunta nuestro cont.
        for (int i = 0; i <= cantNodos; i++)
        {
            mAdy[cantNodos][i] = 0; // por cada columna seteamos un 0 en la fila.
            mAdy[i][cantNodos] = 0; // por cada fila seteamos un 0 en la columna (cantNods)
        }
        cantNodos++;
    }

    public void eliminarVertice(int v) {
        int ind = vert2indice(v); // obtenemos el índnice del vértice a eliminar
        for (int i = 0; i < cantNodos; i++) {
            mAdy[i][ind] = mAdy[i][cantNodos - 1]; // reemp. col x última col.
            mAdy[ind][i] = mAdy[cantNodos - 1][i]; // reemp. fila x ultima fila.
        }
        etiqs[ind] = etiqs[cantNodos - 1];
        cantNodos--;
    }

    public void agregarArista(int v1, int v2, int p) {
        int origen = vert2indice(v1); // obtenemos la fila
        int destino = vert2indice(v2); // obtenemos la columna
        mAdy[origen][destino] = p;
    }

    public void eliminarArista(int v1, int v2) {
        int origen = vert2indice(v1); // obtenemos la fila
        int destino = vert2indice(v2); // obtenemos la columna
        mAdy[origen][destino] = 0;
    }

    public int pesoArista(int v1, int v2) {
        int origen = vert2indice(v1); // obtenemos la fila
        int destino = vert2indice(v2); // obtenemos la columna
        return mAdy[origen][destino];
    }

    public IConjunto vertices() {
        IConjunto v = new Conjunto();
        v.inicializar();

        for (int i = 0; i < cantNodos; i++) {
            v.agregar(etiqs[i]);
        }
        return v;
    }

    public boolean existeArista(int v1, int v2) {
        return (pesoArista(v1, v2) != 0);
    }

    private int vert2indice(int v) {
        int i = cantNodos - 1; // corremos el puntero a literalmente el último elemento.
        while (i >= 0 && etiqs[i] != v)
            i--;
        return i; // si no está, retorna -1.
    }
}
