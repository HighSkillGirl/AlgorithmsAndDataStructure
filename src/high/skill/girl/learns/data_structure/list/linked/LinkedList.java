package high.skill.girl.learns.data_structure.list.linked;

public class LinkedList<T> {

    private Node<T> head;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> currentNode = head; // идем с головы, ищем конец
        while (currentNode.next != null) {
            currentNode = currentNode.next; // перешагнули, текущая нода - это "следующая"
        }

        currentNode.next = newNode;
    }

    public boolean contains(T value) {
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public T get(int index) {
        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();

            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    public int size() {
        Node<T> currentNode = head;
        int size = 1;

        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }

        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.value);
            if (currentNode.next != null) {
                sb.append(" -> ");
            }
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
