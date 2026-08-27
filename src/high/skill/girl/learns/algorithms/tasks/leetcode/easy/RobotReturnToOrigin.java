package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Робот начинает движение из точки (0, 0), начала координат, на двумерной плоскости.
Имея последовательность его движений, определите, окажется ли робот в точке (0, 0) после завершения всех своих движений.

Вам дана строка moves, представляющая последовательность движений робота, где moves[i] обозначает его i-е движение.
Допустимые движения: 'R' (вправо), 'L' (влево), 'U' (вверх) и 'D' (вниз).

Верните true, если робот возвращается в начало координат после завершения всех своих движений, или false в противном случае.

Примечание: направление, в котором «обращен» робот, не имеет значения. 'R' всегда заставит робота двигаться вправо один раз,
'L' всегда заставит его двигаться влево и т.д. Также предположите, что величина движения робота одинакова для каждого движения.

moves only contains the characters 'U', 'D', 'L' and 'R'.

сложность по памяти: O(1)
сложность по времени: O(n)
 */

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD")); // true
        System.out.println(judgeCircle("LL")); // false
    }

    private static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R' -> x++;
                case 'L' -> x--;
                case 'U' -> y++;
                case 'D' -> y--;
            }
        }

        return x == 0 && y == 0;
    }
}
