/*  STUDENT: NGUEGNI DE KUETE SERENA */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueue3<E extends LabelledPoint> implements PriorityQueueIF<E> {
    private PriorityQueue<E> queue;

    public PriorityQueue3(int capacity) {
        queue = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
    }

   
    public PriorityQueue3(ArrayList<E> array, int capacity){
        this(capacity);
        queue.addAll(array);
    }

     public boolean offer(E e) {
        return queue.offer(e);
    }

    public E poll() {
        return queue.poll();
    }

    public E peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}