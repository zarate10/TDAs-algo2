package nolineales.grafos;

import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class GrafoLA implements GrafoTDA {
    class NodoGrafo {
        int vertice;
        NodoArista arista;
        NodoGrafo sigNodo;
    }

    class NodoArista {
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    NodoGrafo origen;

    public void inicializarGrafo() {
        origen = null;
    }

    public void agregarVertice(int v) {
        // el vertice se inserta en el inicio de la lista de nodos.
        NodoGrafo aux = new NodoGrafo();
        aux.vertice = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    public void eliminarVertice(int v) {
        if (origen.vertice ==  v) // por si es el primer nodo
            origen = origen.sigNodo;

        NodoGrafo aux = origen;

        while (aux != null) {
            // busca todas las aristas que peguen al vértice a remover y tmb las elimina.
            this.eliminarAristaNodo(aux, v);
            // se valida si el siguiente nodo del nodo donde estamos parados
            // tiene como vértice el mismo valor "v" pasado por params.
            if (aux.sigNodo != null && aux.sigNodo.vertice == v) {
                // si es así, asignamos el siguiente del actual (nodo donde estamos parados)
                // al siguiente del siguiente.
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    public void agregarArista(int v1, int v2, int peso) {
        // buscamos los vértices dentro del grafo.
        NodoGrafo n1 = vert2nodo(v1);
        NodoGrafo n2 = vert2nodo(v2);
        // inicializamos la arista y le asignamos los nuevos atributos.
        NodoArista nuevaArista = new NodoArista();
        nuevaArista.etiqueta = peso;
        nuevaArista.nodoDestino = n2;
        // sigArista de la nueva arista va a ser la primera arista del vértice.
        nuevaArista.sigArista = n1.arista;
        // nueva arista va a quedar como primera arista del vértice.
        n1.arista = nuevaArista;
    }

    public void eliminarArista(int v1, int v2) {
        NodoGrafo n1 = vert2nodo(v1);
        eliminarAristaNodo(n1, v2);
    }

    public int pesoArista(int v1, int v2) {
        NodoGrafo n1 = vert2nodo(v1);

        NodoArista aux = n1.arista;
        while (aux.nodoDestino.vertice != v2) {
            aux = aux.sigArista;
        }

        return aux.etiqueta;
    }

    public IConjunto vertices() {
        IConjunto c = new Conjunto();
        c.inicializar();

        NodoGrafo aux = origen;
        while (aux != null) {
            c.agregar(aux.vertice);
            aux = aux.sigNodo;
        }
        return c;
    }

    public boolean existeArista(int v1, int v2) {
        NodoGrafo n1 = vert2nodo(v1);

        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.vertice != v2) {
            aux = aux.sigArista;
        }

        return aux != null;
    }

    private void eliminarAristaNodo(NodoGrafo nodo, int v) {
        // busca las aristas que apunten a v y las elimina.
        NodoArista aux = nodo.arista;

        if (aux != null) {
            if (aux.nodoDestino.vertice == v) // chequeamos el priemro
                nodo.arista = aux.sigArista;
		else {
            // recorremos mientras nodoDestino sea diferente al vértice que estamos buscando.
                while (aux.sigArista != null && aux.sigArista.nodoDestino.vertice != v) {
                    aux = aux.sigArista;
                }
                // si lo encontramos, asignamos al siguiente de donde estamos parados al
                // siguiente del siguiente.
                if (aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    private NodoGrafo vert2nodo(int v) {
        NodoGrafo aux = origen;
        while (aux != null && aux.vertice != v)
            aux = aux.sigNodo;
        return aux;
    }
}
