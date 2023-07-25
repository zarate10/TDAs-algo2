package nolineales.arboles.ABB;

import nolineales.arboles.ABB.especificacion.TDAABB;
import nolineales.arboles.ABB.implementacion.ABB;

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

    public EjecucionABB() {
        TDAABB a = new ABB();
        a.InicializarArbol();

        a.AgregarElem(4);

        System.out.println(altura(a));
    }
}
