package tree.traversal

import common.TreeNode
import util.TreeUtil
import java.util.*

/**
 * 二叉树的中序遍历
 */
object P94InorderTraversalBinaryTree {
    fun inorderTraversalIter(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }
        val stack = LinkedList<TreeNode>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            node = stack.pop()
            ans.add(node.`val`)
            node = node.right
        }
        return ans
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        inorder(root, ans)
        return ans
    }

    private fun inorder(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) {
            return
        }

        inorder(node.left, list)
        list.add(node.`val`)
        inorder(node.right, list)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            inorderTraversalIter(TreeUtil.buildTree(arrayOf(1, null, 2, 3)))
        )
    }
}