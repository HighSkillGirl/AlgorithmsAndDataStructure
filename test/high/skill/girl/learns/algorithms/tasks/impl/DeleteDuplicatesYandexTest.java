package high.skill.girl.learns.algorithms.tasks.impl;

import high.skill.girl.learns.algorithms.tasks.DeleteDuplicatesYandex;
import high.skill.girl.learns.algorithms.tasks.TestCasesTestable;

import java.io.IOException;

public class DeleteDuplicatesYandexTest implements TestCasesTestable<DeleteDuplicatesYandexTest.TestCaseModel> {

    public record TestCaseModel (int n, String duplicatesString, String expectedString) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[] {
            new TestCaseModel(5, "2, 4, 8, 8, 8", "2, 4, 8")
    };

    public static void main(String[] args) throws IOException {
        new DeleteDuplicatesYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCase) {
        return testCase.n + "\n" + testCase.duplicatesString.replaceAll(", ", "\n");
    }

    @Override
    public void testAlgorithm() throws IOException {
        DeleteDuplicatesYandex.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output.replaceAll("\n", ", ");
    }

    @Override
    public String getExpectedResult(TestCaseModel testCase) {
        return testCase.expectedString;
    }

    @Override
    public String getSimpleClassName() {
        return DeleteDuplicatesYandex.class.getSimpleName();
    }
}
