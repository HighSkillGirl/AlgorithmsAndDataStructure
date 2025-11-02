package high.skill.girl.prepare.interview.algorithms.tasks;

/*
Требуется найти в бинарном векторе (массиве 1 и 0) самую длинную последовательность единиц и вывести её длину.
Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.

Тест-кейсы:
1 1 => 1
1 0 => 0
5 1 1 1 0 1 => 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountUnitsInBinVectorYandex {
    public static void main(String... args) throws IOException { // не забудь про пакеты и исключения, они автоматически подсвечиваются только в IDE

        // 1 - создаем ридер для чтения консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 2 - вычитываем сначала первое число - размерность списка. Сразу же проверяем на ограничение по условию
        int initCountOfBinVector = Integer.parseInt(reader.readLine());
        if (initCountOfBinVector > 10_000) initCountOfBinVector = 0;

        // 3 - заводим переменные. Local нужна для счета на каждой итерации, max - для хранения максимального счета на протяжении всей последовательности
        int localCount = 0;
        int maxCount = 0;

        // 4 - раньше был for, но так выглядит профессиональнее, нравится (вычитание после проверки)
        while (initCountOfBinVector-- > 0) {
            int newDigit = Integer.parseInt(reader.readLine()); // 5 - читаем новое число последовательности, парсим в int

            if (newDigit == 1) { // 6 - общая схема такова: если 1 - счетчик растет + обновляется глобальный, иначе - сброс
                localCount++;
                if (maxCount < localCount) maxCount = localCount;
            } else {
                localCount = 0;
            }
        }

        reader.close(); // 7 - не забываем закрывать ресурсы
        System.out.println(maxCount); // 8 - вывод
    }
}