package high.skill.girl.learns.algorithms.sorting;

// смысл в многократном прохождении массива и перестановке местами соседних элементов в порядке возрастания
// используется только в обучении - очень не оптимизирован
// сложность по времени O(n^2) - в худшем случае все элементы будут перепутаны и нужно пройти n * n раз
// сложность по памяти O(1) - при оценке алгритма по памяти учитывается только дополнительная память на расчеты без оценки входных данных

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = new int[]{4, -1, 8, 6, 5};
        bubbleSort(data);
    }

    private static void bubbleSort(int[] array) {
        boolean while_swap = true;

        while (while_swap) {
            while_swap = false;

            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    break;
                }
                int curr = array[i];
                int next = array[i + 1];
                if (curr > next) {
                    array[i] = next;
                    array[i + 1] = curr;
                    while_swap = true;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}