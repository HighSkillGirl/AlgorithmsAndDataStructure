package high.skill.girl.learns.algorithms.tasks;

/*
В первой строке входных данных записано количество городов.
В следующих n строках даны два целых числа: координаты каждого города, не превосходящие по модулю миллиарда.
Все города пронумерованы числами от 1 до n в порядке записи во входных данных.

В следующей строке записано целое положительное число k, не превосходящее двух миллиардов, — максимальное расстояние между городами,
которое Петя может преодолеть без дозаправки машины.
В последней строке записаны два различных числа — номер города, откуда едет Петя, и номер города, куда он едет.

Если существуют пути, удовлетворяющие описанным выше условиям, то выведите минимальное количество дорог, которое нужно проехать,
чтобы попасть из начальной точки маршрута в конечную. Если пути не существует, выведите -1.

Нюансы: это графовая задача с использованием больших чисел - поэтому тут есть long. Также есть ограничение по памяти - 64Мб.
        Также важно - что по координатам сохраняются города в массив с 0 (индексация), а обращение идет с единицы (после двойки 1 и 3)

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class InterestingJourneyYandex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long[][] cityArray = new long[n][2]; // считываем и заполняем массив координат для каждого города

        for (int i = 0; i < n; i++) {
            String[] coordinates = reader.readLine().split("\\s+");
            cityArray[i][0] = Integer.parseInt(coordinates[0]);
            cityArray[i][1] = Integer.parseInt(coordinates[1]);
        }

        long k = Long.parseLong(reader.readLine()); // считываем, сколько до заправки

        String[] pointers = reader.readLine().split("\\s+"); // считываем точку отправления (a) и прибытия (b) и считаем сколько нужно проехать (dist)
        int a = Integer.parseInt(pointers[0]) - 1;
        int b = Integer.parseInt(pointers[1]) - 1;

        // итак, мы имеем дистанцию 4 с возможностью проехать только 2 без заправки
        // теперь надо посчитать, сколько точек дозаправки нам нужно

        // Очередь — в ней будут города, в которые можно попасть
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a); // по умолчанию находимся в текущем (a)

        // Массив расстояний — сколько дорог нужно проехать до каждого города
        int[] distArray = new int[n];
        Arrays.fill(distArray, -1); // все города недоступны
        distArray[a] = 0; // в стартовом городе находимся, поэтому значение - 0

        while (!queue.isEmpty()) {
            int currentCity = queue.poll(); // берём текущий город - a

            if (currentCity == b) break;

            for (int nextCityIndex = 0; nextCityIndex < n; nextCityIndex++) {
                if (distArray[nextCityIndex] != -1) continue; // уже посещали

                long distance = Math.abs(cityArray[currentCity][0] - cityArray[nextCityIndex][0]) // считаем дистанцию от точки отправления до текущего в очереди
                               + Math.abs(cityArray[currentCity][1] - cityArray[nextCityIndex][1]);

                if (distance <= k) { // можно доехать без дозаправки - тогда открывается следующий город
                    distArray[nextCityIndex] = distArray[currentCity] + 1;
                    queue.add(nextCityIndex);
                }
            }
        }

        System.out.println(distArray[b]);
    }
}