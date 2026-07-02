package high.skill.girl.learns.data_structure.hash_table.map;

public class HashMap<K, V> {

    private Node<K, V>[] table;
    private int size;

    public HashMap() {
        this.table = new Node[16];
    }

    public V put(K key, V value) {
        int bucketIndex = getBucketIndex(key.hashCode()); // при вычислении индекса бакета могут возникать коллизии
        var currentNode = table[bucketIndex]; // нашли нужный бакет

        while (currentNode != null) {
            if (currentNode.key.equals(key)) { // в бакете уже есть добавляемый ключ
                V oldValue = currentNode.value; // перезаписываем value (оптимальнее, чем мусорить и создавать новую ноду)
                currentNode.value = value;
                return oldValue; // возвращаем старое значение как в оригинальной реализации JDK
            }
            if (currentNode.next == null) { // прошли весь список, ключа нет - добавляем
                currentNode.next = new Node<>(key, value);
                size++; // не забываем увеличивать размер
                return null; // создали новую ноду, старого значения нет
            }
            currentNode = currentNode.next;
        }

        table[bucketIndex] = new Node<>(key, value); // если в бакете не было элементов - создаем, увеличиваем размер
        size++;
        return null;
    }

    public V get(K key) {
        Node<K, V> node = findNodeByKey(key);
        return node != null ? node.value : null;
    }

    public boolean containsKey(K key) {
        Node<K, V> node = findNodeByKey(key);
        return node != null;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> currentNode : table) {
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    public V remove(K key) { // на значение не смотрим
        int bucketIndex = getBucketIndex(key.hashCode());

        Node<K, V> prevNode = null;
        Node<K, V> currentNode = table[bucketIndex];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[bucketIndex] = currentNode.next;
                    size--;
                    return currentNode.value;
                }
                prevNode.next = currentNode.next;
                size--;
                return currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public boolean remove(K key, V value) { // для удаления требуется совпадение и ключа, и значения
        int bucketIndex = getBucketIndex(key.hashCode());

        Node<K, V> prevNode = null;
        Node<K, V> currentNode = table[bucketIndex];

        while (currentNode != null) {
            if (currentNode.key.equals(key) && currentNode.value.equals(value)) {
                if (prevNode == null) {
                    table[bucketIndex] = currentNode.next;
                    size--;
                    return true;
                }
                prevNode.next = currentNode.next;
                size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    private int getBucketIndex(int hashCode) {
        return Math.abs(hashCode) % table.length;
    }

    private Node<K, V> findNodeByKey(K key) {
        int bucketIndex = getBucketIndex(key.hashCode()); // если ключ null - будет NPE на вычислении хэша
        var currentNode = table[bucketIndex];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node<K, V> node : table) {
            sb.append("[");
            if (node != null) {
                sb.append(node.key);
                sb.append(", ");
                sb.append(node.value);
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();

    }
}
