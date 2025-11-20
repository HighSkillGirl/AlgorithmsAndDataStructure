package high.skill.girl.learns.algorithms.test.tasks;

import high.skill.girl.learns.algorithms.tasks.GenerationOfBracketSequenceYandex;

import java.io.IOException;

public class GenerationOfBracketSequenceYandexTest implements Testable<GenerationOfBracketSequenceYandexTest.TestCaseModel> {

    public record TestCaseModel(int n, String expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[] {
        new TestCaseModel(1, "()"),
        new TestCaseModel(2, "(()) ()()"),
        new TestCaseModel(3, "((())) (()()) (())() ()(()) ()()()")
    };

    public static void main(String[] args) throws IOException {
        new GenerationOfBracketSequenceYandexTest().test();
    }

    @Override
    public GenerationOfBracketSequenceYandexTest.TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(GenerationOfBracketSequenceYandexTest.TestCaseModel testCase) {
        return String.valueOf(testCase.n);
    }

    @Override
    public void testAlgorithm() throws IOException {
        GenerationOfBracketSequenceYandex.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output.replaceAll("\n", " ");
    }

    @Override
    public String getExpectedResult(GenerationOfBracketSequenceYandexTest.TestCaseModel testCase) {
        return testCase.expectedResult;
    }

    @Override
    public boolean isResultCorrect(String actual, String expected) {
        return actual.equals(expected);
    }

    @Override
    public String getSimpleClassName() {
        return GenerationOfBracketSequenceYandex.class.getSimpleName();
    }
}
