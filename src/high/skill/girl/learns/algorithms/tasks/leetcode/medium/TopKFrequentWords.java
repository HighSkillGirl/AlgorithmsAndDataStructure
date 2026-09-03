package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Дан массив строковых слов и целое число k. Верните k наиболее часто встречающихся строк.
Верните ответ, отсортированный по частоте от наибольшей к наименьшей. Отсортируйте слова с одинаковой частотой в лексикографическом порядке.

Example 1:
    Input: words = ["i","love","leetcode","i","love","coding"], k = 2
    Output: ["i","love"]
        Explanation: "i" and "love" are the two most frequent words.
        Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
    Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
    Output: ["the","is","sunny","day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?

сложность по памяти: O(n) + O(k) + O(k) => O(n)
слоность по времени: O(n) + O(log n) + O(k) => (n log k)

 */

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2)); // ["i","love"]
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4)); // ["the","is","sunny","day"]
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(); // считаем частотность
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (entry1, entry2) -> { // составной компаратор:
                int frequencyComparingResult = Integer.compare(entry1.getValue(), entry2.getValue());                   // сначала проверяем совпадение частотности
            if (frequencyComparingResult != 0)                                                                          // если частотность разная, лексикографию не сравниваем
                    return frequencyComparingResult;

                return entry2.getKey().compareTo(entry1.getKey());  // очень важно сравнивать наоборот                  // если частотность одинаковая, сравниваем буквы
        };

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, comparator); // складываем в очередь
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry); // компаратор работает и тут тоже
            } else if (comparator.compare(queue.peek(), entry) < 0) {
                queue.poll();
                queue.offer(entry);
            }
        }

        String[] result = new String[k]; // особенность условия - обратный порядок сохранения - за всю задачу делаем два "разворота"
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return Arrays.asList(result);
    }
}
