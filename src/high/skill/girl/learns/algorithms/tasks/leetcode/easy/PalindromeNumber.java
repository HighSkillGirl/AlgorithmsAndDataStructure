package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Follow up: Could you solve it without converting the integer to a string?

Сложность по времени
    V1 - O(n)
    V2 - O(n) -> формально так как входящее число типа int, сложность можно считать константной. Но я записываю линейную, так как строка зависит от входных данных
Сложность по памяти
    V1 - O(n)
    V2 - O(1)
 */

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromeV1(121)); // true
        System.out.println(isPalindromeV1(-121)); // false
        System.out.println(isPalindromeV1(10)); // false
        System.out.println(isPalindromeV1(11)); // true
        System.out.println("----------------------------------------");
        System.out.println(isPalindromeV2(121)); // true
        System.out.println(isPalindromeV2(-121)); // false
        System.out.println(isPalindromeV2(10)); // false
        System.out.println(isPalindromeV2(11)); // true
        System.out.println(isPalindromeV2(240)); // false
        System.out.println(isPalindromeV2(222)); // true
        System.out.println(isPalindromeV2(-1)); // false
        System.out.println(isPalindromeV2(0)); // true
    }

    private static boolean isPalindromeV1(int x) {
            String s = String.valueOf(x);

            int left = 0;
            int right = s.length() - 1;
            while (left < s.length() && right > 0) {
                if (s.charAt(left) != s.charAt(right))
                    return false;
                left++;
                right--;
            }

            return true;
    }

    private static boolean isPalindromeV2(int x) { // элегантное решение, где проход по одной цифре происходит засчет деления
        int copy = x;
        int result = 0;

        while (copy > 0) {
            int remaining = copy % 10;
            result = result * 10 + remaining;
            copy /= 10;
        }

        return x == result;
    }
}
