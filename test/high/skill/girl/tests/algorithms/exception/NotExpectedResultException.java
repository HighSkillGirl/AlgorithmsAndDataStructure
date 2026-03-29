package high.skill.girl.tests.algorithms.exception;

public class NotExpectedResultException extends RuntimeException {

    private final String algoName;
    private final String actual;
    private final String expected;

    public NotExpectedResultException(String algoName, String actual, String expected) {
        this.algoName = algoName;
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    public String getMessage() {
        return String.format("Получен неожидаемый результат тестирования алгоритма %s: actual = %s, expected = %s", algoName, actual, expected);
    }
}
