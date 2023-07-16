package lineales.especificacion;

public interface IPila {
    void inicializar();
    void apilar(int x);
    void desapilar();
    int tope();
    boolean pilaVacia();
}
