package tree.traversal

import common.TreeNode

/**
 * 二叉树中的最大路径和
 */
object P124MaxPathSum {
    private var max = 0
    fun maxPathSum(root: TreeNode?): Int {
        max = Int.MIN_VALUE
        postOrder(root)
        return max
    }

    private fun postOrder(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        val left = maxOf(postOrder(node.left), 0)
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        val right = maxOf(postOrder(node.right), 0)
        // left->root->right 作为路径与历史最大值做比较
        max = maxOf(max, node.`val` + left + right)
        // 返回经过root的单边最大分支给上游
        return node.`val` + maxOf(left, right)
    }

}