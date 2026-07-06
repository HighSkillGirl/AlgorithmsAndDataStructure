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
        System.out.println("get by index 0: " + myDoublyLinkedList.get(0));
        System.out.println("get by index 2: " + myDoublyLinkedList.get(2));
        System.out.println("get by index 1: " + myDoublyLinkedList.get(1));

        System.out.println(myDoublyLinkedList.size());

        myDoublyLinkedList.removeIndex(1);
        myDoublyLinkedList.addFirst(3);
        myDoublyLinkedList.removeIndex(0);
        System.out.println("list after removing value by index 1, 0: " + myDoublyLinkedList);
        myDoublyLinkedList.addFirst(11);
        myDoublyLinkedList.removeIndex(2);
        myDoublyLinkedList.removeIndex(0);
        System.out.println("list after removing all: " + myDoublyLinkedList);
        myDoublyLinkedList.removeIndex(1);

        myDoublyLinkedList.addFirst(5);
        myDoublyLinkedList.addFirst(3);
        myDoublyLinkedList.addFirst(1);

        myDoublyLinkedList.addLast(2);

        myDoublyLinkedList.removeValue(1);
        System.out.println("remove value 1: " + myDoublyLinkedList);
        myDoublyLinkedList.removeValue(5);
        System.out.println("remove value 5: " + myDoublyLinkedList);
        myDoublyLinkedList.removeValue(3);
        myDoublyLinkedList.removeValue(2);
        System.out.println("remove all values: " + myDoublyLinkedList);

    }
}
