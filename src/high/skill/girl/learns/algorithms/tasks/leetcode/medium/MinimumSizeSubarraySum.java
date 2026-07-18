package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан массив положительных целых чисел nums и положительное целое число target.
Верните подмассив минимальной длины, сумма элементов которого больше или равна target.
Если такого подмассива не существует, верните 0.

Example 1:
    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
    Input: target = 4, nums = [1,4,4]
    Output: 1

Example 3:
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0

сложность по памяти O(1)
сложность по времени O(n)
 */

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3, 3})); // 2
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 0
        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8})); // 2
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int subArrayLength = nums.length + 1; // кладем изначально невозможный ответ

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) { // если мы расдвинули окно сверх нужной суммы, начинаем сжимать
                subArrayLength = Math.min(subArrayLength, right - left + 1); // для каждой итерации проверяем, может нашли меньший подмассив
                sum -= nums[left];
                left++;
            }
        }

        return subArrayLength == nums.length + 1 ? 0 : subArrayLength; // если невозможный вариант не перезаписался, значит мы не нашли подходящий подмассив
    }
}
