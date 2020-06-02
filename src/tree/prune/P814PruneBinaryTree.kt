package tree.prune

import common.TreeNode
import util.TreeUtil

/**
 * 二叉树剪枝
 */
object P814PruneBinaryTree {
    /**
     * 后续遍历
     * 发现左子树没子节点且为0，剪掉改侧子树
     */
    fun pruneTree(root: TreeNode?): TreeNode? {
        return dfs(root)
    }

    private fun dfs(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }

        val left = dfs(node.left)
        val right = dfs(node.right)
        if (left != null && left.`val` == 0 && noLeaf(left)) {
            node.left = null
        }

        if (right != null && right.`val` == 0 && noLeaf(right)) {
            node.right = null
        }
        return node
    }

    private fun noLeaf(node: TreeNode): Boolean {
        return node.left == null && node.right == null
    }

    fun pruneTreeBetter(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)

        if (root.`val` == 0 && root.left == null && root.right == null) {
            return null
        }

        return root
    }
}

fun main() {
    val root = TreeNode(1)
    root.apply {
        left = TreeNode(0)
        right = TreeNode(0)
    }
    root.left!!.apply {
        left = TreeNode(0)
        right = TreeNode(0)
    }
    root.right!!.apply {
        left = TreeNode(0)
        right = TreeNode(1)
    }
    TreeUtil.printTreeNode(P814PruneBinaryTree.pruneTree(root))
}