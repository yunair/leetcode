package tree.depth

import common.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * 平衡二叉树
 * 判断树是否是高度平衡的二叉树（左右子树的高度不相差1）
 */
class P110BalanceBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val left = maxDepth(root.left)
        val right = maxDepth(root.right)

        return abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val curLeft = maxDepth(root.left)
        val curRight = maxDepth(root.right)
        return max(curLeft, curRight) + 1
    }
}