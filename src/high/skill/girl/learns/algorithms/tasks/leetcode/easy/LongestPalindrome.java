package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
    Input: s = "a"
    Output: 1
    Explanation: The longest palindrome that can be built is "a", whose length is 1.

Constraints:
s consists of lowercase and/or uppercase English letters only.

V1
сложность по памяти - O(n)
сложность по времени - O(n)

V2
сложность по памяти - O(1)
сложность по времени - O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeV1("abccccdd")); // 7
        System.out.println(longestPalindromeV1("a")); // 1
        System.out.println("----------------------");
        System.out.println(longestPalindromeV2("abccccdd")); // 7
        System.out.println(longestPalindromeV2("a")); // 1
    }

    private static int longestPalindromeV1(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        int resultLength = 0;
        int potentialCentre = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            int balance = value % 2;
            resultLength = resultLength + value - balance;
            potentialCentre += balance;
        }

        if (potentialCentre > 0)
            resultLength++;

        return resultLength;
    }

    private static int longestPalindromeV2(String s) {
        int[] symbolsArray = new int[128]; // all ASCII symbols

        for (int i = 0; i < s.length(); i++) {
            symbolsArray[s.charAt(i)]++;
        }

        int resultLength = 0;
        int potentialCentre = 0;

        for (int i : symbolsArray) {
            int balance = i % 2;
            resultLength = resultLength + i - balance;
            potentialCentre += balance;
        }

        if (potentialCentre > 0)
            resultLength++;

        return resultLength;
    }
}