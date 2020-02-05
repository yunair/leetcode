package tree.structure

import common.TreeNode

/**
 * 对称二叉树（镜像对称）
 * 给定一个二叉树，检查它是否是镜像对称的。例如，二叉树 [1,2,2,3,4,4,3]是对称的
 */
class P101SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return isMirror(root.left, root.right)
    }

    // 递归
    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) {
            return left == right
        }

        if (left.`val` != right.`val`) {
            return false
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left)
    }
}