package tree.level

import common.TreeNode
import java.util.*

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
class P103ZigzagLevelOrder {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }

        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var level = 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            val list = mutableListOf<Int>()
            val fromLeft = level % 2 != 0
            for (i in 0 until size) {
                val current = queue.poll()
                if (fromLeft) {
                    // left to right
                    list.add(current.`val`)
                } else {
                    // right to left
                    list.add(0, current.`val`)
                }
                current.left?.let {
                    queue.add(it)
                }
                current.right?.let {
                    queue.add(it)
                }
            }

            level++
            result.add(list)
        }

        return result
    }
}