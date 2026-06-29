package high.skill.girl.learns.data_structure.hash_table.set;

public class HashSet<T> {

    private Node<T>[] table;
    private int size;

    public HashSet() {
        this.table = new Node[16];
    }

    public void add(T value) {
        int hashCode = value.hashCode();
        int bucketIndex = getBucketIndex(hashCode);

        Node<T> currentNodeInBucket = table[bucketIndex];

        if (currentNodeInBucket == null) {
            table[bucketIndex] = new Node<>(value);
            size++;
            return;
        }

        while (currentNodeInBucket != null) {
            if (currentNodeInBucket.value.equals(value)) // fail fast -> нашел вышел
                return;

            if (currentNodeInBucket.next == null)
                break;

            currentNodeInBucket = currentNodeInBucket.next;
        }

        currentNodeInBucket.next = new Node<>(value);
        size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node<T> node : table) {
            Node<T> curNode = node;
            while (curNode != null) {
                sb.append(curNode.value).append(", ");
                curNode = curNode.next;
            }
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        return sb.toString();
    }

    private int getBucketIndex(int hashCode) {
        return Math.abs(hashCode) % table.length;
    }
}
