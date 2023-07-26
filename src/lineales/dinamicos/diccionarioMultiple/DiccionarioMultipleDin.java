package lineales.dinamicos.diccionarioMultiple;

import lineales.especificacion.DiccionarioMultipleTDA;
import lineales.especificacion.IConjunto;
import lineales.estaticos.conjuntos.implementacion.Conjunto;

public class DiccionarioMultipleDin implements DiccionarioMultipleTDA {
    private class NodoClave {
        int clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    private class NodoValor {
        int valor;
        NodoValor sigValor;
    }
    private NodoClave origen;

    public void inicializar() {
        origen = null;
    }
    private NodoClave clave2NodoClave(int clave){
        NodoClave aux = origen;
        while(aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave nc = clave2NodoClave(clave);
        if(nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        NodoValor aux = nc.valores;
        while(aux != null && aux.valor != valor){
            aux = aux.sigValor;
        }
        if(aux == null){
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
    }
    private void eliminarValorEnNodo(NodoClave nodo, int valor){
        if(nodo.valores != null){
            if(nodo.valores.valor == valor){
                nodo.valores = nodo.valores.sigValor;
            }else{
                NodoValor aux = nodo.valores;
                while(aux.sigValor != null && aux.sigValor.valor != valor){
                    aux = aux.sigValor;
                }
                if(aux.sigValor != null){
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }
    @Override
    public void eliminar(int clave) {
        if(origen != null){
            if(origen.clave == clave){
                origen = origen.sigClave;
            }else{
                NodoClave aux = origen;
                while(aux.sigClave != null && aux.sigClave.clave != clave){
                    aux = aux.sigClave;
                }
                if(aux.sigClave != null){
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        if(origen != null){
            if(origen.clave == clave){
                eliminarValorEnNodo(origen, valor);
                if(origen.valores == null){
                    origen = origen.sigClave;
                }
            }else{
                NodoClave aux = origen;
                while(aux.sigClave != null && aux.sigClave.clave != clave){
                    aux = aux.sigClave;
                }
                if(aux.sigClave != null){
                    eliminarValorEnNodo(aux.sigClave, valor);
                    if(aux.sigClave.valores == null){
                        aux.sigClave = aux.sigClave.sigClave;
                    }
                }
            }
        }
    }

    @Override
    public IConjunto recuperar(int clave) {
        NodoClave nc = clave2NodoClave(clave);
        IConjunto c = new Conjunto();
        c.inicializar();
        if(nc != null){
            NodoValor aux = nc.valores;
            while(aux != null){
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    @Override
    public IConjunto claves() {
        IConjunto c = new Conjunto();
        c.inicializar();
        NodoClave aux = origen;
        while(aux != null){
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}
