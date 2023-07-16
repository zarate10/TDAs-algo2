package lineales.especificacion;

public interface IDiccionario {
    void inicializar();
    void agregar(int clave, int valor);
    void eliminar(int clave);
    int recuperar(int clave);
    IConjunto claves();
}
