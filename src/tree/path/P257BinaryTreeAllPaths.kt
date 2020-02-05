package tree.path

import common.TreeNode

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径
 */
class P257BinaryTreeAllPaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()

        if (root == null) {
            return result
        }
        binaryTreePathsSolve(root, "", result)
        return result
    }

    private fun binaryTreePathsSolve(node: TreeNode?, cur: String, list: MutableList<String>) {
        var content = cur
        if (node == null) {
            return
        }
        content += node.`val`.toString()

        if (node.left == null && node.right == null) {
            list.add(content)
        } else {
            binaryTreePathsSolve(node.left, "$content->", list)
            binaryTreePathsSolve(node.right, "$content->", list)
        }
    }

}