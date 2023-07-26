package lineales.especificacion;

public interface DiccionarioMultipleTDA {
    void inicializar();
    void agregar(int clave, int valor);
    void eliminar(int clave);
    void eliminarValor(int clave, int valor);
    IConjunto recuperar(int clave);
    IConjunto claves();
}
