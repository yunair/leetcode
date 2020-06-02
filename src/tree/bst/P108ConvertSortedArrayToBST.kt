package tree.bst

import common.TreeNode
import util.TreeUtil

/**
 * 将有序数组转换为二叉搜索树
 */
object P108ConvertSortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }


        return build(nums, 0, nums.size - 1)
    }

    private fun build(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val mid = (start + end) / 2
        val root = TreeNode(nums[mid])
        val left = build(nums, start, mid - 1)
        val right = build(nums, mid + 1, end)
        if (left != null) {
            root.left = left
        }
        if (right != null) {
            root.right = right
        }
        return root
    }

    @JvmStatic
    fun main(args: Array<String>) {
        TreeUtil.printTreeNode(sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
        TreeUtil.printTreeNode(sortedArrayToBST(intArrayOf(0, 1, 2, 3, 4, 5)))
    }
}