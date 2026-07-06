package high.skill.girl.learns.data_structure.queue.array;

public class ArrayDeque<T> {

    private Object[] array;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        this.array = new Object[5];
    }

    public ArrayDeque(Object[] array) {
        this.array = array;
    }

    public int size() {
        return this.size;
    }
//
//    public boolean offerFirst(T value) {
//
//    }
//
    public boolean offerLast(T value) {
        if (array.length == size) // проверка на переполнение
            return false;

        array[tail] = value;

        tail = (tail + 1) % array.length; // закольцовываем хвост
        size++;
        return true;
    }

//    @SuppressWarnings(value = "unchecked")
//    public T pollFirst() {
//        T value = (T) array[head];
//        array[head] = null;
//        head++;
//        size--;
//        return value;
//    }

    @SuppressWarnings(value = "unchecked")
    public T pollLast() {
        tail = (tail - 1 + array.length) % array.length; // поддерживаем кольцо
        T value = (T) array[tail];
        array[tail] = null;
        size--;
        return value;
    }

//    @SuppressWarnings(value = "unchecked")
//    public T peekFirst() {
//        return (T) array[head];
//    }

    @SuppressWarnings(value = "unchecked")
    public T peekLast() {
        int lastIndex = (tail - 1 + array.length) % array.length;
        return (T) array[lastIndex];
    }
}
