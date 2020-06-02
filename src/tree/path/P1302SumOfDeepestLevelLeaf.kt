package tree.path

import common.TreeNode
import java.util.*

/**
 * 层数最深叶子节点的和
 */
object P1302SumOfDeepestLevelLeaf {
    /**
     * 可以遍历中直接求和
     */
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var result = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0
            for (i in 0 until size) {
                val current = queue.poll()
                sum += current.`val`
                current.left?.let {
                    queue.add(it)
                }

                current.right?.let {
                    queue.add(it)
                }
            }
            result = sum
        }

        return result
    }
}

fun main() {
    val root = TreeNode(1)
    root.apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    root.left!!.apply {
        left = TreeNode(4)
        right = TreeNode(5)
    }
    root.right!!.apply {
        right = TreeNode(6)
    }
    root.left!!.left!!.left = TreeNode(7)
    root.right!!.right!!.right = TreeNode(8)
    println(P1302SumOfDeepestLevelLeaf.deepestLeavesSum(root))
}