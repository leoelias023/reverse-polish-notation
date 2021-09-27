package calculadora.util;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {

    /** Itens que fazem parte da pilha */
    private List<T> items = new ArrayList<T>();

    public void push(T obj) {
        items.add(obj);
    }

    public T pop() {
        int lastIndex = items.size() - 1;
        T last = items.get(lastIndex);
        items.remove(lastIndex);
        return last;
    } 

    public int length() {
        return items.size();
    }
}
