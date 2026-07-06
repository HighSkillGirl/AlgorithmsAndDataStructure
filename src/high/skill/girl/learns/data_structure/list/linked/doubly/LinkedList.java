package high.skill.girl.learns.data_structure.list.linked.doubly;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail; // TODO: обновить реализацию под наличие хвоста

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.next == null) {
                currentNode.next = newNode;
                newNode.prev = currentNode;
                return;
            } else {
                currentNode = currentNode.next;
            }
        }
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
            if (head != null) {
                head.prev = null;
            }
        } else {
            prevNode.next = currentNode.next;
            if (currentNode.next != null) {
                currentNode.next.prev = prevNode;
            }
        }
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
                        return;
                    }
                } else {
                    prevNode.next = currentNode.next;
                    if (currentNode.next != null) {
                        currentNode.next.prev = prevNode;
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
        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
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
