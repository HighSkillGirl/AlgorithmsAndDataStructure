package high.skill.girl.learns.data_structure.queue.priority;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<T> {

    private Object[] array;
    private int size;
    private Comparator<T> comparator;

    public PriorityQueue() {
        this.array = new Object[5];
    }

    public PriorityQueue(Comparator<T> comparator) {
        this.array = new Object[5];
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public boolean offer(T value) {
        ensureCapacity();

        array[size] = value;
        size++;

        int childIndex = size - 1;
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;

            if (comparator.compare((T) array[parentIndex], value) <= 0) // выходим, когда минимум на своем месте
                break;

            array[childIndex] = array[parentIndex];
            array[parentIndex] = value;
            childIndex = parentIndex;
        }

        return true;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private void ensureCapacity() {
        if (this.size == this.array.length) {
            Object[] arrayForCopy = new Object[this.size * 2];

            for (int i = 0; i < this.size; i++) {
                arrayForCopy[i] = this.array[i];
            }

            this.array = arrayForCopy;
        }
    }
}
