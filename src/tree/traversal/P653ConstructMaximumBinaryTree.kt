package tree.traversal

import common.TreeNode
import util.TreeUtil

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 1. 二叉树的根是数组中的最大元素。
 * 2. 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 3. 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
object P653ConstructMaximumBinaryTree {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        var max = -1
        var maxIndex = -1
        for (i in nums.indices) {
            if (nums[i] > max) {
                max = nums[i]
                maxIndex = i
            }
        }
        val node = TreeNode(max)
        if (maxIndex > 0) {
            node.left = constructMaximumBinaryTree(nums.copyOfRange(0, maxIndex))
        }
        if (maxIndex < nums.size - 1) {
            node.right = constructMaximumBinaryTree(nums.copyOfRange(maxIndex + 1, nums.size))
        }
        return node
    }
}

fun main() {
    TreeUtil.printTreeNode(P653ConstructMaximumBinaryTree.constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5)))
}