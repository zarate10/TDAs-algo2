package nolineales.grafos;

import lineales.dinamicos.pilas.implementacion.PilaDin;
import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

import javax.swing.*;

public class EjecucionGrafosLA {

    private void mostrarConjunto(IConjunto vertices)
    {
        while(!vertices.conjuntoVacio())
        {
            int vertice = vertices.elegir();
            System.out.println(vertice);
            vertices.sacar(vertice);
        }
    }

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


    private IConjunto obtenerVerticesAislados(GrafoTDA grafo)
    {
        IConjunto vertices = grafo.vertices();
        IConjunto aislados = new Conjunto();
        aislados.inicializar();

        while(!vertices.conjuntoVacio())
        {
            boolean grafoConectado = false;
            int vertice1 = vertices.elegir();
            IConjunto aux = grafo.vertices();


            while(!aux.conjuntoVacio())
            {
                int vertice2 = aux.elegir();

                if (grafo.existeArista(vertice1, vertice2) || grafo.existeArista(vertice2, vertice1))
                {
                    grafoConectado = true;
                }

                aux.sacar(vertice2);
            }

            if (!grafoConectado)
                aislados.agregar(vertice1);

            vertices.sacar(vertice1);
        }

        return aislados;
    }

    public IConjunto puenteEntreVertices(GrafoTDA grafo, int vertice1, int vertice2)
    {
        IConjunto vertices = grafo.vertices();
        IConjunto verticesPuente = new Conjunto();
        verticesPuente.inicializar();

        while(!vertices.conjuntoVacio())
        {
            int verticeP = vertices.elegir();
            if (grafo.existeArista(vertice1, verticeP) && grafo.existeArista(verticeP, vertice2) || grafo.existeArista(vertice2, verticeP) && grafo.existeArista(verticeP, vertice1))
            {
                verticesPuente.agregar(verticeP);
            }
            vertices.sacar(verticeP);
        }
        return verticesPuente;
    }

    // grado de un vértice (nodo) == (arisitas salientes) - (aristas entrantes)
    public int gradoVertice(GrafoTDA grafo, int vertice)
    {
        IConjunto vertices = grafo.vertices();
        int aristasEntrantes = 0;
        int aristasSalientes = 0;

        while (!vertices.conjuntoVacio())
        {
            int vertice2 = vertices.elegir();

            if (grafo.existeArista(vertice, vertice2))
                aristasSalientes++;

            if (grafo.existeArista(vertice2, vertice))
                aristasEntrantes++;

            vertices.sacar(vertice2);
        }

       return (aristasSalientes - aristasEntrantes);
    }


    public GrafoTDA convertirDirigidoNodirigido(GrafoTDA grafo)
    {
        IConjunto vertices = grafo.vertices();

        // {4, 1, 7, 6}
        while (!vertices.conjuntoVacio())
        {
            IConjunto aux = grafo.vertices();
            int vertice1 = vertices.elegir();

            while (!aux.conjuntoVacio())
            {
                int vertice2 = aux.elegir();
                if (grafo.existeArista(vertice1, vertice2))
                {
                    grafo.agregarArista(vertice2, vertice1, grafo.pesoArista(vertice1, vertice2));
                }
                aux.sacar(vertice2);
            }
            vertices.sacar(vertice1);
        }

        return grafo;
    }

    /*
    public static int[][] grafoAMatriz(GrafoTDA g){
        int tamanio = obtenerTamanio(g);
        int[][] matriz = new int[tamanio][tamanio];
        IConjunto c = g.vertices();
        int elemento = 0;
        while(!c.conjuntoVacio()){
            IConjunto interno = g.vertices();
            int contador = 0;
            int valor = c.elegir();
            c.sacar(valor);
            while(!interno.conjuntoVacio()){
                int valor2 = interno.elegir();
                matriz[elemento][contador] = g.pesoArista(valor, valor2);
                contador++;
                interno.sacar(valor2);
            }
            elemento++;
        }
        return matriz;
    }
    */

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

        // buscarAdyacenteDoble(g1, 2);
        // calcularCostoAristasSalientes(graf, 5);

        //mostrarConjunto(predecesoresDeVertice(g1, 5));

        // obtenerVerticesAislados(g1);

        // mostrarConjunto(obtenerVerticesAislados(g1));
        // mostrarConjunto(puenteEntreVertices(g1, 1, 3));

        // System.out.println(gradoVertice(g1, 2));
    }
}
