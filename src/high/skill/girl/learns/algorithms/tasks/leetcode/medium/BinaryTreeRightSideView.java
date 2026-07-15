package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Имея корень бинарного дерева, представьте, что вы стоите справа от него, и верните значения узлов, которые вы видите, упорядоченные сверху вниз.
Суть решения в том, что нужный элемент всегда лежит в последней итерации цикла на уровне

сложность по времени: O(n)
слложность по памяти: O(n)
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        System.out.println(rightSideView(new TreeNode(1,
                                new TreeNode(2,
                                null, new TreeNode(5)),
                                                                new TreeNode(3,
                                                                    null, new TreeNode(4))))); // [1, 3, 4]

        System.out.println(rightSideView(null)); // []
    }

    private static List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                var currentNode = deque.poll();
                if (i + 1 == size)
                    result.add(currentNode.val);

                if (currentNode.left != null)
                    deque.offer(currentNode.left);
                if (currentNode.right != null)
                    deque.offer(currentNode.right);
            }
        }
         return result;
    }
}
