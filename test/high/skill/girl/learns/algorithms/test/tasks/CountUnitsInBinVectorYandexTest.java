package high.skill.girl.learns.algorithms.test.tasks;

import high.skill.girl.learns.algorithms.tasks.CountUnitsInBinVectorYandex;

import java.io.*;

public class CountUnitsInBinVectorYandexTest implements Testable<CountUnitsInBinVectorYandexTest.TestCaseModel> {

    public record TestCaseModel (int n, int[] binVector, int expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[]
            {
                new TestCaseModel(1, new int[]{1}, 1),
                new TestCaseModel(1, new int[]{0}, 0),
                new TestCaseModel(5, new int[]{1, 1, 1, 0, 1}, 3),
                new TestCaseModel(10_001, new int[]{1}, 0),

            };

    public static void main(String[] args) throws IOException {
        new CountUnitsInBinVectorYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCase) {
        StringBuilder sb = new StringBuilder();
        sb.append(testCase.n).append("\n");
            for (int j = 0; j < testCase.binVector.length; j++) {
                sb.append(testCase.binVector[j]).append("\n");
            }
        return sb.toString();
    }

    @Override
    public void testAlgorithm() throws IOException {
        CountUnitsInBinVectorYandex.main(new String[]{});
    }

    @Override
    public String getExpectedResult(TestCaseModel testCase) {
        return String.valueOf(testCase.expectedResult);
    }

    @Override
    public boolean isResultCorrect(String actual, String expected) {
        return Integer.parseInt(actual) == Integer.parseInt(expected);
    }

    @Override
    public String getSimpleClassName() {
        return CountUnitsInBinVectorYandex.class.getSimpleName();
    }
}
