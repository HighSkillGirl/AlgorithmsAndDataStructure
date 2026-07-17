package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

сложность по памяти O(n) - сет хранит только окно
сложность по времени O(n) - правый указатель проходит только 1 раз строку, левый в худшем случае тоже
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring(" ")); // 1
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("au")); // 2
        System.out.println(lengthOfLongestSubstring("abcandefed")); // 7
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int leftIndex = 0;
        Set<Character> set = new HashSet<>();

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char c = s.charAt(rightIndex);

            while(set.contains(c)) { // вся суть задачи в этом цикле while: мы не просто удаляем элемент из множества, мы идем последовательно, чтобы левая граница встала корректно
                set.remove(s.charAt(leftIndex));
                leftIndex++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1); // из-за того, что работаем с индексами -> +1
        }

        return maxLength;
    }
}
