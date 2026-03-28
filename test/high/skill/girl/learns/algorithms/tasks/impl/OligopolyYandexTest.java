package high.skill.girl.learns.algorithms.tasks.impl;

import high.skill.girl.learns.algorithms.tasks.OligopolyYandex;
import high.skill.girl.learns.algorithms.tasks.TestCasesTestable;

import java.io.IOException;

public class OligopolyYandexTest implements TestCasesTestable<OligopolyYandexTest.TestCaseModel> {

    public record TestCaseModel (int playersCount, String capitals, String expectedResult) { }

    private static final OligopolyYandexTest.TestCaseModel[] testCases = new TestCaseModel[]
            {
                    new TestCaseModel(0, "", ""),
                    new TestCaseModel(1, "1", "1"),
                    new TestCaseModel(1, "-1", "1"),
                    new TestCaseModel(4, "1 1 1 1", "0 0 0 0"),
                    new TestCaseModel(4, "1 1 2 2", "0 0 1 1"),
                    new TestCaseModel(4, "1 1 3 4", "0 0 1 1"),
                    new TestCaseModel(4, "1 2 3 4", "0 0 1 1"),
                    new TestCaseModel(9, "1 1 3 4 9 11 13 14", "0 0 1 1 1 1 1 1 1")
            };

    public static void main(String[] args) throws IOException {
        new OligopolyYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCaseModel) {
        return testCaseModel.playersCount + "\n" + testCaseModel.capitals;
    }

    @Override
    public void testAlgorithm() throws IOException {
        OligopolyYandex.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output.replaceAll("\n", " ");
    }

    @Override
    public String getExpectedResult(TestCaseModel testCaseModel) {
        return testCaseModel.expectedResult;
    }

    @Override
    public String getSimpleClassName() {
        return OligopolyYandex.class.getSimpleName();
    }
}
