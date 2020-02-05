package tree.level;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 */
class P637BinaryTreeAverageLevel {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            double sum = 0;
            // 处理同一层级的TreeNode
            for (int i = 0; i < size; i++) {
                final TreeNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(sum / size);
        }


        return result;
    }
}
