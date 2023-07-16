package lineales.dinamicos.diccionarios.implementacion;

import lineales.dinamicos.conjuntos.implementacion.ConjuntoDin;
import lineales.especificacion.IConjunto;
import lineales.especificacion.IDiccionario;

public class DiccionarioDin implements IDiccionario {
    class NodoClave {
        int clave;
        int valor;
        NodoClave sigClave;
    }

    NodoClave origen;

    public void inicializar() {
        origen = null;
    }

    public void agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null)
        {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = valor;
    }

    private NodoClave Clave2NodoClave(int clave){
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave)
            aux = aux.sigClave;
        return aux;
    }

    public void eliminar(int clave) {
        if (origen != null)
        {
            if (origen.clave == clave)
            {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave)
                {
                    aux = aux.sigClave;
                }
                if(aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    public int recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }

    public IConjunto claves() {
        IConjunto c = new ConjuntoDin();
        c.inicializar();
        NodoClave aux = origen;
        while (aux != null)
        {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}
