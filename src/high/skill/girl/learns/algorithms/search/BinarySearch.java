package high.skill.girl.learns.algorithms.search;

// массив в бинарном поиске - стабильная структура (аналог книжной полки, прибитой гвоздями к полу)
// принцип алгоритма заключается в поиске диапазона относительно текущей середины: каждую итерацию рекурсии мы двигаем или левую или правую часть
// 2 возможных реализации - рекурсивная и итеративная
// сложность по времени - O(log n)
// сложность по памяти - O(log n) в рекурсии и O(1) через итерацию

public class BinarySearch {
    public static int recursionBinarySearch(int[] array, int wanted, int leftIndex, int rightIndex) {
        int middleIndex = (rightIndex + leftIndex) / 2;

        if (wanted > array[middleIndex]) {
            leftIndex = middleIndex + 1; // исключаем середину из выборки
            return recursionBinarySearch(array, wanted, leftIndex, rightIndex);
        }
        if (wanted < array[middleIndex]) {
            rightIndex = middleIndex - 1; // исключаем середину из выборки
            return recursionBinarySearch(array, wanted, leftIndex, rightIndex);
        }
        if (wanted == array[middleIndex])
            return middleIndex;

        return -1;
    }

    public static int whileBinarySearch(int[] array, int wanted) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middleIndex;

        while (leftIndex <= rightIndex) {
            middleIndex = (rightIndex + leftIndex) / 2;
            if (wanted > array[middleIndex]) {
                leftIndex = middleIndex + 1; // исключаем середину из выборки
            } else if (wanted < array[middleIndex]) {
                rightIndex = middleIndex - 1; // исключаем середину из выборки
            } else if (wanted == array[middleIndex])
                return middleIndex;
        }

        return -1;
    }
}
