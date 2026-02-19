package high.skill.girl.learns.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = new int[]{5, -1, 8, 6, 4};
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
