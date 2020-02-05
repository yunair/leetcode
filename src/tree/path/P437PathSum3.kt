package tree.path

import common.TreeNode

class P437PathSum3 {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) {
            return 0
        }
        return pathSumSolve(root, sum) +
                pathSum(root.left, sum) +
                pathSum(root.right, sum)
    }

    private fun pathSumSolve(node: TreeNode?, sum: Int): Int {
        if (node == null) {
            return 0
        }
        val remain = sum - node.`val`
        val result = if (remain == 0) {
            1
        } else {
            0
        }

        val left = pathSumSolve(node.left, remain)
        val right = pathSumSolve(node.right, remain)

        return left + right + result
    }
}