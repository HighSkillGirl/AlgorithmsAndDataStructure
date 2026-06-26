package high.skill.girl.learns.algorithms.tasks.leetcode;

/*
Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
Сложите два числа и верните сумму в виде связанного списка.
Вы можете предположить, что два числа не содержат ведущих нулей, кроме самого числа 0.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

!!! CARRY PATTERN: складываем за 1 итерацию оба узла, единицы записываем, десятки переносим
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);

        ListNode ll1 = new ListNode();
        ListNode current = ll1;
        for (int i = 0; i < 7; i++) {
            current.val = 9;
            if (i != 6) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        ListNode ll2 = new ListNode();
        current = ll2;
        for (int i = 0; i < 4; i++) {
            current.val = 9;
            if (i != 3) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        addTwoNumbersV2(ll1, ll2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String l1SumLiteral = String.valueOf(l1.val);
        String l2SumLiteral = String.valueOf(l2.val);

        ListNode currentNode1 = l1.next;

        while (currentNode1 != null) {
            int value = currentNode1.val;
            l1SumLiteral = value + l1SumLiteral;
            currentNode1 = currentNode1.next;
        }

        ListNode currentNode2 = l2.next;

        while (currentNode2 != null) {
            int value = currentNode2.val;
            l2SumLiteral = value + l2SumLiteral;
            currentNode2 = currentNode2.next;
        }

        int result = Integer.parseInt(l1SumLiteral) + Integer.parseInt(l2SumLiteral);
        String[] splitted = String.valueOf(result).split("");

        ListNode head = new ListNode();
        ListNode current = head;

        for (int i = splitted.length - 1; i >= 0; i--) {
            current.val = Integer.parseInt(splitted[i]); // 7
            if (i != 0) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        return head;
    }

    private static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        int units = 0;

        ListNode head = new ListNode();
        ListNode current = head;

        while (l1 != null || l2 != null || carry > 0) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            units = sum % 10;

            current.val = units;
            sum = 0;

            if (l1 != null || l2 != null || carry > 0) {
                current.next = new ListNode();
                current = current.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
