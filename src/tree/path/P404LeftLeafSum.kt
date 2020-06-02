package tree.path

import common.TreeNode
import java.util.*

/**
 * 左叶子之和
 */
object P404LeftLeafSum {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val queue = LinkedList<TreeNode>()
        val results = mutableListOf<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current != null) {
                current.left?.let {
                    results.add(it)
                    queue.add(it)
                }
                current.right?.let {
                    queue.add(it)
                }
            }
        }

        return results.filter {
            it.left == null && it.right == null
        }.sumBy {
            it.`val`
        }

    }
}