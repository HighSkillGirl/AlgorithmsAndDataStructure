package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Даны две двоичные строки a и b. Верните их сумму в виде двоичной строки.
a и b состоят только из символов '0' или '1'.
Каждая строка не содержит ведущих нулей, за исключением самого нуля.

!!! CARRY PATTERN: складываем за 1 итерацию символы из обеих строк, единицу перносим
        по памяти сложность O(n) из-за StringBuilder
        по времени сложность O(n)
 */

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(sum("11", "1"));
    }

    private static String sum(String a, String b) {
        int sum = 0;
        int carry = 0;
        int units = 0;
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (a_index >= 0 || b_index >= 0 || carry > 0) {
            sum = carry;

            if (a_index >= 0)
                sum += a.charAt(a_index) - '0';
            if (b_index >= 0)
                sum += b.charAt(b_index) - '0';

            carry = sum / 2;
            units = sum % 2;

            a_index--;
            b_index--;

            sb.append(units); // O(1), но память растет пропорционально входным данным
        }

        return sb.reverse().toString();
    }
}
