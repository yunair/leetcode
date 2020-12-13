package tree.bst

import common.TreeNode
import util.TreeUtil
import java.util.*

/**
 * 把二叉搜索树转换为累加树
 */
object P538ConvertBSTToGST {
    var max = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        convertBST(root.right)
        root.`val` += max
        max = root.`val`
        convertBST(root.left)

        return root
    }

    @JvmStatic
    fun main(args: Array<String>) {
        TreeUtil.printTreeNode(convertBST(TreeUtil.toTree(1, 0, 2)))
        TreeUtil.printTreeNode(convertBST(TreeUtil.toTree(3, 2, 4, 1)))
        TreeUtil.printTreeNode(
            convertBST(
                TreeUtil.toTree(
                    4,
                    1,
                    6,
                    0,
                    2,
                    5,
                    7,
                    null,
                    null,
                    null,
                    3,
                    null,
                    null,
                    null,
                    8
                )
            )
        )
    }
}