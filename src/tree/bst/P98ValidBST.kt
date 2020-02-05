package tree.bst

import common.TreeNode

/**
 * 验证二叉搜索树
 */
class P98ValidBST {
    // 中序遍历，每一个小于前一个值即可
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBSTSolve(root, null, null)
    }

    private fun isValidBSTSolve(node: TreeNode?, lower: Int?/*下界*/, upper: Int?/*上界*/): Boolean {
        if (node == null) {
            return true
        }


        val value = node.`val`
        if (lower != null && value <= lower) {
            return false
        }
        if (upper != null && value >= upper) {
            return false
        }

        if (!isValidBSTSolve(node.left, lower, value)) {
            return false
        }
        if (!isValidBSTSolve(node.right, value, upper)) {
            return false
        }
        return true
    }
}