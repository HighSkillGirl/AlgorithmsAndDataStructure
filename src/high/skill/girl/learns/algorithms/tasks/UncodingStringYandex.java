package high.skill.girl.learns.algorithms.tasks;

// дана зашифрованная строка вида 8512#15#10. Цифры от 1 до 9 равнозначны буквам от a до i, далее 10#-26# соотносятся с буквами j-z
// требуется расшифровать строку. Гарантируется, что исходная строка является закодированной и её можно расшифровать

// суть алгоритма построена вокруг символа `#`. Если символ в строке отсутствует, мы проходим посимвольно строку и меняем цифру на букву один к одному
// если символ есть, то сначала мы работаем с "двузначной буквой". А потом уже переходим к односимвольным модификациям

// сложность по времени этого решения - O(n^2) - TODO: можно попробовать переделать на линейное
// сложность по памяти этого решения - O(n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UncodingStringYandex {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();
        uncode(input);
    }

    private static void uncode(String input) {
        StringBuilder result = new StringBuilder(input);
        int hashIndex = input.indexOf('#');

        while (hashIndex != -1) {
            String a = result.substring(hashIndex - 2, hashIndex + 1);
            result.replace(hashIndex - 2, hashIndex + 1, "" + uncodeSubstring(a));
            hashIndex = result.indexOf("#");
        }

        for (int i = 0; i < result.length(); i++) {
            char symbol = result.charAt(i);
            if (Character.isDigit(symbol)) {
                int symbolNumber = symbol - '0';
                char letter = (char) ('a' + symbolNumber - 1);
                result.setCharAt(i, letter);
            }
        }

        System.out.println(result);
    }

    private static char uncodeSubstring(String subString) { // символы - это коды из Юникода
        int symbolAsDigit = (subString.charAt(0) - '0') * 10 + (subString.charAt(1) - '0');
        // для строки 12#: (49 - 48) * 10 + (50 - 48) = 12
        return (char) ('a' + symbolAsDigit - 1);
        // для строки 12#: `a` = 97 + 12 = 109 - 1 (коды идут с нуля) -> 108 -> l
    }

}