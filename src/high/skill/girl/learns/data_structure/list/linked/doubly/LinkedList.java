package high.skill.girl.learns.data_structure.list.linked.doubly;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (tail == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void removeIndex(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> currentNode = getCurrentNodeOrThrowException(index);
        Node<T> next = currentNode.next;
        Node<T> prev = currentNode.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }

        size--;
    }

    public void removeValue(T value) {
        Node<T> prevNode = null;
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                if (prevNode == null) {
                    head = currentNode.next;
                    if (head != null) {
                        head.prev = null;
                        size--;
                        return;
                    }
                } else {
                    prevNode.next = currentNode.next;
                    if (currentNode.next != null) {
                        currentNode.next.prev = prevNode;
                        size--;
                        return;
                    }
                }
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
        return getCurrentNodeOrThrowException(index).value;
    }

    public int size() {
        return this.size;
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

    private Node<T> getCurrentNodeOrThrowException(int index) {
        Node<T> currentNode;
        int half = size / 2;

        if (index < half) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                if (currentNode == null)
                    throw new IndexOutOfBoundsException();
                currentNode = currentNode.next;
            }

        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                if (currentNode == null)
                    throw new IndexOutOfBoundsException();
                currentNode = currentNode.prev;
            }
        }

        if (currentNode == null)
            throw new IndexOutOfBoundsException();

        return currentNode;
    }
}
