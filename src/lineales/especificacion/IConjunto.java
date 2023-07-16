package lineales.especificacion;

public interface IConjunto {
    void inicializar();
    void agregar(int x);
    int elegir();
    boolean conjuntoVacio();
    void sacar(int x);
    boolean pertenece(int x);
}
