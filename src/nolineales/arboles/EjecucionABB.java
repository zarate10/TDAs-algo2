package nolineales.arboles;
import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;
import nolineales.arboles.especificacion.TDAABB;
import nolineales.arboles.implementacion.ABB;

import static lineales.estaticos.conjuntos.EjecucionConjunto.printConjunto;
import static lineales.estaticos.conjuntos.EjecucionConjunto.unirConjunto;

public class EjecucionABB {
    public static void preOrder(TDAABB a) {
        if (!a.ArbolVacio())
        {
            System.out.println(a.Raiz());
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }

    public static void inOrder(TDAABB a) {
        if (!a.ArbolVacio())
        {
            inOrder(a.HijoIzq());
            System.out.println(a.Raiz());
            inOrder(a.HijoDer());
        }
    }

    public static void postOrder(TDAABB a) {
        if (!a.ArbolVacio())
        {
            postOrder(a.HijoIzq());
            postOrder(a.HijoDer());
            System.out.println(a.Raiz());
        }
    }

    private static int altura(TDAABB a)
    {
        if((a.ArbolVacio()))
            return -1;

        return Math.max(1 + altura(a.HijoDer()), 1 + altura(a.HijoIzq()));
    }

    public static TDAABB buscarElementosEnABB(TDAABB t, int x) {
        if (t.ArbolVacio()) {
            return null;
        } else if (t.Raiz() == x) {
            return t;
        } else if (t.Raiz() > x) {
            return buscarElementosEnABB(t.HijoIzq(), x);
        } else {
            return buscarElementosEnABB(t.HijoDer(), x);
        }
    }

    public static TDAABB hijoDerechoNodo(TDAABB arbol, int nodo)
    {
        if(!arbol.ArbolVacio())
        {
            if (arbol.Raiz() == nodo)
                return arbol.HijoDer();
            else if (nodo < arbol.Raiz())
                return hijoDerechoNodo(arbol.HijoIzq(), nodo);
            else
                return hijoDerechoNodo(arbol.HijoDer(), nodo);
        }
        return null;
    }

    public TDAABB padreNodoDado(TDAABB arbol, int nodo)
    {
        if(!arbol.ArbolVacio())
        {
            return arbol;
        }

        if ((!arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz() == nodo) || (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz() == nodo))
            return arbol;
        else if (nodo < arbol.Raiz())
            return padreNodoDado(arbol.HijoIzq(), nodo);
        else
            return padreNodoDado(arbol.HijoDer(), nodo);
    }

    public boolean esABB(TDAABB arbol)
    {
        if (arbol.ArbolVacio())
            return true;

        if (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz() > arbol.Raiz() || !arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz() < arbol.Raiz())
            return false;

        return (esABB(arbol.HijoDer()) && esABB(arbol.HijoIzq()));
    }


    public IConjunto paresArbol(TDAABB arbol)
    {
        IConjunto pares = new Conjunto();
        pares.inicializar();

        if (!arbol.ArbolVacio()) {
            // Comprobamos si el valor de la raíz del árbol es par y, si lo es, lo agregamos al conjunto.
            if (arbol.Raiz() % 2 == 0) {
                pares.agregar(arbol.Raiz());
            }

            // Llamamos recursivamente a la función paresArbol para explorar los hijos del árbol.
            // El método arbol.HijoIzq() debería devolver el subárbol izquierdo, y arbol.HijoDer() debería devolver el subárbol derecho.
            unirConjunto(pares, paresArbol(arbol.HijoIzq()));
            unirConjunto(pares, paresArbol(arbol.HijoDer()));
        }

        return pares;
    }

    public IConjunto numerosMayores(TDAABB arbol, int valor)
    {
        IConjunto mayores = new Conjunto();
        mayores.inicializar();

        if (!arbol.ArbolVacio()) {
            if (arbol.Raiz() > valor) {
                mayores.agregar(arbol.Raiz());
            }

            unirConjunto(mayores, numerosMayores(arbol.HijoIzq(), valor));
            unirConjunto(mayores, numerosMayores(arbol.HijoDer(), valor));
        }

        return mayores;
    }

    public int calcularProfundidadNodo(TDAABB arbol, int nodo)
    {
        if (arbol.ArbolVacio())
            return -1;

        if (arbol.Raiz() == nodo)
            return 0;

        if(nodo < arbol.Raiz())
            return 1 + calcularProfundidadNodo(arbol.HijoIzq(), nodo);
        else
            return 1 + calcularProfundidadNodo(arbol.HijoDer(), nodo);
    }

    public IConjunto descendientesNodo(TDAABB arbol, int nodo)
    {
        IConjunto descendientes = new Conjunto();
        descendientes.inicializar();

        if(!arbol.ArbolVacio()) {
            if (nodo < arbol.Raiz())
                return descendientesNodo(arbol.HijoIzq(), nodo);

            if (nodo > arbol.Raiz())
                return descendientesNodo(arbol.HijoDer(), nodo);

            if (arbol.Raiz() == nodo)
            {
                if (!arbol.HijoIzq().ArbolVacio())
                {
                    descendientes.agregar(arbol.HijoIzq().Raiz());
                    unirConjunto(descendientes, descendientesNodo(arbol.HijoIzq(), arbol.HijoIzq().Raiz()));
                }

                if (!arbol.HijoDer().ArbolVacio())
                {
                    descendientes.agregar(arbol.HijoDer().Raiz());
                    unirConjunto(descendientes, descendientesNodo(arbol.HijoDer(), arbol.HijoDer().Raiz()));
                }
            }
        }

        return descendientes;
    }

    public int sizeABB(TDAABB arbol)
    {
        if (arbol.ArbolVacio())
            return 0;

        return (1 + sizeABB(arbol.HijoIzq())) + sizeABB(arbol.HijoDer());
    }

    public int calcularSumaElementosABB(TDAABB arbol)
    {
        int suma = 0;

        if (arbol.ArbolVacio())
            return 0;

        suma += arbol.Raiz();
        return suma + calcularSumaElementosABB(arbol.HijoIzq()) + calcularSumaElementosABB(arbol.HijoDer());
    }

    public EjecucionABB() {
        TDAABB a = new ABB();
        a.InicializarArbol();

        a.AgregarElem(57);
        a.AgregarElem(23);
        a.AgregarElem(42);
        a.AgregarElem(8);
        a.AgregarElem(36);
        a.AgregarElem(37);
        a.AgregarElem(43);

        // System.out.println(altura(a));

        // TDAABB raizHijoDer = hijoDerechoNodo(a, 23);

        // System.out.println(padreNodoDado(a, 42).Raiz());
        // System.out.println(esABB(a));

        // printConjunto(paresArbol(a));
        // printConjunto(numerosMayores(a, 42));
        // System.out.println(calcularProfundidadNodo(a, 43));
        // printConjunto(descendientesNodo(a, 42));
        // System.out.println(sizeABB(a));
        System.out.println(calcularSumaElementosABB(a));
    }
}
