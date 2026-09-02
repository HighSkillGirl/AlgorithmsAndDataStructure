package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Вы работаете в приемной комиссии университета и вам необходимо в режиме реального времени отслеживать k-й наивысший балл
по результатам тестов абитуриентов. Это помогает динамически определять проходные баллы для собеседований и поступления
по мере того, как новые абитуриенты предоставляют свои результаты.

Вам поручено реализовать класс, который для заданного целого числа k поддерживает поток результатов тестов и непрерывно
возвращает k-й наивысший балл после того, как был отправлен новый результат. Более конкретно, мы ищем k-й наивысший балл
в отсортированном списке всех результатов.

Реализуйте класс KthLargest:
    KthLargest(int k, int[] nums) Инициализирует объект целым числом k и потоком результатов тестов nums.
    int add(int val) Добавляет новый балл теста val в поток и возвращает элемент, представляющий k-й наибольший элемент в пуле результатов тестов на данный момент.

сложность по памяти
сложность по времени: O(n log n) для конструктора, O(log k) для add()
сложность по памяти: O(log k) для конструктора, O(1) для add()
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
        System.out.println("--------------------------------");
        KthLargest kthLargest2 = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest2.add(-1));   // return -1
        System.out.println(kthLargest2.add(1));   // return 0
        System.out.println(kthLargest2.add(-2));  // return 0
        System.out.println(kthLargest2.add(-4));   // return 0
        System.out.println(kthLargest2.add(3));   // return 1
        System.out.println("--------------------------------");
        KthLargest kthLargest3 = new KthLargest(3, new int[]{5, -1});
        System.out.println(kthLargest3.add(2));   // return -1
        System.out.println(kthLargest3.add(1));   // return 1
        System.out.println(kthLargest3.add(-1));  // return 1
        System.out.println(kthLargest3.add(3));   // return 2
        System.out.println(kthLargest3.add(4));   // return 3
    }
}

class KthLargest {

    int k;
    Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int i : nums) {
            queue.offer(i);
            if (queue.size() > k)
                queue.poll();
        }
    }

    public int add(int val) {
        if (queue.size() < k)
            queue.offer(val);
        else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }

        return queue.peek();
    }
}
