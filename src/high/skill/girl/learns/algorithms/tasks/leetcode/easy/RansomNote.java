package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Даны две строки: ransomNote и magazine. Верните true, если ransomNote можно построить, используя буквы из magazine, и false в противном случае.
Каждая буква из magazine может быть использована в ransomNote только один раз.

V1:
    память O(n)
    время O(n) + O(n) -> O(n)

V2:
    память O(1)
    время O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("abc", "aabc")); // true
        System.out.println(canConstruct("ab", "aa")); // false
        System.out.println(canConstruct("aab", "ab")); // false
        System.out.println("-------------------------");
        System.out.println(canConstructV2("abc", "aabc")); // true
        System.out.println(canConstructV2("ab", "aa")); // false
        System.out.println(canConstructV2("aab", "ab")); // false
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>(); // буква - количество раз повторяется

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.get(c);
            if (count == null)
                return false;
            count--;
            if (count == 0)
                map.remove(c);
            else
                map.put(c, count);
        }
        return true;
    }

    private static boolean canConstructV2(String ransomNote, String magazine) {
        int[] count = new int[26]; // 26 english letters only

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            count[c - 'a']--;
            if (count[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
