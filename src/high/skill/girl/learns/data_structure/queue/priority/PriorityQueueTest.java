package high.skill.girl.learns.data_structure.queue.priority;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(0);
        queue.offer(5);
        queue.offer(6);

        System.out.println(queue);
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
