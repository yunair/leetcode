package tree.traversal

import common.TreeNode
import util.TreeUtil
import java.util.*

/**
 * 二叉树的后序遍历
 */
object P145PostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        postorder(root, ans)
        return ans
    }

    private fun postorder(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) {
            return
        }

        postorder(node.left, list)
        postorder(node.right, list)
        list.add(node.`val`)
    }

    fun postorderTraversalIter(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }
        val stack = LinkedList<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            ans.add(0, node.`val`)
            node.left?.let {
                stack.push(it)
            }
            node.right?.let {
                stack.push(it)
            }
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(postorderTraversalIter(TreeUtil.buildTree(arrayOf(1, null, 2, 3))))
    }
}