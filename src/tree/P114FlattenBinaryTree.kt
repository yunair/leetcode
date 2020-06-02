package tree

import common.TreeNode
import util.TreeUtil

/**
 * 二叉树展开为链表
 */
object P114FlattenBinaryTree {
    fun flatten(root: TreeNode?) {
        dfs(root)
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }

        dfs(node.left)
        dfs(node.right)
        val left = node.left
        val right = node.right

        if (left != null && right != null) {
            var leftLast = left
            while (leftLast?.right != null) {
                leftLast = leftLast.right
            }
            leftLast?.right = right
            node.right = left
        } else if (left != null) {
            node.right = left
        } else if (right != null) {
            node.right = right
        }
        node.left = null

    }
}

fun main() {
    val root = TreeUtil.buildTree(arrayOf(1, 2, 5, 3, 4, null, 6))
    P114FlattenBinaryTree.flatten(root)
    TreeUtil.printTreeNode(root)
}