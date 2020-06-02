package tree

import common.TreeNode
import util.TreeUtil

object P988SmallestStringFromLeaf {
    private var ans = "~"
    fun smallestFromLeaf(root: TreeNode?): String {
        dfs(root, "")
        return ans
    }

    // 求出从root到leaf的str，然后和ans比较，拿最小的
    private fun dfs(node: TreeNode?, s: String) {
        if (node == null) {
            return
        }
        val str = ('a' + node.`val`).toString() + s
        if (node.left == null && node.right == null) {
            if (str < ans) {
                ans = str
            }
        }
        dfs(node.left, str)
        dfs(node.right, str)
    }
}

fun main() {
    val root = TreeUtil.buildTree(arrayOf(25, 1, null, 0, 0, 1, null, null, null, 0))
    println(P988SmallestStringFromLeaf.smallestFromLeaf(root))
}