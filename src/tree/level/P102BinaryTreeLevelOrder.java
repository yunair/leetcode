package tree.level;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地, 每一层都放到一个链表内，从左到右访问所有节点）。
 */
class P102BinaryTreeLevelOrder {
    private static class TreeNodeLevel {
        final TreeNode node;
        final int level;

        public TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
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
                list.add(values);
            } else {
                list.get(current.level - 1).add(current.node.val);
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
