package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан целочисленный массив nums и целое число k. Верните k наиболее часто встречающихся элементов. Вы можете вернуть ответ в любом порядке.

Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

Example 2:
    Input: nums = [1], k = 1
    Output: [1]

Example 3:
    Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
    Output: [1,2]

V1:
    память O(n)
    время O(n^2)

Дополнение: временная сложность вашего алгоритма должна быть меньше O(n log n), где n — размер массива.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentV1(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1, 2]
        System.out.println(Arrays.toString(topKFrequentV1(new int[]{1}, 1))); // [1]
    }

    private static int[] topKFrequentV1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        int maxValue = 0;
        int maxKey = 0;
        int[] result = new int[k];

        for (int i = 0; i < k; i++) { // рабочий, но неоптимальный поиск максимума
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxValue < entry.getValue()) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            result[i] = maxKey;
            map.remove(maxKey);
            maxValue = 0;
        }

        return result;
    }
}
