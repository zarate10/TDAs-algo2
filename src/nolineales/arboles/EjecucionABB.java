package nolineales.arboles;
import nolineales.arboles.especificacion.TDAABB;
import nolineales.arboles.implementacion.ABB;

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
            if ((!arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz() == nodo) || (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz() == nodo))
                return arbol;
            else if (nodo < arbol.Raiz())
                return padreNodoDado(arbol.HijoIzq(), nodo);
            else
                return padreNodoDado(arbol.HijoDer(), nodo);
        }
        return arbol;
    }

    public boolean esABB(TDAABB arbol)
    {
        if (arbol.ArbolVacio())
            return true;

        if (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz() > arbol.Raiz() || !arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz() < arbol.Raiz())
            return false;

        return (esABB(arbol.HijoDer()) && esABB(arbol.HijoIzq()));
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


        //System.out.println(altura(a));

        // TDAABB raizHijoDer = hijoDerechoNodo(a, 23);

        // System.out.println(padreNodoDado(a, 42).Raiz());
        System.out.println(esABB(a));
    }
}
