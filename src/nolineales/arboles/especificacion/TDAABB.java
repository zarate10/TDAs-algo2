package nolineales.arboles.especificacion;

public interface TDAABB {
    void InicializarArbol();
    int Raiz();
    TDAABB HijoIzq ();
    TDAABB HijoDer();
    boolean ArbolVacio();
    void AgregarElem(int x);
    void EliminarElem(int x);
}
