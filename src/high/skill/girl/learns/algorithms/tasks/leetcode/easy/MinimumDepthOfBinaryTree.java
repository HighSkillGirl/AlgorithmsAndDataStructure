package high.skill.girl.learns.algorithms.tasks.leetcode.easy;

/*
Дано бинарное дерево. Найдите его минимальную глубину.
Минимальная глубина — это количество узлов на кратчайшем пути от корневого узла до ближайшего листового узла.
Примечание: Листовой узел — это узел, не имеющий дочерних узлов.
Корень - глубина 1.

сложность по памяти O(n)
сложность по времени (n)
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(minDepth(new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                                new TreeNode(15), new TreeNode(7)))));

        System.out.println(minDepth(new TreeNode(2,
                                    null, new TreeNode(3,
                                            null, new TreeNode(4,
                                                        null, new TreeNode(5,
                                                                    null, new TreeNode(6)))))));

        System.out.println(minDepth(new TreeNode(1,
                                new TreeNode(2,
                            new TreeNode(4), new TreeNode(5)), new TreeNode(3))));

        System.out.println(minDepth(new TreeNode(1, new TreeNode(2), null)));

    }

    private static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int levelCount = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            levelCount++;
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = deque.poll();
                if (currentNode.left != null)
                    deque.offer(currentNode.left);
                if (currentNode.right != null)
                    deque.offer(currentNode.right);
                if (currentNode.right == null && currentNode.left == null)
                    return levelCount;
            }
        }

        return levelCount;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}