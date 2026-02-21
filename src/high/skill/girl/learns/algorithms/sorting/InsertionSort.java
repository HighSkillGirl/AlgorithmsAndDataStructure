package high.skill.girl.learns.algorithms.sorting;

// суть алгоритма в том, что текущее число изымается из рассмотрения, тем самым мы освобождаем место для сдвигаемых элементов
// удобна, когда массив почти отсортирован. Используется в потоковой обработке данных и как часть более адаптивных алгоритмов
// "примитивная, но практичная"
// сложность по времени - O(n^2)
// сложность по памяти - O(1)

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = new int[]{4, -1, 8, 6, 5};
        insertionSort(data);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int base = array[i];
            int prevIndex = i - 1;
            while (prevIndex >= 0 && base < array[prevIndex]) {
                array[prevIndex + 1] = array[prevIndex]; // сдвиг через копирование
                prevIndex--;
            }
            array[prevIndex + 1] = base;
        }
        System.out.println(Arrays.toString(array));
    }
}
