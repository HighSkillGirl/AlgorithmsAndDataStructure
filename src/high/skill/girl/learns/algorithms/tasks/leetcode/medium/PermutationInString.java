package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Даны две строки s1 и s2. Верните true, если s2 содержит перестановку s1, или false в противном случае.
Иными словами, верните true, если одна из перестановок s1 является подстрокой s2.

Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false

В решении используется два массива - один эталонный, второй фактический. Сравниваем "окно" с sourceArray

сложность по памяти O(1)
сложность по времени O(n)
 */

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaoooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("hello", "ooolleoooleh")); // false
        System.out.println(checkInclusion("adc", "dcda")); // true
        System.out.println("---------------------");
        System.out.println(checkInclusionV2("ab", "eidbaoooo")); // true
        System.out.println(checkInclusionV2("ab", "eidboaoo")); // false
        System.out.println(checkInclusionV2("hello", "ooolleoooleh")); // false
        System.out.println(checkInclusionV2("adc", "dcda")); // true
    }

    private static boolean checkInclusion(String s1, String s2) {
        int[] sourceArray = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            sourceArray[c - 'a']++;
        }

        int[] targetArray = new int[26];
        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            targetArray[c - 'a']++;

            if (Arrays.equals(sourceArray, targetArray))
                return true;

            if (right - left + 1 == s1.length()) {
                c = s2.charAt(left);
                targetArray[c - 'a']--;
                left++;
            }
        }

        return false;
    }

    private static boolean checkInclusionV2(String s1, String s2) { // более логичный порядок сравнений
        int[] sourceArray = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            sourceArray[c - 'a']++;
        }

        int[] targetArray = new int[26];
        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            targetArray[c - 'a']++;

            if (right - left + 1 > s1.length()) {
                c = s2.charAt(left);
                targetArray[c - 'a']--;
                left++;
            }

            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(sourceArray, targetArray))
                    return true;
            }
        }

        return false;
    }
}
