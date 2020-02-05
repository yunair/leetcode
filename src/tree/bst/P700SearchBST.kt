package tree.bst

import common.TreeNode

/**
 * 二叉搜索树中的搜索
 */
class P700SearchBST {
    // 迭代版本也很简单
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }

        if (root.`val` > `val`) {
            return searchBST(root.left, `val`)
        }

        if (root.`val` < `val`) {
            return searchBST(root.right, `val`)
        }

        return root
    }
}