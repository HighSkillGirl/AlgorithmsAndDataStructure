package high.skill.girl.tests.algorithms.sorting;

import high.skill.girl.learns.algorithms.sorting.BubbleSort;
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

public class BubbleSortTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("BubbleSortTest")
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

        @Param({"10", "100", "1000", "10000", "100000", "1000000", "10000000"})
        private int length;
        private int[] array;

        @Setup(Level.Iteration)
        public void setup() {
            Random r = new Random();
            array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = r.nextInt(length - 1) + 1;
            }
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void bubbleSort(BubbleSortTest.TestCaseModel testCase) {
        BubbleSort.bubbleSort(testCase.array);
    }
}
