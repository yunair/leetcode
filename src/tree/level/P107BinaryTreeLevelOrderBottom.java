package tree.level;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 II
 * 返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
class P107BinaryTreeLevelOrderBottom {
    private static class TreeNodeLevel {
        final TreeNode node;
        final int level;

        public TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root, 1));
        while (!queue.isEmpty()) {
            TreeNodeLevel current = queue.poll();
            if (list.size() < current.level) {
                List<Integer> values = new ArrayList<>();
                values.add(current.node.val);
                list.add(0, values);
            } else {
                list.get(0).add(current.node.val);
            }
            if (current.node.left != null) {
                queue.add(new TreeNodeLevel(current.node.left, current.level + 1));
            }

            if (current.node.right != null) {
                queue.add(new TreeNodeLevel(current.node.right, current.level + 1));
            }
        }
        return list;
    }
}
