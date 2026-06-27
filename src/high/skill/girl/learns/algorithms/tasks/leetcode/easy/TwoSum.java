package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/* Дан массив целых чисел nums и целое число target. Верните индексы этих двух чисел так, чтобы их сумма равнялась target.
   Предположим, что для каждого входного значения существует ровно одно решение, и нельзя использовать один и тот же элемент дважды.
   Ответ можно возвращать в любом порядке.

   Классическое решение через двойной массив:
        O(n^2) по времени,
        O(1) по памяти
   Оптимизированное решение через HashMap:
        O(n) по времени
        O(n) по памяти -> в худшем случае требуется положить всю последовательность в HashMap
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 1, 3}, 2)));
        System.out.println(Arrays.toString(twoSumV2(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    private static int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int need;

        for (int i = 0; i < nums.length; i++) {
            need = target - nums[i];

            if (map.containsKey(need)) {
                result[0] = map.get(need);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
}
