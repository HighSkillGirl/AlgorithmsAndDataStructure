package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Даны две строки s и t. Верните true, если t является анаграммой строки s, и false в противном случае.
Дополнительный вопрос: Что если входные данные содержат символы Юникода? Как бы вы адаптировали свое решение к такому случаю?

память O(n)
время O(n) + O(n) -> O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("cat", "rat"));
        System.out.println(isAnagram("a", "ab"));
        System.out.println(isAnagram("cacc", "aacc"));
        System.out.println(isAnagram("cacc", "ccca"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>(); // буква - количество раз повторяется

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //  можно заменить на map.merge(c, 1, Integer::sum)
            Integer count = map.get(c);
            if (count == null)
                map.put(c, 1);
            else
                map.put(c, count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            if (count == null)
                return false;
            else {
                count--;
                if (count == 0)
                    map.remove(c);
                else
                    map.put(c, count);
            }

        }

        return map.isEmpty();
    }
}
