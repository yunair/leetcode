package tree.depth

import common.TreeNode
import kotlin.math.max


/**
 * 二叉树最大深度
 */
class P104MaxDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val curLeft = maxDepth(root.left)
        val curRight = maxDepth(root.right)
        return max(curLeft, curRight) + 1
    }
}