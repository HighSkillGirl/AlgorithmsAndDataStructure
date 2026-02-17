package high.skill.girl.learns.algorithms.sorting;

// суть в поиске минимального индекса и перестановке значения 1 раз во внешнем цикле. То есть внутренний цикл нужен для поиска минимума
// сложность по времени - O(n^2)
// сложность по памяти - O(1)

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = new int[]{1, 5, 44, -3, 12, -1, 1};
        int[] data2 = new int[]{-133, 23, -11, 0, 1999, -11, 7, 23};
        selectionSort(data2);
    }

    private static void selectionSort(int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[minIndex]) {
                    minIndex = k;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
