package high.skill.girl.learns.algorithms.tasks.impl;

import high.skill.girl.learns.algorithms.tasks.AnagramsYandex;
import high.skill.girl.learns.algorithms.tasks.TestCasesTestable;

import java.io.IOException;

public class AnagramsYandexTest implements TestCasesTestable<AnagramsYandexTest.TestCaseModel> {

    public record TestCaseModel(String[] input, int expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[]{
        new TestCaseModel(new String[]{"qiu", "iuq"}, 1),
        new TestCaseModel(new String[]{"zprl", "zprc"}, 0),
        new TestCaseModel(new String[]{"aabb", "abca"}, 0),
        new TestCaseModel(new String[]{"ab", "v"}, 0),
    };

    public static void main(String[] args) throws IOException {
        new AnagramsYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCase) {
        return testCase.input[0] + "\n" + testCase.input[1];
    }

    @Override
    public void testAlgorithm() throws IOException {
        AnagramsYandex.main(new String[]{});
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
        return AnagramsYandex.class.getSimpleName();
    }
}
