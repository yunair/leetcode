package tree.bst

import common.TreeNode
import util.TreeUtil
import kotlin.test.assertEquals

/**
 * 二叉搜索树中第K小的元素
 */
object P230KthSmallestBST {
    fun kthSmallestThreadSafe(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inorder(root, list)
        return list[k - 1]
    }

    private fun inorder(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) {
            return
        }

        inorder(node.left, list)
        list.add(node.`val`)
        inorder(node.right, list)
    }

    var ans = 0
    var count = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        count = 0
        ans = 0
        if (root == null) {
            return 0
        }
        inorder(root, k)

        return ans
    }

    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null) {
            return
        }

        inorder(node.left, k)
        count++
        if (count == k) {
            ans = node.`val`
            return
        } else if (count > k) {
            return
        }
        inorder(node.right, k)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, kthSmallest(TreeUtil.buildTree(arrayOf(3, 1, 4, null, 2)), 1))
        assertEquals(3, kthSmallest(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3))
    }
}