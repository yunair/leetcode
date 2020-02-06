package tree.traversal

import common.TreeNode
import util.TreeUtil

/**
 * 根据前序和后序遍历构造二叉树
 */
class P889ConstructFromPrePost {
    /**
     * 我们令左分支有 L 个节点。我们知道左分支的头节点为 pre[1]，但它也出现在左分支的后序表示的最后。所以 pre[1] = post[L-1]（因为结点的值具有唯一性），
     * 因此 L = post.indexOf(pre[1]) + 1。
     *
     * 现在在我们的递归步骤中，左分支由 pre[1 : L+1] 和 post[0 : L] 重新分支，而右分支将由 pre[L+1 : N] 和 post[L : N-1] 重新分支。
     */
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        val size = pre.size
        if (size == 0) {
            return null
        }
        val root = TreeNode(pre[0])
        if (size == 1) {
            return root
        }

        val postLeftEndIndex = post.indexOf(pre[1])
        val leftSize = postLeftEndIndex + 1
        if (1 + leftSize >= size) {
            // 没有右子树
            root.left = constructFromPrePost(pre.copyOfRange(1, leftSize + 1), post.copyOfRange(0, leftSize))
        } else {
            // 右子树存在
            val postRightEndIndex = post.indexOf(pre[1 + leftSize])
            root.left = constructFromPrePost(pre.copyOfRange(1, leftSize + 1), post.copyOfRange(0, leftSize))
            root.right = constructFromPrePost(
                pre.copyOfRange(1 + leftSize, size),
                post.copyOfRange(leftSize, postRightEndIndex + 1)
            )
        }

        return root
    }
}

fun main() {
    val test = P889ConstructFromPrePost()
    TreeUtil.printTreeNode(test.constructFromPrePost(intArrayOf(1, 2, 4, 5, 3, 6, 7), intArrayOf(4, 5, 2, 6, 7, 3, 1)))
}