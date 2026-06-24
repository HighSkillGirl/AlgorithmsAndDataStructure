package high.skill.girl.learns.data_structure.list.linked.doubly;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> myDoublyLinkedList = new LinkedList<>();

        myDoublyLinkedList.addFirst(5);
        myDoublyLinkedList.addFirst(3);
        myDoublyLinkedList.addFirst(1);

        myDoublyLinkedList.addLast(2);

        System.out.println(myDoublyLinkedList);

        System.out.println("list contains 2: " + myDoublyLinkedList.contains(2));
        System.out.println("list contains 0: " + myDoublyLinkedList.contains(0));

        System.out.println("get by index 3: " + myDoublyLinkedList.get(3));

        System.out.println(myDoublyLinkedList.size());

    }
}
