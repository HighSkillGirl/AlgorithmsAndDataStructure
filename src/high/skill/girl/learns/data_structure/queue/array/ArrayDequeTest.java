package high.skill.girl.learns.data_structure.queue.array;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        System.out.println(deque.offerLast('A'));
        System.out.println(deque.offerLast('B'));
        System.out.println(deque.offerLast('C'));
        System.out.println(deque.offerLast('D'));
        System.out.println(deque.offerLast('E'));
        System.out.println(deque.offerLast('F'));
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.offerLast('T'));
        System.out.println(deque.peekLast());
    }
}
