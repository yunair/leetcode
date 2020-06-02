package tree.traversal

import common.TreeNode
import util.TreeUtil
import java.util.*
import kotlin.test.assertEquals

/**
 * 二叉树的右视图
 */
object P199BinaryTreeRightSideView {
    /**
     *
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val ans = mutableListOf<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (i == size - 1) {
                    ans.add(node.`val`)
                }

                node.left?.let {
                    queue.add(it)
                }

                node.right?.let {
                    queue.add(it)
                }
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(listOf(1, 3, 4), rightSideView(TreeUtil.toTree(1,2,3,null,5,null,4)))
    }
}