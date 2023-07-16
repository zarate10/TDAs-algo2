package lineales.especificacion;

public interface ICola {
    void inicializar();
    void acolar(int x);
    void desacolar();
    int primero();
    boolean colaVacia();
}
