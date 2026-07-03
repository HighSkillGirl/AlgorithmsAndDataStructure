package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан массив строк strs. Сгруппируйте анаграммы. Вы можете вернуть ответ в любом порядке.

Ключ к решению: посмотреть на структуру мапы под другим углом + нормализация входного массива. Если ключи нормализованы, но анограммы складываются в один бакет - это и есть список.

память O(n * k) -> n - все эелементы попадут в мапу, и ключи в худшем случае все уникальные
время O(n · k log k) -> O(n) проход массива, O(k log k) сортировка ключа
 */

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagramsTTL(new String[]{"tan", "eat","tea","ate","nat","bat"}));
        System.out.println(groupAnagramsTTL(new String[]{"",""}));

        System.out.println(groupAnagramsV2(new String[]{"tan", "eat","tea","ate","nat","bat"}));
        System.out.println(groupAnagramsV2(new String[]{"",""}));
    }

    private static List<List<String>> groupAnagramsTTL(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                String key = getSortedKey(strs[i]);

                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                strs[i] = null;

                for (int j = 1; j < strs.length; j++) {
                    if (strs[j] != null) {
                        String localKey = getSortedKey(strs[j]);

                        if (localKey.equals(key)) {
                            list.add(strs[j]);
                            strs[j] = null;
                        }
                    }
                }
                result.add(list);
            }
        }

        return result;
    }

    private static List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getSortedKey(s);
            List<String> anagramList = map.get(key);
            if (anagramList == null) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(key, newList);
            } else {
                anagramList.add(s);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String getSortedKey(String source) {
        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
