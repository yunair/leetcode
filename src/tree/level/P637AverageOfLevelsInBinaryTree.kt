package tree.level

import common.TreeNode
import util.TreeUtil
import java.util.*
import kotlin.collections.ArrayList

/**
 * 二叉树的层平均值
 */
object P637AverageOfLevelsInBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) {
            return DoubleArray(1)
        }
        val queue = LinkedList<TreeNode>()
        val list = ArrayList<Double>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var value = 0.0
            for (i in 0 until size) {
                val node = queue.pop()
                value += node.`val`
                node.left?.let {
                    queue.add(it)
                }
                node.right?.let {
                    queue.add(it)
                }
            }
            list.add(value / size)
        }

        return list.toDoubleArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(averageOfLevels(TreeUtil.toTree(3, 9, 20, 15, 7)).contentToString())
    }
}