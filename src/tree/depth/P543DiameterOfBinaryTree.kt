package tree.depth

import common.TreeNode
import util.TreeUtil
import kotlin.test.assertEquals

/**
 * 二叉树的直径
 */
object P543DiameterOfBinaryTree {
    var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        max = 0
        dfs(root)
        return max
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return -1
        }
        val left = dfs(node.left) + 1
        val right = dfs(node.right) + 1
        val result = left + right
        max = maxOf(max, result)
        return maxOf(left, right)
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3,
            diameterOfBinaryTree(
                TreeUtil.buildTree(
                    arrayOf(
                        1,
                        2,
                        3,
                        4,
                        5
                    )
                )
            )
        )
        assertEquals(
            7,
            diameterOfBinaryTree(
                TreeUtil.buildTree(
                    arrayOf(
                        37,
                        -34,
                        -48,
                        null,
                        -100,
                        -100,
                        48,
                        null,
                        null,
                        null,
                        null,
                        -54,
                        null,
                        -71,
                        -22,
                        null,
                        null,
                        null,
                        8
                    )
                )
            )
        )
    }
}