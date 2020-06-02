package tree.traversal

import common.TreeNode
import util.TreeUtil

/**
 * 从中序与后序遍历序列构造二叉树
 */
class P106ConstructFromInPostOrder {
    /**
     * 找到如何区分左右子树的方式
     */
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val size = postorder.size
        if (size == 0) {
            return null
        }
        val root = TreeNode(postorder[postorder.size - 1])
        if (size == 1) {
            return root
        }

        val rootIndex = inorder.indexOf(postorder[postorder.size - 1])
        root.left = buildTree(inorder.copyOfRange(0, rootIndex), postorder.copyOfRange(0, rootIndex))
        root.right = buildTree(
            inorder.copyOfRange(rootIndex + 1, size),
            postorder.copyOfRange(rootIndex, size - 1)
        )
        return root
    }
}

fun main() {
    val test = P106ConstructFromInPostOrder()
    TreeUtil.printTreeNode(test.buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
}