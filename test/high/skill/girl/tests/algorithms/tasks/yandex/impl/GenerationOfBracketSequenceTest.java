package high.skill.girl.tests.algorithms.tasks.yandex.impl;

import high.skill.girl.learns.algorithms.tasks.yandex.GenerationOfBracketSequence;
import high.skill.girl.tests.algorithms.tasks.yandex.TestCasesInterface;

import java.io.IOException;

public class GenerationOfBracketSequenceTest implements TestCasesInterface<GenerationOfBracketSequenceTest.TestCaseModel> {

    public record TestCaseModel(int n, String expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[] {
        new TestCaseModel(1, "()"),
        new TestCaseModel(2, "(()) ()()"),
        new TestCaseModel(3, "((())) (()()) (())() ()(()) ()()()")
    };

    public static void main(String[] args) throws IOException {
        new GenerationOfBracketSequenceTest().test();
    }

    @Override
    public GenerationOfBracketSequenceTest.TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(GenerationOfBracketSequenceTest.TestCaseModel testCase) {
        return String.valueOf(testCase.n);
    }

    @Override
    public void testAlgorithm() throws IOException {
        GenerationOfBracketSequence.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output.replaceAll("\n", " ");
    }

    @Override
    public String getExpectedResult(GenerationOfBracketSequenceTest.TestCaseModel testCase) {
        return testCase.expectedResult;
    }

    @Override
    public String getSimpleClassName() {
        return GenerationOfBracketSequence.class.getSimpleName();
    }
}
