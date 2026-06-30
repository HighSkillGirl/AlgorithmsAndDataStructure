package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Напишите алгоритм для определения, является ли число n счастливым.
Счастливое число определяется следующим процессом:
    Начиная с любого положительного целого числа, замените число суммой квадратов его цифр.
    Повторяйте процесс до тех пор, пока число не станет равным 1 (на этом значении оно и останется), или пока не замкнется в бесконечном цикле, не включающем 1.
    Числа, для которых этот процесс заканчивается на 1, являются счастливыми.
    Верните true, если n — счастливое число, и false, если нет.

Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

Example 2:
    Input: n = 2
    Output: false

Коварная оценка сложности:
время O(1) и память O(1), потому что количество итераций ограничены размером int
но фактически если иметь для расчетов конкретное число:
    память O(k - while-итерации, где растет set)
    время O(d - количество цифр в числе * k)
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(10));
    }

    private static boolean isHappy(int n) {
        if (n <= 0)
            return false;

        Set<Integer> set = new HashSet<>();
        String s = String.valueOf(n);

        while (true) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - '0';
                int multiply = a * a;
                sum += multiply;
            }

            if (sum == 1)
                return true;

            if (!set.add(sum))
                return false;

            s = String.valueOf(sum);
        }
    }
}
