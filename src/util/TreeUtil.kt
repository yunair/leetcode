package util

import common.TreeNode
import java.util.*


object TreeUtil {
    @JvmStatic
    @JvmOverloads
    fun printTreeNode(node: TreeNode?, level: Int = 0) {
        if (node == null) {
            println("${level}:null")
            return
        }
        println("${level}:${node.`val`}")
        if (node.left == null && node.right == null) {
            return
        }
        printTreeNode(node.left, level + 1)
        printTreeNode(node.right, level + 1)

    }

    @JvmStatic
    fun buildTree(array: Array<Int?>): TreeNode? {
        if (array.isEmpty()) {
            return null
        }
        val rootValue = array[0] ?: return null

        val root = TreeNode(rootValue)
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var index = 1
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (index >= array.size) {
                break
            }

            val left = array[index++]

            if (left != null) {
                current.left = TreeNode(left)
                queue.add(current.left!!)
            }
            if (index >= array.size) {
                break
            }
            val right = array[index++]
            if (right != null) {
                current.right = TreeNode(right)
                queue.add(current.right!!)
            }
        }

        return root
    }
}

fun main() {
    TreeUtil.printTreeNode(TreeUtil.buildTree(arrayOf(2, 2, 1, null, 1, 0, null, 0)))
}