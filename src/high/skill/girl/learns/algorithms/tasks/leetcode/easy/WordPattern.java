package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Дан шаблон и строка s. Необходимо определить, соответствует ли строка s этому шаблону.
Здесь «соответствует» означает полное совпадение, такое, что существует биекция между буквой в шаблоне и непустым словом в строке s. В частности:

    Каждая буква в шаблоне соответствует ровно одному уникальному слову в строке s.
    Каждое уникальное слово в строке s соответствует ровно одной букве в шаблоне.
    Никакие две буквы не соответствуют одному и тому же слову, и никакие два слова не соответствуют одной и той же букве.

Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
    Explanation:
        The bijection can be established as:
            'a' maps to "dog".
            'b' maps to "cat".

сложность для V1:
    память O(n)
    время O(n^2)

сложность для V2:
    память O(n)
    время O(n)

 */

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPatternV1("abba", "dog cat cat dog")); // true
        System.out.println(wordPatternV1("abba", "dog cat cat fish")); // false
        System.out.println(wordPatternV1("aaaa", "dog cat cat dog")); // false
        System.out.println(wordPatternV1("abba", "dog dog dog dog")); // false
        System.out.println(wordPatternV1("abc", "dog cat dog")); // false
        System.out.println(wordPatternV1("aaa", "aa aa aa aa")); // false
        System.out.println("----------------------------------");
        System.out.println(wordPatternV2("abba", "dog cat cat dog")); // true
        System.out.println(wordPatternV2("abba", "dog cat cat fish")); // false
        System.out.println(wordPatternV2("aaaa", "dog cat cat dog")); // false
        System.out.println(wordPatternV2("abba", "dog dog dog dog")); // false
        System.out.println(wordPatternV2("abc", "dog cat dog")); // false
        System.out.println(wordPatternV2("aaa", "aa aa aa aa")); // false
    }

    private static boolean wordPatternV1(String pattern, String s) {
        String[] splittedString = s.split(" ");
        if (pattern.length() != splittedString.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String value = map.get(c);
            if (value != null && !value.equals(splittedString[i]))
                return false;

            for (Map.Entry<Character, String> entry : map.entrySet()) { // не очень удачно из-за обхода
                if (entry.getValue().equals(value) && !entry.getKey().equals(c))
                    return false;
                if (!entry.getKey().equals(c) && entry.getValue().equals(splittedString[i]))
                    return false;
            }
            map.put(c, splittedString[i]);
        }

        return true;
    }

    private static boolean wordPatternV2(String pattern, String s) {
        String[] splittedString = s.split(" ");
        if (pattern.length() != splittedString.length)
            return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String currentString = splittedString[i];

            Character charMatch = map2.get(currentString);
            String stringMatch = map1.get(c);

            if ( (charMatch != null && charMatch != c) || ( stringMatch != null && !stringMatch.equals(currentString)) )
                return false;

            map1.put(c,currentString);
            map2.put(currentString, c);
        }

        return true;
    }
}
