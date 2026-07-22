package high.skill.girl.learns.algorithms.tasks.leetcode.hard;

/*
Вам дан массив целых чисел nums, и имеется скользящее окно размером k, которое перемещается слева направо по массиву.
В окне отображаются только k чисел. Каждый раз скользящее окно перемещается вправо на одну позицию.
Верните максимальное значение скользящего окна.

Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation:
        Window position                Max
        ---------------               -----
       [1  3  -1] -3  5  3  6  7        3
        1 [3  -1  -3] 5  3  6  7        3
        1  3 [-1  -3  5] 3  6  7        5
        1  3  -1 [-3  5  3] 6  7        5
        1  3  -1  -3 [5  3  6] 7        6
        1  3  -1  -3  5 [3  6  7]       7

Example 2:
    Input: nums = [1], k = 1
    Output: [1]

Замудреная задача, основная суть решения в правильном заполнении и незаполнении очереди

сложность по памяти O(n)
сложность по времени O(n)
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5}, 3))); // [3, 3, 5]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1))); // [1, -1]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{3, 1, 1, 3}, 3))); // [3, 3]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3))); // [3, 3, 2, 5]
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // храним индексы, чтобы проще отсеивать одинаковые значения на грани окна

        int[] result = new int[nums.length - k + 1]; // размер массива заранее можно посчитать
        int index = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right - left + 1 > k) { // этот блок выносится первым -> перебрасывается с предыдущего цикла
                left++;
                if (deque.peekFirst() < left) { // удаляем в случае, если вышли за границу окна
                    deque.pollFirst();
                }
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) { // пакман: съедаем число, если новое больше и очередь не пуста - гарантирует только кандидатов на максимум
                deque.pollLast();
            }

            deque.offerLast(right); // кладем новое число

            if (right - left + 1 == k) { // окно сформировано, забираем из очереди максимум
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}
