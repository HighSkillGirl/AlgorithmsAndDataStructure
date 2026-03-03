package high.skill.girl.learns.algorithms.sorting;

// сортировка в рекурсии - после деления массива складываем по условию >< чем pivot
// используется в обучении, так как создание массивов на каждом уровне рекурсии избыточно
// сложность по времени: O(n^2) в худшем случае и O(n log n) в среднем
// сложность по памяти: O(n^2) в худшем случае и O(n log n) в среднем

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{-1, 3, 4, -3, -3, 253, -18, 1};
        System.out.println(Arrays.toString(arrayQuickSort(data)));
        System.out.println(Arrays.toString(inPlaceQuickSort(data, 0, data.length - 1)));
    }

    private static int[] arrayQuickSort(int[] array) {
        if (array.length <= 1) return array;

        int pivotIndex = array.length / 2;

        int leftSizeCount = -1;
        int rightSizeCount = -1;
        int equalPivotSize = -1;
        int[] leftArray = new int[array.length];
        int[] equalPivotArray = new int[array.length];
        int[] rightArray = new int[array.length];

        for (int i : array) {
            if (i > array[pivotIndex]) {
                rightSizeCount++;
                rightArray[rightSizeCount] = i;
            } else if (i < array[pivotIndex]) {
                leftSizeCount++;
                leftArray[leftSizeCount] = i;
            } else if (i == array[pivotIndex]) {
                equalPivotSize++;
                equalPivotArray[equalPivotSize] = i;
            }
        }

        return mergeArrays(arrayQuickSort(Arrays.copyOf(leftArray, leftSizeCount + 1))
                         , Arrays.copyOf(equalPivotArray, equalPivotSize + 1)
                         , arrayQuickSort(Arrays.copyOf(rightArray, rightSizeCount + 1)));
    }

    private static int[] mergeArrays(int[] leftArray, int[] equalPivotArray, int[] rightArray) {
        int[] result = new int[leftArray.length + equalPivotArray.length + rightArray.length];
        System.arraycopy(leftArray, 0, result, 0, leftArray.length);
        System.arraycopy(equalPivotArray, 0, result, leftArray.length, equalPivotArray.length);
        System.arraycopy(rightArray, 0, result, leftArray.length + equalPivotArray.length, rightArray.length);
        return result;
    }

    private static int[] inPlaceQuickSort(int[] array, int left, int right) {
        if (left >= right) return array;

        int pivotValue = array[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < pivotValue) {
                i++;
            }
            while (array[j] > pivotValue) {
                j--;
            }

            if (i <= j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

                i++;
                j--;
            }
        }

        inPlaceQuickSort(array, left, j);
        inPlaceQuickSort(array, i, right);

        return array;
    }
}
