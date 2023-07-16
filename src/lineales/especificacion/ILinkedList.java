package lineales.especificacion;

public interface ILinkedList {
    void inicializar();
    void add(int x);
    void unshift(int x);
    void remove(int x);
    int pop();
    int size();
    Integer get(int indice);
}
