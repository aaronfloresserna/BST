package BSTs;

public interface IBST<T extends Comparable>{
    void insert(T empl);

    boolean exist(int id);

    T get(int id);
    
    boolean hasChildren();
    
    boolean isEmpty();

    void inOrder();

    void preOrder();

    void postOrder();

    void remove(int id);

}