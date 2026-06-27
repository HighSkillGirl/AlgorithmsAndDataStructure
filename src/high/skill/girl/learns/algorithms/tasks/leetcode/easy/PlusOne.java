package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Вам дано большое целое число, представленное в виде целочисленного массива digits, где каждый digits[i] — это i-я цифра числа.
Цифры упорядочены слева направо от старшей к младшей. Большое целое число не содержит ведущих нулей.
Увеличьте большое целое число на единицу и верните полученный массив digits.

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Можно решить через carry pattern (не очень оптимально, только как тренировочная):
    память O(1) без переполнения / O(n) с переполнением
    время O(n)

Без carry pattern:
    память O(n)
    время O(n)

Opti:
    память O(n) в худшем случае, обычно O(1)
    время O(n) в худшем случае, обычно O(1)
 */

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOneCarry(new int[]{9, 8})));
        System.out.println(Arrays.toString(plusOneNoCarry(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOneNoCarry(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOneNoCarry(new int[]{9, 9})));
        System.out.println(Arrays.toString(plusOneOptimum(new int[]{1, 2, 3})));
    }

    private static int[] plusOneCarry(int[] digits) {
        int sum = 0;
        int carry = 1;
        int units = 0;

        int index = digits.length - 1; // считаем с конца - с меньшего разряда

        while (index >= 0 || carry > 0) {
            sum += digits[index] + carry;
            carry = sum / 10;
            units = sum % 10;

            if (carry == 1 && index == 0) { // в случае переполнения надо просто записать единицу, копировать массив нет необходимости
                int[] biggerArray = new int[digits.length + 1];
                biggerArray[0] = carry;
                return biggerArray;
            } else {
                digits[index] = units;
            }

            index--;
            sum = 0;
        }

        return digits;
    }

    private static int[] plusOneNoCarry(int[] digits) {
        int index = digits.length - 1;
        digits[digits.length - 1] += 1;

        while (index >= 0) {
            if (digits[index] / 10 == 1) {
                if (index == 0) {
                    int[] biggerArray = new int[digits.length + 1];
                    biggerArray[0] = 1;
                    return biggerArray;
                } else {
                    digits[index] = 0;
                    digits[index - 1] += 1;
                }
            }
            index--;
        }

        return digits;
    }

    private static int[] plusOneOptimum(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}


