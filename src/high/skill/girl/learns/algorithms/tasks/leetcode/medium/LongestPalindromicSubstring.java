package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
Example 2:
    Input: s = "cbbd"
    Output: "bb"

s consist of only digits and English letters.

Суть решения: каждый символ потенциально может быть центром палиндрома. Проходим два раза, потому что строка может быть четной и нечетной
Также эту задачу можно решить через динамиеческое программирование и через паттерн Manacher, но они пока сильно сложные для обучения

сложность по памяти: O(1)
сложность по времени: O(n^2), потому что расширение происходит для каждого символа
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba")); // abcba
        System.out.println(longestPalindrome("bab")); // bab
        System.out.println(longestPalindrome("baba")); // bab, aba
        System.out.println(longestPalindrome("babad")); // bab, aba
        System.out.println(longestPalindrome("cbbd")); // bb
        System.out.println(longestPalindrome("barbabd")); // bab
    }

    private static String longestPalindrome(String s) {
        int bestLeftIndex = 0;
        int bestRightIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int leftIndex = i;
            int rightIndex = i;
            while (leftIndex >= 0 && rightIndex < s.length()) {
                if (s.charAt(leftIndex) != s.charAt(rightIndex))
                    break;

                if (bestRightIndex - bestLeftIndex < rightIndex - leftIndex) {
                    bestLeftIndex = leftIndex;
                    bestRightIndex = rightIndex;
                }

                leftIndex--;
                rightIndex++;
            }

            leftIndex = i;
            rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length()) {
                if (s.charAt(leftIndex) != s.charAt(rightIndex))
                    break;

                if (bestRightIndex - bestLeftIndex < rightIndex - leftIndex) {
                    bestLeftIndex = leftIndex;
                    bestRightIndex = rightIndex;
                }

                leftIndex--;
                rightIndex++;
            }
        }

        return s.substring(bestLeftIndex, bestRightIndex + 1);
    }
}
