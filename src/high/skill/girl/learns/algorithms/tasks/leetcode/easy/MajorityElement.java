package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Дан массив nums размером n. Верните элемент большинства.
Элемент большинства — это элемент, который встречается более ⌊n / 2⌋ раз. Можно предположить, что элемент большинства всегда присутствует в массиве (очень важно!!!)

Example 1:
    Input: nums = [3,2,3]
    Output: 3

V1: чистое решение через HashMap
    память O(n)
    время O(n)

V2: решение без мапы через алгоритм голосования Бойера-Море
    память O(1)
    время O(n)

 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElementV1(new int[]{3, 2, 3}));
        System.out.println(majorityElementV1(new int[]{2,2,1,1,1,2,2}));
        System.out.println("----------------------------");
        System.out.println(majorityElementV2(new int[]{3, 2, 3}));
        System.out.println(majorityElementV2(new int[]{2,2,1,1,1,2,2}));
    }

    private static int majorityElementV1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                count = 1;
            } else {
                count += 1;
            }
            map.put(i, count);
        }

        int maxValue = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    private static int majorityElementV2(int[] nums) { // алгоритм Бойера-Море
        int candidate = 0;
        int count = 0;

        for (int num : nums) { // взаимное исключение неодинаковых элементов
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num)
                count++;
            else
                count--;
        }

        return candidate;
    }
}
