package high.skill.girl.learns.algorithms.tasks;

import java.io.*;
import java.util.StringTokenizer;

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

        StringTokenizer tokenizer = new StringTokenizer(a);
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            long value = Integer.parseInt(tokenizer.nextToken());
            if (value <= 0) return;
            inputArray[index] = value;
            index++;
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        if (n == 1 || index < n) {
            writer.write("1");
            writer.close();
            return;
        }

        long[] prefixSumArray = new long[n];
        for (int i = 1; i < n; i++) {
            if (inputArray[i] > inputArray[i - 1]) {

                long innerSum = 0;
                for (int k = i; k >= 0; k--) {
                    innerSum += (int) inputArray[k];
                }
                prefixSumArray[i] = innerSum;
            } else {
                prefixSumArray[i] = prefixSumArray[i - 1];
            }
        }

        long sumValue;
        long nextValue;
        for (int i = 0; i < n; i++) {
            sumValue = prefixSumArray[i];
            nextValue = i + 1 >= n ? inputArray[n - 1] : inputArray[i + 1];
            if (sumValue < nextValue || sumValue == nextValue) {
                writer.write("0");
                writer.newLine();
            } else {
                writer.write("1");
                writer.newLine();
            }
        }

        writer.close();

    }
}