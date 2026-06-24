package high.skill.girl.learns.data_structure.list.linked.singly;

public class SinglyLinkedListTest {
    public static void main(String[] args) {

        LinkedList<Integer> mySinglyLinkedList = new LinkedList<>();

        mySinglyLinkedList.addFirst(5);
        mySinglyLinkedList.addFirst(6);
        mySinglyLinkedList.addFirst(7);
        System.out.println("add first: " + mySinglyLinkedList);

        mySinglyLinkedList.removeValue(5);
        mySinglyLinkedList.removeValue(6);
        mySinglyLinkedList.removeValue(7);
        System.out.println("remove all values: " + mySinglyLinkedList);

        mySinglyLinkedList.addLast(1);
        mySinglyLinkedList.addLast(2);
        mySinglyLinkedList.addLast(3);
        System.out.println("add into the end: " + mySinglyLinkedList);

        mySinglyLinkedList.removeIndex(0);
        System.out.println("remove by index 0: " + mySinglyLinkedList);

        System.out.println("list contains 3: " + mySinglyLinkedList.contains(3));
        System.out.println("list contains 2: " + mySinglyLinkedList.contains(2));

        System.out.println("get value by index 0: " + mySinglyLinkedList.get(0));

        System.out.println("size: " + mySinglyLinkedList.size());
    }
}
