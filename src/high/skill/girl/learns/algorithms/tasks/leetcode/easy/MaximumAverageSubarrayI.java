package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Вам дан целочисленный массив nums, состоящий из n элементов, и целое число k.
Найдите непрерывный подмассив длиной k, имеющий максимальное среднее значение, и верните это значение. Принимаются ответы с погрешностью вычислений менее 10⁻⁵.

Example 1:
    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75


сложность по памяти O(1)
сложность по времени O(n)
 */

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverageV1(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(findMaxAverageV1(new int[]{5}, 1)); // 5
        System.out.println(findMaxAverageV1(new int[]{-1}, 1)); // -1
        System.out.println("----------------------------------------");
        System.out.println(findMaxAverageV2(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(findMaxAverageV2(new int[]{5}, 1)); // 5
        System.out.println(findMaxAverageV2(new int[]{-1}, 1)); // -1
    }

    private static double findMaxAverageV1(int[] nums, int k) {
        int rightIndex = 0;
        int leftIndex = 0;
        long sum = 0;
        double max = Double.NEGATIVE_INFINITY; // меньше любого числа

        while (rightIndex <= nums.length) {

            if (rightIndex - leftIndex == k) {
                max = Math.max(max, (double) sum / k);

                if (rightIndex == nums.length)
                    break;

                sum -= nums[leftIndex];
                leftIndex++;

                sum+= nums[rightIndex];
                rightIndex++;
                continue;
            }
            sum += nums[rightIndex];
            rightIndex++;
        }

        return max;
    }

    private static double findMaxAverageV2(int[] nums, int k) {
        int leftIndex = 0;
        int rightIndex = 0;
        long sum = 0;
        double max = Double.NEGATIVE_INFINITY;

        for (; rightIndex < nums.length; rightIndex++) {
            sum += nums[rightIndex];

            if (rightIndex - leftIndex == k - 1) {
                max = Math.max(max, (double) sum / k);

                sum -= nums[leftIndex];
                leftIndex++;
            }
        }

        return max;
    }
}
