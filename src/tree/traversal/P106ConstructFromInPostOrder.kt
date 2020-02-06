package tree.traversal

import common.TreeNode
import util.TreeUtil

/**
 * 从前序与中序遍历序列构造二叉树
 */
class P105ConstructFromPreInOrder {
    /**
     * 找到如何区分左右子树的方式
     */
    fun buildTree(pre: IntArray, inorder: IntArray): TreeNode? {
        val size = pre.size
        if (size == 0) {
            return null
        }
        val root = TreeNode(pre[0])
        if (size == 1) {
            return root
        }

        val rootIndex = inorder.indexOf(pre[0])
        root.left = buildTree(pre.copyOfRange(1, rootIndex + 1), inorder.copyOfRange(0, rootIndex))
        root.right = buildTree(
            pre.copyOfRange(1 + rootIndex, size),
            inorder.copyOfRange(rootIndex + 1, size)
        )
        return root
    }
}

fun main() {
    val test = P105ConstructFromPreInOrder()
    TreeUtil.printTreeNode(test.buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7)))
}