package tree.traversal

import common.TreeNode
import util.TreeUtil
import java.util.*

/**
 * 二叉树的前序遍历
 */
object P144PreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        preorder(root, ans)
        return ans
    }

    private fun preorder(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) {
            return
        }

        list.add(node.`val`)
        preorder(node.left, list)
        preorder(node.right, list)
    }

    fun preorderTraversalIter(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }
        val stack = LinkedList<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            ans.add(node.`val`)
            node.right?.let {
                stack.push(it)
            }
            node.left?.let {
                stack.push(it)
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(preorderTraversalIter(TreeUtil.buildTree(arrayOf(1, null, 2, 3))))
    }
}