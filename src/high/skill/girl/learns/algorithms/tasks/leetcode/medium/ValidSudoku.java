package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Определите, является ли доска судоку 9х9 допустимой. Для проверки необходимо учитывать только заполненные ячейки в соответствии со следующими правилами:

Каждая строка должна содержать цифры от 1 до 9 без повторений.
Каждый столбец должен содержать цифры от 1 до 9 без повторений.
Каждая из девяти ячеек сетки 3х3 должна содержать цифры от 1 до 9 без повторений.

Примечание:
Частично заполненная доска судоку может быть допустимой, но не обязательно решаемой.
Проверке необходимо учитывать только заполненные ячейки в соответствии с указанными правилами.

Example 1:
    Input: board = 
        [['5','3','.','.','7','.','.','.','.']
        ,['6','.','.','1','9','5','.','.','.']
        ,['.','9','8','.','.','.','.','6','.']
        ,['8','.','.','.','6','.','.','.','3']
        ,['4','.','.','8','.','3','.','.','1']
        ,['7','.','.','.','2','.','.','.','6']
        ,['.','6','.','.','.','.','2','8','.']
        ,['.','.','.','4','1','9','.','.','5']
        ,['.','.','.','.','8','.','.','7','9']]
    Output: true

Example 2:
    Input: board = 
        [['8','3','.','.','7','.','.','.','.']
        ,['6','.','.','1','9','5','.','.','.']
        ,['.','9','8','.','.','.','.','6','.']
        ,['8','.','.','.','6','.','.','.','3']
        ,['4','.','.','8','.','3','.','.','1']
        ,['7','.','.','.','2','.','.','.','6']
        ,['.','6','.','.','.','.','2','8','.']
        ,['.','.','.','4','1','9','.','.','5']
        ,['.','.','.','.','8','.','.','7','9']]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]
                {
                        new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));

        System.out.println(isValidSudoku(new char[][]
                {
                        new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                        new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                        new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                        new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                }));
    }

    private static boolean isValidSudoku(char[][] board) {
        for (int line = 0; line < board.length; line++) {
            Set<Character> horizontalSet = new HashSet<>();
            for (int column = 0; column < board.length; column++) {
                char horizontalValue = board[line][column];
                if (tryAddDigitCharToSet(horizontalValue, horizontalSet))
                    return false;
            }
        }

        for (int column = 0; column < board.length; column++) {
            Set<Character> verticalSet = new HashSet<>();
            for (int line = 0; line < board.length; line++) {
                char verticalValue = board[line][column];
                if (tryAddDigitCharToSet(verticalValue, verticalSet))
                    return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {

                Set<Character> boxSet = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {

                        char boxValue = board[i + k][j + m];
                        if (tryAddDigitCharToSet(boxValue, boxSet))
                            return false;
                    }
                }
            }
        }
        
        return true;
    }

    private static boolean tryAddDigitCharToSet(char value, Set<Character> set) {
        return value != '.' && !set.add(value);
    }
}
