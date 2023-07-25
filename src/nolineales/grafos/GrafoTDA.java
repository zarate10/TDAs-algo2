package nolineales.grafos;

import lineales.especificacion.IConjunto;

public interface GrafoTDA {
    void inicializarGrafo();
    void agregarVertice(int v);
    void eliminarVertice(int v);
    void agregarArista(int v1, int v2, int p);
    void eliminarArista(int v1, int v2);
    int pesoArista(int v1, int v2);
    IConjunto vertices();
    boolean existeArista(int v1, int v2);
}
