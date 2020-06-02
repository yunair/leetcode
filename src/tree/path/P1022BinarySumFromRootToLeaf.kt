package tree.path

import common.TreeNode

/**
 * 从根到叶的二进制数之和
 */
object P1022BinarySumFromRootToLeaf {
    fun sumRootToLeaf(root: TreeNode?): Int {
        val list = mutableListOf<String>()
        if (root == null) {
            return 0
        }
        dfs(root, "", list)

        return list.map {
            Integer.valueOf(it, 2)
        }.sum()
    }
    // 更好的解决方案，直接用int替换value
    private fun dfs(node: TreeNode?, value: String, list: MutableList<String>) {
        if (node == null) {
            return
        }

        val nextStr = value + node.`val`
        if (node.left == null && node.right == null) {
            list.add(nextStr)
            return
        }
        dfs(node.left, nextStr, list)
        dfs(node.right, nextStr, list)
    }
}

fun main() {
    val root = TreeNode(1)
    root.apply {
        left = TreeNode(0)
        right = TreeNode(1)
    }
    root.left!!.apply {
        left = TreeNode(0)
        right = TreeNode(1)
    }
    root.right!!.apply {
        left = TreeNode(0)
        right = TreeNode(1)
    }
    println(P1022BinarySumFromRootToLeaf.sumRootToLeaf(root))
}