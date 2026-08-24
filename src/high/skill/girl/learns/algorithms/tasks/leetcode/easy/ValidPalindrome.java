package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Фраза является палиндромом, если после преобразования всех заглавных букв в строчные и удаления всех небуквенно-цифровых
символов она читается одинаково как в прямом, так и в обратном порядке. Буквенно-цифровые символы включают буквы и цифры.
Полученная строка s должна возвращать true, если она является палиндромом, или false в противном случае.

Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
                 Since an empty string reads the same forward and backward, it is a palindrome.

s consists only of printable ASCII characters.

сложность по памяти: O(1)
сложность по времени: O(n)
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,")); // true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true
    }

    private static boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex && !Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            }

            while (leftIndex <= rightIndex && !Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            }

            if (leftIndex > rightIndex) // в границах ничего не осталось
                return true;

            if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex)))
                return false;

            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
