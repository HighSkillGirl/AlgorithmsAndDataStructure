package high.skill.girl.learns.algorithms.tasks.leetcode.medium;

/*
Получив корень бинарного дерева, верните пошаговый обход его узлов (т.е. слева направо, уровень за уровнем).

Input:
    root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Решается как BFS (поиск в ширину) через очередь

сложность по памяти O(n)
сложности по времени O(n)
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println(levelOrder(new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                            new TreeNode(15), new TreeNode(7)))));

        System.out.println(levelOrder(new TreeNode(1)));
        System.out.println(levelOrder(null));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> levelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = deque.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null)
                    deque.offer(currentNode.left);
                if (currentNode.right != null)
                    deque.offer(currentNode.right);
            }

            result.add(levelList);
        }

        return result;
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
