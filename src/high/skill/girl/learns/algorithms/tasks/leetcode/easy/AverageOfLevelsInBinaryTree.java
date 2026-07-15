package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Имея корень бинарного дерева, верните среднее значение узлов на каждом уровне в виде массива. Принимаются ответы, отличающиеся от правильного ответа на 10^5.

сложность по памяти O(n)
сложность по времени O(n)
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        System.out.println(averageOfLevels(new TreeNode(3,
                                new TreeNode(9), new TreeNode(20,
                                            new TreeNode(15), new TreeNode(7)))));

        System.out.println(averageOfLevels(new TreeNode(3,
                                new TreeNode(9,
                        new TreeNode(15), new TreeNode(7)), new TreeNode(20))));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0; // может быть переполнение

            for (int i = 0; i < size; i++) {
                var currentNode = deque.poll();
                sum += currentNode.val;

                if (currentNode.left != null)
                    deque.offer(currentNode.left);
                if (currentNode.right != null)
                    deque.offer(currentNode.right);
            }

            result.add(sum / (double) size);

        }

        return result;
    }
}