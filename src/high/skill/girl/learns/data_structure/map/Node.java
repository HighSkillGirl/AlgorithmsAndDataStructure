package high.skill.girl.learns.data_structure.map;

public class Node<K, V> {

    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    public Node (K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }
}
