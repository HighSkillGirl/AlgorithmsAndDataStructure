package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан несортированный массив целых чисел nums. Верните длину последовательности самых длинных последовательных элементов.
Необходимо написать алгоритм, работающий за время O(n).

Example 1:
    Input: nums = [1,0,1,2]
    Output: 3

Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

память O(n) - в худшем случае в сет попадают все значения массива
время O(n) - в худшем случае мы два раза пройдемся по сету (n + n)
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2})); // 3
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println(longestConsecutive(new int[]{0, -1})); // 2
        System.out.println(longestConsecutive(new int[]{1, 2, 6, 7, 8})); // 3
        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6})); // 7
        System.out.println(longestConsecutive(new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7})); // 4
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int tempCounter = 0;
        int result = 0;

        for (int i : set) {
            if (!set.contains(i - 1)) { // ищем точку начала последовательности
                int j = i;
                while (set.contains(j)) { // нашли, идем считать
                    tempCounter++;
                    j++;
                }
                result = Math.max(tempCounter, result); // сохраняем промежуточный результат
                tempCounter = 0;
            }
        }

        return result;
    }
}
