package tree.path

import common.TreeNode

class P112PathSum {
    fun pathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null) {
            return sum == root.`val`
        }

        val left = pathSum(root.left, sum - root.`val`)
        val right = pathSum(root.right, sum - root.`val`)

        return left || right
    }

}