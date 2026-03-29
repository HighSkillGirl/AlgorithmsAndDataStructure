package high.skill.girl.learns.algorithms.tasks.impl;

import high.skill.girl.learns.algorithms.tasks.StonesAndJewelryYandex;
import high.skill.girl.learns.algorithms.tasks.TestCasesInterface;
import java.io.*;

public class StonesAndJewelryYandexTest implements TestCasesInterface<StonesAndJewelryYandexTest.TestCaseModel> {

    public record TestCaseModel (String jewelry, String stones, int expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[]
            {
                new TestCaseModel("a", "a", 1),
                new TestCaseModel("a", "A", 0),
                new TestCaseModel("ab", "ac", 1),
                new TestCaseModel("ab", "abc", 2),
                new TestCaseModel("a", "a0", 1),
                new TestCaseModel("a", "-a", 1)
            };

    public static void main(String[] args) throws IOException {
        new StonesAndJewelryYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCase) {
        return testCase.jewelry + "\n" + testCase.stones + "\n";
    }

    @Override
    public void testAlgorithm() throws IOException {
        StonesAndJewelryYandex.main(new String[]{});
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
        return StonesAndJewelryYandex.class.getSimpleName();
    }
}