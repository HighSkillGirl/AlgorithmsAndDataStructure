package high.skill.girl.learns.algorithms.tasks;

/*
Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.
Желательно получить решение, которое не считывает входной файл целиком в память, т.е., использует лишь константный объем памяти в процессе работы.
 */

import java.io.*;

public class DeleteDuplicatesYandex {
    public static void main(String[] args) throws IOException { // 1 - не забываем исключения и пакеты
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countValue = Integer.parseInt(reader.readLine()); // 2 - считываем первое число, отвечающее за размерность массива
        if (countValue <= 0) return;

        int prevInt = Integer.parseInt(reader.readLine()); // 3 - считываем второе число - всегда уникальное, поэтому выводим в консоль (требования отдельного вывода нет)
        System.out.println(prevInt);
        countValue--; // 4 - скидываем счетчик, так как уже 1 число пройдено

        while(countValue-- > 0) {
            int currentInt = Integer.parseInt(reader.readLine()); // 5 - считываем следующие числа и сравниваем их с предыдущим
            if (currentInt != prevInt) {
                System.out.println(currentInt); // 6 - выводим только если уникальное
                prevInt = currentInt;
            }
        }

        reader.close(); // 7 - не забываем закрыть ресурсы
    }
}