package high.skill.girl.tests.algorithms.tasks.yandex.impl;

import high.skill.girl.learns.algorithms.tasks.yandex.InterestingJourney;
import high.skill.girl.tests.algorithms.tasks.yandex.TestCasesInterface;

import java.io.IOException;

public class InterestingJourneyTest implements TestCasesInterface<InterestingJourneyTest.TestCaseModel> {

    public record TestCaseModel(int n, int[][] coordinates, int k, int[] ab, int expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[] {
        new TestCaseModel(7, new int[][]{{0, 0}, {0, 2}, {2, 2}, {0, -2}, {2, -2}, {2, -1}, {2, 1}}, 2, new int[]{1, 3}, 2)
    };

    public static void main(String[] args) throws IOException {
        new InterestingJourneyTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCase) {
        StringBuilder sb = new StringBuilder();
        sb.append(testCase.n).append("\n");
        for (int[] i : testCase.coordinates) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        sb.append(testCase.k).append("\n");
        sb.append(testCase.ab[0]).append(" ").append(testCase.ab[1]);
        return sb.toString();
    }

    @Override
    public void testAlgorithm() throws IOException {
        InterestingJourney.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output;
    }

    @Override
    public String getExpectedResult(TestCaseModel testCase) {
        return String.valueOf(testCase.expectedResult);
    }

    @Override
    public String getSimpleClassName() {
        return InterestingJourney.class.getSimpleName();
    }
}
