package high.skill.girl.learns.data_structure.list;

import high.skill.girl.learns.data_structure.list.linked.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(7);
        myLinkedList.addLast(2);

        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList);
    }
}
