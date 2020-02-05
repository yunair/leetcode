package tree.path

import common.TreeNode

/**
 * 求根到叶子节点数字之和
 */
class P129SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return sumNumbersSolve(root, 0)
    }

    private fun sumNumbersSolve(node: TreeNode?, cur: Int): Int {
        if (node == null) {
            return cur
        }

        val result = cur * 10 + node.`val`
        if (node.left == null && node.right == null) {
            return result
        }
        val left = if (node.left != null) {
            sumNumbersSolve(node.left, result)
        } else {
            0
        }

        val right = if (node.right != null) {
            sumNumbersSolve(node.right, result)
        } else {
            0
        }
        return left + right
    }
}