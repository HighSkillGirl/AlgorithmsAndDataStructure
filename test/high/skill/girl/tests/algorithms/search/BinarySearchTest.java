package high.skill.girl.tests.algorithms.search;

import high.skill.girl.learns.algorithms.search.BinarySearch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BinarySearchTest {

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include("BinarySearchTest")
                .mode(Mode.AverageTime)
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(2)
                .resultFormat(ResultFormatType.JSON)
                .result("results.json")
                .build();

        Collection<RunResult> results = new Runner(opt).run();

        for (RunResult r : results) {
            System.out.printf("%s: %.6f %s%n",
                    r.getParams().getBenchmark(),
                    r.getPrimaryResult().getScore(),
                    r.getPrimaryResult().getScoreUnit());
        }

    }

    @State(Scope.Thread)
    public static class TestCaseModel {

        @Param({"100", "1000", "10000", "100000", "1000000", "10000000"})
        private int n;
        private int[] arr;
        Random randomInt = new Random();
        int wanted;

        @Setup(Level.Iteration)
        public void setup() {
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void recursionBinarySearch(TestCaseModel testCase) {
        testCase.wanted = testCase.randomInt.nextInt(testCase.n - 10) + 10;
        int index = BinarySearch.recursionBinarySearch(testCase.arr, testCase.wanted, 0, testCase.arr.length - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void whileBinarySearch(TestCaseModel testCase) {
        testCase.wanted = testCase.randomInt.nextInt(testCase.n - 10) + 10;
        int index = BinarySearch.whileBinarySearch(testCase.arr, testCase.wanted);
    }
}
