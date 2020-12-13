package interview

import common.TreeNode
import util.TreeUtil
import java.util.*
import kotlin.test.assertEquals

/**
 * 二叉搜索树中第K大的元素
 */
object KthLargestBST {
    var ans = 0
    var count = 0

    fun kthLargest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return 0
        }
        val stack = LinkedList<TreeNode>()
        var res = 0
        var node = root
        // 中序迭代遍历
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.right
            }
            node = stack.pop()
            res++
            if (res == k) {
                return node.`val`
            }
            node = node.left
        }
        return 0
    }

    fun kthLargestRec(root: TreeNode?, k: Int): Int {
        count = 0
        ans = 0
        inorder(root, k)
        return ans
    }

    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null) {
            return
        }

        inorder(node.right, k)
        count++
        if (count == k) {
            ans = node.`val`
            return
        } else if (count > k) {
            return
        }
        inorder(node.left, k)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, kthLargest(TreeUtil.buildTree(arrayOf(3, 1, 4, null, 2)), 1))
        assertEquals(4, kthLargest(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3))
    }
}