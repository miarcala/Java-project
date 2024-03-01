import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PriorityQueue1<E extends LabelledPoint> implements PriorityQueueIF<E> {
    private List<E> array; 

    public PriorityQueue1(int capacity) {
        this.array = new ArrayList<>(capacity);
    }

    public PriorityQueue1(ArrayList<E> newArray, int capacity) {
        this(capacity);
        for (E e : newArray) {
            offer(e);
        }
    }

    public boolean offer(E e) {
        array.add(e);
        Collections.sort(array);
        return true;  // Assuming the offer is always successful
    }

    public E poll() {
        if (isEmpty()){
            return null;
        }
        else{
          return array.remove(0);
        }
    }

    public E peek() {
        if (isEmpty()){
            return null;
        }
        else{
          return array.get(0);
        }
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

}
