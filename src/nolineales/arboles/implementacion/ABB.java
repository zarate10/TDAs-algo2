package nolineales.arboles.implementacion;

import nolineales.arboles.especificacion.TDAABB;

public class ABB implements TDAABB {
    public class NodoABB {
        int dato;
        TDAABB hijoIzq;
        TDAABB hijoDer;
    }

    NodoABB raiz;

    public void InicializarArbol() {
        raiz = null;
    }

    public int Raiz() {
        return raiz.dato;
    }

    public TDAABB HijoIzq() {
        return raiz.hijoIzq;
    }

    public TDAABB HijoDer() {
        return raiz.hijoDer;
    }

    public boolean ArbolVacio() {
        return raiz == null;
    }

    public void AgregarElem(int x) {
        if (raiz == null)
        {
            raiz = new NodoABB();
            raiz.dato = x;

            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.InicializarArbol();

            raiz.hijoDer = new ABB();
            raiz.hijoDer.InicializarArbol();
        } else if (raiz.dato > x)
            raiz.hijoIzq.AgregarElem(x);
        else
            raiz.hijoDer.AgregarElem(x);
    }

    private int mayor(TDAABB a) {
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    }

    private int menor(TDAABB a) {
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }

    public void EliminarElem(int x) {
        if (raiz != null)
        {
            if (raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
                raiz = null;
            } else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {
                raiz.dato = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.EliminarElem(raiz.dato);
            } else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()) {
                raiz.dato = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElem(raiz.dato);
            } else if (x < raiz.dato) {
                raiz.hijoIzq.EliminarElem(x);
            } else {
                raiz.hijoDer.EliminarElem(x);
            }
        }
    }
}