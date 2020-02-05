package tree.traversal

import common.TreeNode

class P606Tree2Str {
    fun tree2str(t: TreeNode?): String {
        return tree2strSolve(t)
    }
    // 前序遍历
    private fun tree2strSolve(t: TreeNode?): String {
        if (t == null) {
            return ""
        }

        val value = t.`val`
        val left = tree2strSolve(t.left)
        val right = tree2strSolve(t.right)
        if (left == "" && right == "") {
            return "$value"
        }
        if (right == "") {
            return "$value($left)"
        }
        return "$value($left)($right)"
    }
}