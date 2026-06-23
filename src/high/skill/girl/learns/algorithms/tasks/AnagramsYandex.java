package high.skill.girl.learns.algorithms.tasks;

/*
Даны две строки, состоящие из строчных латинских букв. Требуется определить, являются ли эти строки анаграммами,
т. е. отличаются ли они только порядком следования символов.

Входной файл содержит две строки строчных латинских символов, каждая не длиннее 100 000 символов. Строки разделяются символом перевода строки.
Выходной файл должен содержать единицу, если строки являются анаграммами, и ноль в противном случае.

Нюансы: ограничение по памяти
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramsYandex {
    public static void main(String[] args) throws IOException { // не забывать про пакеты и исключения
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        if (s1.length() != s2.length()) {
            System.out.println(0);
            return;
        }

        int[] count = new int[26]; // 1 - массив-отображение букв английского алфавита

        for (int i = 0; i < s1.length(); i++) { // 2 - вот тут ключевое: мы увеличиваем, а потом уменьшаем содержимое (изначально все нули), если буква присутствует.
            count[s1.charAt(i) - 'a']++;        // Вычитание 'a' нужно для смещения от начала алфавита.
            count[s2.charAt(i) - 'a']--;        // Таким образом, получается, что если счетчик не 0 - буква встретилась только 1 раз, не повторилась
        }

        for (int c : count) { // 3 - далее проходим по массиву заключительный раз - если есть хоть 1 ноль - выходим с негативным результатом
            if (c != 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1); // 4 - иначе - у нас позитив!

    }
}