package high.skill.girl.learns.algorithms.tasks;

/*
Даны две строки строчных латинских символов: строка J и строка S.
Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
Проще говоря, нужно проверить, какое количество символов из S входит в J.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StonesAndJewelryYandex {
    public static void main(String[] args) throws IOException { // не забудь про пакеты и исключения, они автоматически подсвечиваются только в IDE
        // 1 - вычитываем входящие данные
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String j = reader.readLine(); // драгоценности
        String s = reader.readLine(); // камни
        //сколько камней являются драгоценностями

        // 2 - закрываем ресурсы
        reader.close();

        // 3 - заводим переменную для результата
        int count = 0;

        // 4 - в цикле по строке, в которой ищем совпадения, проходимся по ней и если совпадение найдено - сохраняем счетчик
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (j.indexOf(currentChar) >= 0) {
                count++;
            }
        }

        // 5 - выводим
        System.out.println(count);
    }
}
