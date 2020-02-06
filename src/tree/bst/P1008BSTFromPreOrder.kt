package tree.bst

import common.TreeNode
import util.TreeUtil

/**
 * 先序遍历构造二叉树
 */
class P1008BSTFromPreOrder {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }

        val root = TreeNode(preorder[0])

        for (i in 1 until preorder.size) {
            insertNode(root, preorder[i])
        }

        return root
    }

    private fun insertNode(node: TreeNode?, `val`: Int): TreeNode? {
        if (node == null) {
            return TreeNode(`val`)
        }

        if (node.`val` > `val`) {
            node.left = insertNode(node.left, `val`)
        } else {
            node.right = insertNode(node.right, `val`)
        }
        return node
    }
}

fun main() {
    val test = P1008BSTFromPreOrder()
    TreeUtil.printTreeNode(test.bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)))
}