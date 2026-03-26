package high.skill.girl.learns.algorithms.tasks;

// задача на теоретическое поглощение компаний: нужно определить, какие компании могут поглотить всех остальных и выиграть
// ввод: число компаний, их капиталы в порядке возрастания
// вывод: в том же порядке 0 - если компания не сможет поглотить всех и 1 - если ей удасться

// используется рекурсивный бинарный поиск границы, с которой все справа будут победителями
// не проходят тесты в контексте, но я не могу выяснить причину

// сложность по памяти - O(n)
// сложность по времени - O(n)

import java.io.*;

public class OligopolyYandex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if (n <= 0) {
            reader.close();
            return;
        } else if (n == 1) {
            System.out.println(1);
            reader.close();
            return;
        }

        String a = reader.readLine();
        reader.close();

        long[] inputArray = new long[n];

        String[] a1 = a.split(" ");
        int index = 0;
        for (String s : a1) {
            long value = Integer.parseInt(s);
            if (value <= 0) return;
            inputArray[index] = value;
            index++;
        }

        long[] prefixSumArray = new long[n];
        for (int i = 1; i < n - 1; i++) {
            prefixSumArray[i] = inputArray[i] + prefixSumArray[i - 1];
        }

        long looserIndex;
        if (inputArray[0] == inputArray[index - 1]) {
            looserIndex = index;
        } else {
            looserIndex = binarySearchLooser(inputArray, prefixSumArray, 0, inputArray.length - 1);
        }

        for (long i = 0; i < n; i++) {
            if (i <= looserIndex) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }

    private static long binarySearchLooser(long[] inputArray, long[] prefixSumArray, int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (prefixSumArray[middleIndex - 1] + inputArray[middleIndex] > inputArray[middleIndex + 1]) {
            return binarySearchLooser(inputArray, prefixSumArray, leftIndex, middleIndex - 1);
        } else {
            return middleIndex;
        }
    }
}