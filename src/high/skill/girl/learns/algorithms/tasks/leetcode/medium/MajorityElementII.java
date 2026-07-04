package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан целочисленный массив размером n. Найдите все элементы, которые встречаются более ⌊n / 3⌋ раз.

V1:
    память O(n)
    время O(n)

V2:
    память O(1)
    время O(n)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3})); // [3]
        System.out.println("-------------------------------");
        System.out.println(majorityElementV2(new int[]{1,2,3,2,2,1,1})); // [1, 2]
        System.out.println(majorityElementV2(new int[]{3, 2, 3})); // [3]
        System.out.println(majorityElementV2(new int[]{0, 0, 0})); // [0]
        System.out.println(majorityElementV2(new int[]{0,3,4,1,0})); // [0]
        System.out.println(majorityElementV2(new int[]{1,2,1,2,2,3,3,1})); // [2, 1]
        System.out.println(majorityElementV2(new int[]{2,1,1,3,1,4,5,6})); // [1]
    }

    private static List<Integer> majorityElement(int[] nums) {
        int n = nums.length / 3;
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static List<Integer> majorityElementV2(int[] nums) {
        int n = nums.length / 3; // условие гарантирует, что в любых последовательностях будет не более 2х элементов

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i : nums) { // важно написать правильный порядок if-else и чтобы все были подряд, зависимы друг от друга
            if (i == candidate1) { // голосует за такого же как он
                count1++;
            }
            else if (i == candidate2) {
                count2++;
            }
            else if (count1 == 0) { // если голосов нет - записываемся в кандидаты
                candidate1 = i;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = i;
                count2 = 1;
            }
            else { // если число не принадлежит к обоим кандидатам - оно не голосует, что равнозначно голосу против всех
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (int i : nums) { // перепроверяем подходящие кандидатуры под условие
            if (candidate1 == i)
                count1++;
            if (candidate2 == i)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n)
            result.add(candidate1);
        if (candidate1 != candidate2 && count2 > n)
            result.add(candidate2);

        return result;
    }
}
