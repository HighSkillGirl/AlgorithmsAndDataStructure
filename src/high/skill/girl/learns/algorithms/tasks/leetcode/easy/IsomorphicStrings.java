package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Даны две строки s и t. Определите, изоморфны ли они.
Две строки s и t изоморфны, если символы в строке s можно заменить, чтобы получить строку t.
Все вхождения одного символа должны быть заменены другим символом с сохранением порядка символов.
Никакие два символа не могут соответствовать одному и тому же символу, но один символ может соответствовать самому себе.

Example 1:
    Input: s = "egg", t = "add"
    Output: true
    Explanation:
        The strings s and t can be made identical by:
            Mapping 'e' to 'a'.
            Mapping 'g' to 'd'.

Example 2:
    Input: s = "f11", t = "b23"
    Output: false
    Explanation:
        The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

V1:
    сложность по памяти O(n)
    сложность по времени O(n)
V2:
    сложность по памяти O(1)
    сложность по времени O(n)

 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("add", "egg")); // true
        System.out.println(isIsomorphic("f11", "b23")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); // false
        System.out.println("--------------------------------");
        System.out.println(isIsomorphicV2("add", "egg")); // true
        System.out.println(isIsomorphicV2("f11", "b23")); // false
        System.out.println(isIsomorphicV2("paper", "title")); // true
        System.out.println(isIsomorphicV2("bbbaaaba", "aaabbbba")); // false
        System.out.println(isIsomorphicV2("a", "a")); // true
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char source = s.charAt(i);
            char target = t.charAt(i);

            Character mappedSource = map2.get(target);
            Character mappedTarget = map1.get(source);

            if ( (mappedSource != null && mappedSource != source) || (mappedTarget != null && mappedTarget != target) )
                return false;

            map1.put(source, target);
            map2.put(target, source);
        }

        return true;
    }

    private static boolean isIsomorphicV2(String s, String t) { // храним последнюю позицию, где элемент встречался: source.b = 3, target.b = 6
        if (s.length() != t.length())
            return false;

        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int source = s.charAt(i);
            int target = t.charAt(i);

            if (sourceMap[source] != targetMap[target])
                return false;

            sourceMap[source] = i + 1;
            targetMap[target] = i + 1;
        }
        return true;
    }
}
