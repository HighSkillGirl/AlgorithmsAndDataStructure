package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
Example 2:
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4

сложность по памяти: O(k)
сложность по времени: O(n log k)

похожа на KthLargestElementInStream (easy)
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 4, 6, 5}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(findKthLargest(new int[]{-1, 2, 0}, 2)); // 0
    }

    private static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i : nums) {
            if (queue.size() < k)
                queue.offer(i);
            else if (i > queue.peek()) {
                queue.poll();
                queue.offer(i);
            }

        }

        return queue.peek();
    }
}
