package tree.depth

import common.TreeNode
import kotlin.math.min

class P111MinDepthBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val curLeft = minDepth(root.left)
        val curRight = minDepth(root.right)

        if (curLeft == 0 || curRight == 0) {
            return curLeft + curRight + 1
        }

        return min(curLeft, curRight) + 1
    }
}