package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Даны две строки s и p. Верните массив всех начальных индексов анаграмм строки p в строке s. Вы можете вернуть ответ в любом порядке.

Example 1:
    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".

Решение такое же как в PermutationInString

сложность по памяти O(n) -> список может содержать всю строку ("aaaaaaaaaa", "aa")
сложность по времени O(n)

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(findAnagrams("abab", "ab")); // [0, 1, 2]
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int[] sourceArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            sourceArray[c - 'a']++;
        }

        int[] targetArray = new int[26];
        List<Integer> list = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            targetArray[rightChar - 'a']++;

            if (right - left + 1> p.length()) {
                char leftChar = s.charAt(left);
                targetArray[leftChar - 'a']--;
                left++;
            }

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(sourceArray, targetArray)) {
                    list.add(left);
                }
            }
        }

        return list;
    }
}
