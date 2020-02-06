package tree.bst

import common.TreeNode
import util.TreeUtil

fun main() {
    val test = P701InsertBST()
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left!!.apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }
    val node = test.insertIntoBST(root, 5)
    TreeUtil.printTreeNode(node)
}

class P701InsertBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node = root
        while (node != null) {
            if (node.`val` > `val`) {
                val left = node.left
                if (left != null) {
                    node = node.left
                } else {
                    node.left = TreeNode(`val`)
                    return root
                }
            } else {
                val right = node.right
                if (right != null) {
                    node = node.right
                } else {
                    node.right = TreeNode(`val`)
                    return root
                }
            }
        }

        return TreeNode(`val`)
    }

}