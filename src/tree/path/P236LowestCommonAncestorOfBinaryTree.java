package tree.path;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
class P236LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<Integer> queue = new LinkedList<>();
        inOrder(root, queue);


        return root;
    }

    private void inOrder(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }

        inOrder(node.left, queue);
        queue.add(node.val);
        inOrder(node.right, queue);
    }

}
