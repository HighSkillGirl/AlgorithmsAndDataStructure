package high.skill.girl.learns.algorithms.sorting;

// суть в поиске минимального индекса и перестановке значения 1 раз во внешнем цикле. То есть внутренний цикл нужен для поиска минимума
// используется в обучении, может применяться для структур с дорогой записью в память (максимум перестановок n - 1)
// сложность по времени - O(n^2)
// сложность по памяти - O(1)

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = new int[]{4, -1, 8, 6, 5};
        selectionSort(data);
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[minIndex])
                    minIndex = k;
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
