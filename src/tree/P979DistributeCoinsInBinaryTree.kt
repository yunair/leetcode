package tree

import common.TreeNode
import util.TreeUtil
import kotlin.math.abs
import kotlin.test.assertEquals

/**
 * 在二叉树中分配硬币
 *
 * 思路
 * 如果树的叶子仅包含 0 枚金币（与它所需相比，它的 过载量 为 -1），那么我们需要从它的父亲节点移动一枚金币到这个叶子节点上。
 * 如果说，一个叶子节点包含 4 枚金币（它的 过载量 为 3），那么我们需要将这个叶子节点中的 3 枚金币移动到别的地方去。
 * 总的来说，对于一个叶子节点，需要移动到它中或需要从它移动到它的父亲中的金币数量为 过载量 = Math.abs(num_coins - 1)。
 * 然后，在接下来的计算中，我们就再也不需要考虑这些已经考虑过的叶子节点了。
 */
object P979DistributeCoinsInBinaryTree {
    private var count = 0
    fun distributeCoins(root: TreeNode?): Int {
        count = 0
        dfs(root)
        return count
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val left = dfs(node.left)
        val right = dfs(node.right)
        val cur = node.`val` - 1
        count += abs(left) + abs(right)
        return left + right + cur
    }

}

fun main() {
//    val root = TreeUtil.buildTree(arrayOf(4, 0, null, null, 0, null, 0))

    assertEquals(2, P979DistributeCoinsInBinaryTree.distributeCoins(TreeUtil.buildTree(arrayOf(3, 0, 0))), "300")
    assertEquals(
        6,
        P979DistributeCoinsInBinaryTree.distributeCoins(TreeUtil.buildTree(arrayOf(4, 0, null, null, 0, null, 0))),
        "4, 0, null, null, 0, null, 0"
    )
    assertEquals(
        4,
        P979DistributeCoinsInBinaryTree.distributeCoins(TreeUtil.buildTree(arrayOf(1, 0, 0, null, 3))),
        "1,0,0,null,3"
    )
}