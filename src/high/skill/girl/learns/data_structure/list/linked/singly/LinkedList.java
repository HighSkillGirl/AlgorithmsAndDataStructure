package high.skill.girl.learns.data_structure.list.linked.singly;

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

    public void removeIndex(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> prevNode = null;
        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (prevNode == null) {
            head = currentNode.next;
        } else {
            prevNode.next = currentNode.next;
        }
    }

    public void removeValue(T value) {
        Node<T> prevNode = null;
        Node<T> currentNode = head;

        while (currentNode != null) {

            if (currentNode.value.equals(value)) {
                if (prevNode == null) {
                    head = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public boolean contains(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) { // мы уже нашли значение из-за .next, индексация идет позже, поэтому удобно без <=
            if (currentNode == null)
                throw new IndexOutOfBoundsException();
            currentNode = currentNode.next;
        }

        if (currentNode == null)
            throw new IndexOutOfBoundsException();

        return currentNode.value;
    }

    public int size() {
        int size = 0;
        Node<T> currentNode = head;

        while (currentNode != null) {
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
