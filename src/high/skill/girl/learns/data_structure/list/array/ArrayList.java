package high.skill.girl.learns.data_structure.list.array;

public class ArrayList<T> {

    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[3];
    }

    public int size() {
        return this.size;
    }

    public void addLast(T value) {
        ensureCapacity();

        this.array[this.size] = value;
        this.size++;
    }

    public void addFirst(T value) {
        ensureCapacity();

        for (int i = this.size; i > 0; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[0] = value;
        this.size++;
    }

    public void add(int index, T value) {
        checkIndex(index);
        ensureCapacity();

        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[index] = value;
        this.size++;
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.size - 1] = null;
        this.size--;
    }

    public boolean contains(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) this.array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.size; i++) {
            sb.append(this.array[i]);
            sb.append(", ");
        }

        return sb.replace(sb.length() - 2, sb.length(), "]").toString();
    }

    private void ensureCapacity() {
        if (this.size == this.array.length) {
            Object[] arrayForCopy = new Object[this.size * 2];

            for (int i = 0; i < this.size; i++) { // можно заменить на System.arraycopy()
                arrayForCopy[i] = this.array[i];
            }

            this.array = arrayForCopy;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
    }
}
