package high.skill.girl.learns.algorithms.tasks;

public class UncodingStringYandex {

    public static void main(String[] args) {
        String input = "31665"; //8512#12#15#89
        StringBuilder result = new StringBuilder(input);

        int hashIndex = input.indexOf('#');

        while (hashIndex != -1) {
            String a = result.substring(hashIndex - 2, hashIndex + 1);
            result.replace(hashIndex - 2, hashIndex + 1, "" + uncodeSubstring(a));
            hashIndex = result.indexOf("#");
        }

        for (int i = 0; i < result.length(); i++) {
            char symbol = result.charAt(i);
            if (!Character.isAlphabetic(symbol)) {
                String symbolNumberString = String.valueOf(symbol);
                int symbolNumber = Integer.parseInt(symbolNumberString);
                char letter = (char) ('a' + symbolNumber - 1);
                result.replace(i, i + 1, String.valueOf(letter));
            }
        }

        System.out.println(result);
    }

    private static char uncodeSubstring(String subString) {
        StringBuilder twoSymbolLetter = new StringBuilder();
        for (int i = 0; i < subString.length() - 1; i++) {
            char symbol = subString.charAt(i);
            twoSymbolLetter.append(symbol);
        }
        int symbolNumber = Integer.parseInt(twoSymbolLetter.toString());
        return (char) ('a' + symbolNumber - 1);
    }

}