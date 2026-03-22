package high.skill.girl.learns.algorithms.tasks;

import java.io.*;

public class OligopolyYandex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if (n <= 0) {
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

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        if (n == 1) {
            writer.write("1");
            writer.close();
            return;
        }

        long looserIndex;
        if (inputArray[0] == inputArray[index - 1]) {
            looserIndex = index;
        } else {
            looserIndex = binarySearchLooser(inputArray, 0, inputArray.length - 1);
        }

        for (long i = 0; i < n; i++) {
            if (i <= looserIndex) {
                writer.write("0");
                writer.newLine();
            } else {
                writer.write("1");
                writer.newLine();
            }
        }
        writer.close();
    }

    private static long binarySearchLooser(long[] array, int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        long prefixSum = 0;
        for (int i = middleIndex - 1; i >= 0; i--) {
            prefixSum += array[i];
        }
        if (prefixSum + array[middleIndex] > array[middleIndex + 1]) {
            return binarySearchLooser(array, leftIndex, middleIndex - 1);
        } else {
            return middleIndex;
        }
    }
}