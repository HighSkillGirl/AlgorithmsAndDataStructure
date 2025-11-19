package high.skill.girl.learns.algorithms.test.tasks;

import high.skill.girl.learns.algorithms.tasks.CountUnitsInBinVectorYandex;
import high.skill.girl.learns.algorithms.tasks.StonesAndJewelryYandex;
import high.skill.girl.learns.algorithms.test.exception.NotExpectedResultException;

import java.io.*;

public class CountUnitsInBinVectorYandexTest {

    private static final CountUnitsInBinVectorYandexTest.TestCaseModel[] testCases = new CountUnitsInBinVectorYandexTest.TestCaseModel[]
            {
                new TestCaseModel(1, new int[]{1}, 1),
                new TestCaseModel(1, new int[]{0}, 0),
                new TestCaseModel(5, new int[]{1, 1, 1, 0, 1}, 3),
                new TestCaseModel(10_001, new int[]{1}, 0),

            };

    public static void main(String[] args) throws IOException {

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            for (TestCaseModel testCase : testCases) {
                StringBuilder sb = new StringBuilder();
                sb.append(testCase.n).append("\n");
                for (int j = 0; j < testCase.binVector.length; j++) {
                    sb.append(testCase.binVector[j]).append("\n");
                }
                ByteArrayInputStream testIn = new ByteArrayInputStream(sb.toString().getBytes());
                System.setIn(testIn);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream testOut = new PrintStream(outputStream);
                System.setOut(testOut);

                CountUnitsInBinVectorYandex.main(new String[]{});
                String output = outputStream.toString().trim();
                int actual = Integer.parseInt(output);

                System.setIn(originalIn);
                System.setOut(originalOut);

                if (actual != testCase.expectedResult) {
                    throw new NotExpectedResultException(StonesAndJewelryYandex.class.getSimpleName(), actual, testCase.expectedResult);
                }
            }
        } catch (NotExpectedResultException e) {
            System.out.println(e.getMessage());
        }
    }

    private static class TestCaseModel {
        int n;
        int[] binVector;
        int expectedResult;

        public TestCaseModel(int n, int[] binVector, int expectedResult) {
            this.n = n;
            this.binVector = binVector;
            this.expectedResult = expectedResult;
        }
    }
}
