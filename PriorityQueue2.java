/*  STUDENT: NGUEGNI DE KUETE SERENA */

import java.util.ArrayList;
import java.util.List;


public class PriorityQueue2<E extends LabelledPoint> implements PriorityQueueIF<E> {
    private List<E> queue; 
    public PriorityQueue2(int capacity) {
        queue = new ArrayList<>(capacity);
    }
    public PriorityQueue2(ArrayList<E> elements, int capacity){
        this(capacity);
        for (E e : elements){
            offer(e);
        }
    }
    public boolean offer(E e) {
        queue.add(e);
        int taille = queue.size() - 1;
        upHeap(taille);
        return true;
    }
    public E poll() {
        if (isEmpty()){
            return null;
        }
        E e = queue.get(0);
        E dernierElement = queue.remove(queue.size() - 1);
        queue.set(0, dernierElement);
        dowHeap(0);
        return e;
    }
    public E peek() {
        if (isEmpty()){
            return null;
        }
        else{
            return queue.get(0);
        }
    }
    public int size() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    private void upHeap(int position) {
        while (position > 0) {
            int parentposition = (position - 1) / 2;
            if (queue.get(position).getKey() <= queue.get(parentposition).getKey()) {
                break;
            }
            swap(position, parentposition);
            position = parentposition;
        }
    }
    private void dowHeap(int position) {
        int leftChild = 2 * position + 1;
        int rightChild = 2 * position + 2;
        int positionPlusGrand = position;

        if (leftChild < queue.size() && queue.get(leftChild).getKey() > queue.get(positionPlusGrand).getKey()) {
            positionPlusGrand = leftChild;
        }
        if (rightChild < queue.size() && queue.get(rightChild).getKey() > queue.get(positionPlusGrand).getKey()) {
            positionPlusGrand = rightChild;
        }

        if (positionPlusGrand != position) {
            swap(position, positionPlusGrand);
            dowHeap(positionPlusGrand);
        }
    }
    private void swap(int i, int j) {
        E e = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, e);
    }
}