package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique, and you may return the result in any order.

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

память O(n)
время O(n)

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionV1(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersectionV1(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println();
        System.out.println(Arrays.toString(intersectionV2(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersectionV2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        System.out.println();
        System.out.println(Arrays.toString(intersectionV3(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersectionV3(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    private static int[] intersectionV1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
           set2.add(i);
        }

        set1.retainAll(set2);

        int index = 0;
        int[] result = new int[set1.size()];
        for (int i : set1) {
            result[index++] = i;
        }

        return result;
    }

    private static int[] intersectionV2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i))
                intersectionSet.add(i);
        }

        int index = 0;
        int[] result = new int[intersectionSet.size()];
        for (int i : intersectionSet) {
            result[index++] = i;
        }

        return result;
    }

    private static int[] intersectionV3(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.remove(i))
                intersectionSet.add(i);
        }

        int index = 0;
        int[] result = new int[intersectionSet.size()];
        for (int i : intersectionSet) {
            result[index++] = i;
        }

        return result;
    }
}
