package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Дан массив целых чисел nums и целое число k. Верните true, если в массиве есть два различных индекса i и j таких, что nums[i] == nums[j] и abs(i - j) <= k.

Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true

паттерн Sliding Window отвечает за границы, структура HashSet - за содержимое

сложность по памяти O(k) -> k = входной параметр, храним только нужное количество элементов
сложность по времени O(n)

 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println("true: " + containsNearbyDuplicateV1(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println("true: " + containsNearbyDuplicateV1(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println("false: " + containsNearbyDuplicateV1(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
        System.out.println("true: " + containsNearbyDuplicateV1(new int[]{99, 99}, 2)); // true
        System.out.println("true: " + containsNearbyDuplicateV1(new int[]{1, 2, 2, 4}, 1)); // true
        System.out.println("false: " + containsNearbyDuplicateV1(new int[]{1, 2, 3, 1, 1, 2, 3}, 0)); // false
        System.out.println("false: " + containsNearbyDuplicateV1(new int[]{1, 2, 3, 4, 1}, 3)); // false
        System.out.println("true: " + containsNearbyDuplicateV1(new int[]{2, 2}, 3)); // true
        System.out.println("----------------------------------------");
        System.out.println("true: " + containsNearbyDuplicateV2(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println("true: " + containsNearbyDuplicateV2(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println("false: " + containsNearbyDuplicateV2(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
        System.out.println("true: " + containsNearbyDuplicateV2(new int[]{99, 99}, 2)); // true
        System.out.println("true: " + containsNearbyDuplicateV2(new int[]{1, 2, 2, 4}, 1)); // true
        System.out.println("false: " + containsNearbyDuplicateV2(new int[]{1, 2, 3, 1, 1, 2, 3}, 0)); // false
        System.out.println("false: " + containsNearbyDuplicateV2(new int[]{1, 2, 3, 4, 1}, 3)); // false
        System.out.println("true: " + containsNearbyDuplicateV2(new int[]{2, 2}, 3)); // true
    }

    private static boolean containsNearbyDuplicateV1(int[] nums, int k) {
        if (k == 0)
            return false;

        int leftIndex = 0;
        int rightIndex = k;

        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i]) && rightIndex - leftIndex <= k)
                return true;
            else
                set.add(nums[i]);

            if (i == rightIndex) {
                set.remove(nums[leftIndex]);
                leftIndex++;
                rightIndex++;
            }
        }

        return false;
    }

    private static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        int leftIndex = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i - leftIndex > k) { // сначала проверяем, что не вышли за рамки окна
                set.remove(nums[leftIndex]);
                leftIndex++;
            }

            if (set.contains(nums[i])) // когда окно валидно, работаем со сравнением
                return true;

            set.add(nums[i]); // окно валидно, сравнение не получилось - добавляем в выборку
        }

        return false;
    }
}
