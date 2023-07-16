package lineales.especificacion;

public interface IColaPrioridad {
    void inicializar();
    void acolarPrioridad(int x, int prioridad);
    void desacolar();
    int primero();
    int prioridad();
    boolean colaVacia();
}
