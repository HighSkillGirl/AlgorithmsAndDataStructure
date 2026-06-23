package high.skill.girl.tests.algorithms.search;

import high.skill.girl.learns.algorithms.search.BinarySearch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
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
                .addProfiler("gc")
                .build();

        Collection<RunResult> results = new Runner(opt).run();

        for (RunResult r : results) {
            String n = r.getParams().getParam("n");

            Result alloc = r.getSecondaryResults().get("gc.alloc.rate.norm");

            System.out.printf("%s: %s -> time=%.6f %s, alloc=%.2f %s%n",
                    r.getParams().getBenchmark(),
                    n,
                    r.getPrimaryResult().getScore(),
                    r.getPrimaryResult().getScoreUnit(),
                    alloc.getScore(),
                    alloc.getScoreUnit());
        }

    }

    @State(Scope.Thread)
    public static class TestCaseModel {

        @Param({"100", "1000", "10000", "100000", "1000000", "10000000"})
        private int length;
        private int[] array;
        Random randomInt = new Random();
        int wanted;

        @Setup(Level.Iteration)
        public void setup() {
            array = new int[length];
            for (int i = 0; i < length; i++) array[i] = i;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void recursionBinarySearch(TestCaseModel testCase) {
        testCase.wanted = testCase.randomInt.nextInt(testCase.length - 10) + 10;
        BinarySearch.recursionBinarySearch(testCase.array, testCase.wanted, 0, testCase.length - 1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void whileBinarySearch(TestCaseModel testCase) {
        testCase.wanted = testCase.randomInt.nextInt(testCase.length - 10) + 10;
        BinarySearch.whileBinarySearch(testCase.array, testCase.wanted);
    }
}
