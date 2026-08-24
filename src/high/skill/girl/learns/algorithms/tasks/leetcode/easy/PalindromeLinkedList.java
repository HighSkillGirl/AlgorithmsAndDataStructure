package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
    Input: head = [1,2,2,1]
    Output: true

Could you do it in O(n) time and O(1) space?

сложность по памяти: O(1)
сложность по времени: O(n)
 */

public class PalindromeLinkedList {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))))); // true
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))))); // true
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2)))); // false
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // нашли середину, пора разворачиваться
        ListNode prev = null;
        ListNode current = slowPointer;
        ListNode next;

        while (current != null) {
            next = current.next; // записали хвост, чтобы не потерять
            current.next = prev; // отрезали
            prev = current; // переместили
            current = next; // взяли следующий ээлемент
        }

        while (prev != null) { // сравниваем
            if (prev.val != head.val)
                return false;

            prev = prev.next;
            head = head.next;
        }


        return true;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}