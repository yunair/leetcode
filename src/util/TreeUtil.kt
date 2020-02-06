package util

import common.TreeNode


object TreeUtil {
    @JvmStatic
    fun printTreeNode(node: TreeNode?) {
        if (node == null) {
            println("null")
            return
        }
        println(node.`val`)
        if (node.left == null && node.right == null) {
            return
        }
        printTreeNode(node.left)
        printTreeNode(node.right)

    }
}