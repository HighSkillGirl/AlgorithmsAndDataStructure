package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Вам дан массив целых чисел «камни», где stones[i] — вес i-го камня.
Мы играем в игру с камнями. На каждом ходу мы выбираем два самых тяжелых камня и сталкиваем их друг с другом.
Предположим, что два самых тяжелых камня имеют веса x и y, причем x <= y. Результат этого столкновения:
    Если x == y, оба камня уничтожаются
    Если x != y, камень весом x уничтожается, а камень весом y приобретает новый вес y - x
В конце игры остается не более одного камня.
Верните вес последнего оставшегося камня. Если камней не осталось, верните 0.

Example 1:
    Input: stones = [2,7,4,1,8,1]
    Output: 1
    Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
    Input: stones = [1]
    Output: 1

сложность по времени: O(n log n)
сложность по памяти: O(n)
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1})); // 1
        System.out.println(lastStoneWeight(new int[]{1})); // 1
        System.out.println(lastStoneWeight(new int[]{2, 2})); // 0
    }

    private static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : stones) { // n итераций * O(log n) каждая для очереди
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();

            if (x != y)
                queue.offer(y - x);
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
