package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Даны два неотрицательных целых числа num1 и num2, представленные в виде строк. Верните произведение num1 и num2, также представленное в виде строк.
Примечание: Не используйте встроенные библиотеки BigInteger и не преобразуйте входные данные непосредственно в целые числа.

Input: num1 = "123", num2 = "456"
Output: "56088"

память O(n), точнее O(s1 + s2)
время O(n^2), точнее O(s1 * s2)

 */

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("0", "0"));
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("999", "999"));
        System.out.println(multiply("10", "12"));
    }

    private static String multiply(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0"))
            return "0";

        int[] digitRankArray = new int[s1.length() + s2.length()]; // создаем массив конкретной длины

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int a = s1.charAt(i) - '0';
                int b = s2.charAt(j) - '0';

                int unitsIndex = i + j + 1; // очень элегантное решение для сдвига границы, куда мы складываем умножение
                int tensIndex = i + j;

                digitRankArray[unitsIndex] += a * b; // складываем в ячейку результат умножения
                digitRankArray[tensIndex] += digitRankArray[unitsIndex] / 10; // в следующую (предыдущую) - десятки от умножения
                digitRankArray[unitsIndex] %= 10; // перезаписываем единицы
            }
        }

        int leadZeroCount = 0;
        while (leadZeroCount < digitRankArray.length && digitRankArray[leadZeroCount] == 0) {
            leadZeroCount++; // считаем пустые нули в начале массива
        }

        StringBuilder sb = new StringBuilder();

        for (int i = leadZeroCount; i < digitRankArray.length; i++) {
            sb.append(digitRankArray[i]); // заполняем строку результата
        }

        return sb.toString();
    }
}
