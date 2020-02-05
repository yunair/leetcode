package tree.bst;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 */
class P173BSTIterator {
    private List<Integer> list = new ArrayList<>();

    public P173BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
