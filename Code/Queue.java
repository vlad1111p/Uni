import java.util.*;



public interface Queue<T> {
    /** Fuegt ein Element hinten in die Warteschlange an.
    * Wirft eine QueueFullException, wenn die Warteschlange voll ist und
    * eine ElementNullException, wenn der Parameter e null ist. */
    void add(T e) throws QueueFullException, ElementNullException;

    /** Gibt das erste Element in der Warteschlange zurueck und entfernt es aus der
    * Warteschlange. 
    * Wirft eine QueueEmptyException, wenn die Warteschlange leer ist. */
    T remove() throws QueueEmptyException;

    /** Gibt das erste Element in der Warteschlange zurueck.
    * Wirft eine QueueEmptyException, wenn die Warteschlange leer ist. */
    T element() throws QueueEmptyException;

    /** Testet, ob die Warteschlange leer ist. */
    boolean isEmpty();
}





