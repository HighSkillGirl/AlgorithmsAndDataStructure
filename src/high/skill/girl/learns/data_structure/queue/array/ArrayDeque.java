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

    public boolean offerFirst(T value) {
        if (array.length == size)
            return false;

        head = (head - 1 + array.length) % array.length; // сначала двигаем голову назад
        array[head] = value;
        size++;
        return true;
    }

    public boolean offerLast(T value) {
        if (array.length == size) // проверка на переполнение
            return false;

        array[tail] = value; // сначала сохраняем, потому что хвост хранит пустой индекс после последнего занятого индекса
        tail = (tail + 1) % array.length; // закольцовываем
        size++;
        return true;
    }

    @SuppressWarnings(value = "unchecked")
    public T pollFirst() {
        if (size == 0)
            return null;

        T value = (T) array[head];
        array[head] = null;
        head = (head + array.length) % array.length;
        size--;
        return value;
    }

    @SuppressWarnings(value = "unchecked")
    public T pollLast() {
        if (size == 0)
            return null;

        tail = (tail - 1 + array.length) % array.length; // поддерживаем кольцо
        T value = (T) array[tail];
        array[tail] = null;
        size--;
        return value;
    }

    @SuppressWarnings(value = "unchecked")
    public T peekFirst() {
        return (T) array[head];
    }

    @SuppressWarnings(value = "unchecked")
    public T peekLast() {
        int lastIndex = (tail - 1 + array.length) % array.length;
        return (T) array[lastIndex];
    }
}
