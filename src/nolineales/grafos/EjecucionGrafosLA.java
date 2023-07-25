package nolineales.grafos;

import lineales.dinamicos.pilas.implementacion.PilaDin;
import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class EjecucionGrafosLA {

    private void buscarAdyacenteDoble(GrafoTDA grafo, int vertice)
    {
        IConjunto verticesRecorribles = new Conjunto();
        verticesRecorribles.inicializar();

        IConjunto vertices = grafo.vertices();

        IConjunto adyacentesDobles = new Conjunto();
        adyacentesDobles.inicializar();

        while(!vertices.conjuntoVacio())
        {
            int vertice2 = vertices.elegir();
            if (grafo.existeArista(vertice, vertice2)) {
                verticesRecorribles.agregar(vertice2);
            }
            vertices.sacar(vertice2);
        }

        while (!verticesRecorribles.conjuntoVacio())
        {
            IConjunto verticesAux = grafo.vertices();
            int vRecorrible = verticesRecorribles.elegir();
            while (!verticesAux.conjuntoVacio())
            {
                int vAux = verticesAux.elegir();
                if(grafo.existeArista(vRecorrible, vAux))
                {
                    adyacentesDobles.agregar(vAux);
                }
                verticesAux.sacar(vAux);
            }
            verticesRecorribles.sacar(vRecorrible);
        }

        while (!adyacentesDobles.conjuntoVacio()) {
            int adyacenteDoble = adyacentesDobles.elegir();
            System.out.println(adyacenteDoble);
            adyacentesDobles.sacar(adyacenteDoble);
        }
    }

    private void calcularCostoAristasSalientes(GrafoTDA grafo, int vertice)
    {
        IConjunto vertices = grafo.vertices();

        int peso = 0;
        boolean primero = false;


        while (!vertices.conjuntoVacio())
        {
            int vertice2 = vertices.elegir();

            if (grafo.existeArista(vertice, vertice2) && !primero) {
                peso = grafo.pesoArista(vertice, vertice2);
                primero = true;
            }

            if (grafo.existeArista(vertice, vertice2) && grafo.pesoArista(vertice, vertice2) > peso) {

                peso = grafo.pesoArista(vertice, vertice2);
            }
            vertices.sacar(vertice2);
        }

        System.out.println(peso);
    }

    private IConjunto predecesoresDeVertice(GrafoTDA grafo, int vertice)
    {
        IConjunto vertices = grafo.vertices();
        IConjunto predecesores = new Conjunto();
        predecesores.inicializar();

        while (!vertices.conjuntoVacio())
        {
            int verticePredecesor = vertices.elegir();
            if(grafo.existeArista(verticePredecesor, vertice))
            {
                predecesores.agregar(verticePredecesor);
            }
            vertices.sacar(verticePredecesor);
        }
        return predecesores;
    }

    public EjecucionGrafosLA()
    {
        GrafoTDA g1 = new GrafoLA();
        g1.inicializarGrafo();

        g1.agregarVertice(1);
        g1.agregarVertice(2);
        g1.agregarVertice(3);
        g1.agregarVertice(4);
        g1.agregarVertice(5);

        g1.agregarArista(1, 2, 3);
        g1.agregarArista(2, 3, 6);
        g1.agregarArista(2, 4, 1);
        g1.agregarArista(2, 5, 5);
        g1.agregarArista(4, 5, 7);
        g1.agregarArista(3, 5, 6);

        GrafoTDA graf = new GrafoLA();
        graf.inicializarGrafo();

        graf.agregarVertice(5);
        graf.agregarVertice(13);
        graf.agregarVertice(4);
        graf.agregarVertice(7);
        graf.agregarVertice(8);
        graf.agregarVertice(9);

        graf.agregarArista(5, 13, 10);
        graf.agregarArista(5, 7, 22);
        graf.agregarArista(5, 4, 33);
        graf.agregarArista(4, 8, 50);
        graf.agregarArista(8, 7, 99);
        graf.agregarArista(7, 9, 5000);

        buscarAdyacenteDoble(g1, 2);
        calcularCostoAristasSalientes(graf, 5);

        IConjunto predecesoresG1 =predecesoresDeVertice(g1, 5);

        while(!predecesoresG1.conjuntoVacio())
        {
            int predecesor = predecesoresG1.elegir();
            System.out.println(predecesor);
            predecesoresG1.sacar(predecesor);
        }
    }
}
