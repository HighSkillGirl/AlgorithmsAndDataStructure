package high.skill.girl.learns.algorithms.sorting;

// делим массив слуайным образом на две части рекурсивно и сортируем каждую половину

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{-1, 3, 4, -3, -3, 253, -18, 1};
        System.out.println(Arrays.toString(divideAndConquerQuickSort(data)));
    }

    private static int[] divideAndConquerQuickSort(int[] array) {
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

        return mergeArrays(divideAndConquerQuickSort(Arrays.copyOf(leftArray, leftSizeCount + 1))
                         , Arrays.copyOf(equalPivotArray, equalPivotSize + 1)
                         , divideAndConquerQuickSort(Arrays.copyOf(rightArray, rightSizeCount + 1)));
    }

    private static int[] mergeArrays(int[] leftArray, int[] equalPivotArray, int[] rightArray) {
        int[] result = new int[leftArray.length + equalPivotArray.length + rightArray.length];
        System.arraycopy(leftArray, 0, result, 0, leftArray.length);
        System.arraycopy(equalPivotArray, 0, result, leftArray.length, equalPivotArray.length);
        System.arraycopy(rightArray, 0, result, leftArray.length + equalPivotArray.length, rightArray.length);
        return result;
    }
}
