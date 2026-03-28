package high.skill.girl.learns.algorithms.tasks;

import high.skill.girl.learns.algorithms.exception.NotExpectedResultException;

import java.io.*;

public interface TestCasesTestable<T> {

    default void test() throws IOException {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            for (T testCase : getTestCases()) {
                String testInput = getTestInput(testCase);
                ByteArrayInputStream testIn = new ByteArrayInputStream(testInput.getBytes());
                System.setIn(testIn);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream testOut = new PrintStream(outputStream);
                System.setOut(testOut);

                testAlgorithm();
                String actualOutput = outputStream.toString().trim();
                String actualResult = cleanOutput(actualOutput);

                System.setIn(originalIn);
                System.setOut(originalOut);

                String expectedResult = getExpectedResult(testCase);
                if (!isResultCorrect(actualResult, expectedResult)) {
                    throw new NotExpectedResultException(getSimpleClassName(), actualResult, expectedResult);
                }
            }
            System.out.println("Все тест-кейсы пройдены успешно!");
        } catch (NotExpectedResultException e) {
            System.out.println(e.getMessage());
        }
    }

    T[] getTestCases();
    String getTestInput(T t);
    void testAlgorithm() throws IOException;
    String cleanOutput(String output);
    String getExpectedResult(T t);
    String getSimpleClassName();

    default boolean isResultCorrect(String actual, String expected) {
        return actual.equals(expected);
    }
}
