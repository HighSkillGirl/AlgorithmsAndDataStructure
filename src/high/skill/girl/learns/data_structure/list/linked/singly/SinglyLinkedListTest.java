package high.skill.girl.learns.data_structure.list.linked.singly;

public class SinglyLinkedListTest {
    public static void main(String[] args) {

        LinkedList<Integer> mySinglyLinkedList = new LinkedList<>();

        mySinglyLinkedList.addFirst(5);
        mySinglyLinkedList.addFirst(6);
        mySinglyLinkedList.addFirst(7);

        mySinglyLinkedList.addLast(2);

        System.out.println(mySinglyLinkedList);

        System.out.println("list contains 3: " + mySinglyLinkedList.contains(3));
        System.out.println("list contains 2: " + mySinglyLinkedList.contains(2));

        System.out.println("get value by index 3: " + mySinglyLinkedList.get(3));

        System.out.println("size: " + mySinglyLinkedList.size());
    }
}
