package high.skill.girl.learns.algorithms.tasks.impl;

import high.skill.girl.learns.algorithms.tasks.UncodingStringYandex;
import high.skill.girl.learns.algorithms.tasks.TestCasesTestable;
import java.io.IOException;

public class UncodingStringYandexTest implements TestCasesTestable<UncodingStringYandexTest.TestCaseModel> {

    public record TestCaseModel (String input, String expectedResult) { }

    private static final TestCaseModel[] testCases = new TestCaseModel[]
            {
                new TestCaseModel("31665", "caffe"),
                new TestCaseModel("8512#12#15#89", "hellohi"),
                new TestCaseModel("1212#", "abl")
            };

    public static void main(String[] args) throws IOException {
        new UncodingStringYandexTest().test();
    }

    @Override
    public TestCaseModel[] getTestCases() {
        return testCases;
    }

    @Override
    public String getTestInput(TestCaseModel testCaseModel) {
        return testCaseModel.input;
    }

    @Override
    public void testAlgorithm() throws IOException {
        UncodingStringYandex.main(new String[]{});
    }

    @Override
    public String cleanOutput(String output) {
        return output;
    }

    @Override
    public String getExpectedResult(TestCaseModel testCaseModel) {
        return testCaseModel.expectedResult;
    }

    @Override
    public String getSimpleClassName() {
        return UncodingStringYandex.class.getSimpleName();
    }
}
