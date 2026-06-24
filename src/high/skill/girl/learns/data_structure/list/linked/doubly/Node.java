package high.skill.girl.learns.data_structure.list.linked.doubly;

public class Node<T> {
    T value;
    Node<T> prev;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
