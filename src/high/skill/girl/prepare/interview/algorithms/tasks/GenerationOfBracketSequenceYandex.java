package high.skill.girl.prepare.interview.algorithms.tasks;

/*
Единственная строка входного файла содержит целое число n, 0≤n≤11. В задаче используются только круглые скобки.
Требуется вывести все правильные скобочные последовательности длины 2⋅n, упорядоченные лексикографически.

Желательно получить решение, которое работает за время, пропорциональное общему количеству правильных скобочных последовательностей в ответе,
и при этом использует объём памяти, пропорциональный n (O(n)).

Нюансы: вложенность в приоритете, сильное ограничение по памяти и времени выполнения

Тест-кейсы:
2 -> (()) ()()
3 -> ((())) (()()) (())() ()(()) ()()()
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerationOfBracketSequenceYandex {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();

        generate(new StringBuilder(), 0, 0, n); // 1 - основной принцип - рекурсия (2 подряд открывающиеся скобки).
                                                           // StringBuilder используется для оптимизации памяти
    }

    private static void generate(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            System.out.println(sb);
            return;
        }

        if (open < n) {
            generate(sb.append("("), open + 1, close, n);
            cancelSbChanges(sb); // отменяем изменения в билдере, чтобы выйти из рекурсии на нужной скобке при второй итерации (следующий вариант порядка)
        }

        if (close < open) {
            generate(sb.append(")"), open, close + 1, n);
            cancelSbChanges(sb);
        }
    }

    private static void cancelSbChanges(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }
}
