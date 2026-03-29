package high.skill.girl.learns.algorithms.search.impl;

import high.skill.girl.learns.algorithms.search.BinarySearch;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BinarySearchTest {

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @State(Scope.Thread)
    private class InputData {
        private int[] arr;

        @Setup(Level.Iteration)
        public void setup() {
            int n = 1_000_000;
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void howLongDoesItTake() {
        //int index = BinarySearch.whileBinarySearch(new int[]{-3, 1, 1, 2, 5, 7, 10, 25, 253}, 2);
        //Result "high.skill.girl.learns.algorithms.search.impl.BinarySearchTest.howLongDoesItTake":
        //≈ 10⁻⁵ ms/op также для рекурсии
        //int[] data = new int[]{-3, 1, 1, 2, 5, 7, 10, 25, 253};
        InputData data = new InputData();
        data.setup();
        int index = BinarySearch.recursionBinarySearch(data.arr, 2, 0, data.arr.length - 1);
    }
}
