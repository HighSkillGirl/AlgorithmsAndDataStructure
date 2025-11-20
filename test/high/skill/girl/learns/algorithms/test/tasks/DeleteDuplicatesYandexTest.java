package high.skill.girl.learns.algorithms.test.tasks;

import high.skill.girl.learns.algorithms.tasks.DeleteDuplicatesYandex;

import java.io.IOException;

public class DeleteDuplicatesYandexTest implements Testable<DeleteDuplicatesYandexTest.TestCaseModel> {

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
    public String getExpectedResult(TestCaseModel testCase) {
        return testCase.expectedString;
    }

    @Override
    public boolean isResultCorrect(String actual, String expected) {
        return actual.equals(expected);
    }

    @Override
    public String getSimpleClassName() {
        return DeleteDuplicatesYandex.class.getSimpleName();
    }
}
