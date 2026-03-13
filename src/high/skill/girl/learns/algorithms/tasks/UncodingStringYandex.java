package high.skill.girl.learns.algorithms.tasks;

public class UncodingStringYandex {

    public static void main(String[] args) {
        String input = "8512#12#15#89"; //31665 //8512#12#15#89
        uncodeAlgorithmV1(input);
    }

    private static void uncodeAlgorithmV1(String input) {
        StringBuilder result = new StringBuilder(input);
        int hashIndex = input.indexOf('#');

        while (hashIndex != -1) {
            String a = result.substring(hashIndex - 2, hashIndex + 1);
            result.replace(hashIndex - 2, hashIndex + 1, "" + uncodeSubstring(a));
            hashIndex = result.indexOf("#");
        }

        for (int i = 0; i < result.length(); i++) {
            char symbol = result.charAt(i);
            if (Character.isDigit(symbol)) {
                int symbolNumber = symbol - '0';
                char letter = (char) ('a' + symbolNumber - 1);
                result.setCharAt(i, letter);
            }
        }

        System.out.println(result);
    }

    private static char uncodeSubstring(String subString) {
        int symbolNumber = (subString.charAt(0) - '0') * 10 + (subString.charAt(1) - '0');
        return (char) ('a' + symbolNumber - 1);
    }

}