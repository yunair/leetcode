package tree.bst

import common.TreeNode
import util.TreeUtil

/**
 * 恢复二叉搜索树
 */
object P99RecoverBST {
//    todo 学会 Morris算法 才能做到使用O(1)的空间
    /* fun recoverTree(root: TreeNode?): Unit {

     }
 */

    // 用O(n)个额外空间解法
    fun recoverTreeExtraNSpace(root: TreeNode?) {
        val result = mutableListOf<TreeNode>()
        inorderExtraNSpace(root, result)
        if (result.isEmpty() || result.size == 1) {
            return
        }

        var changeNode1: TreeNode? = null
        var changeNode2: TreeNode? = null
        for (i in 1 until result.size) {
            // 正常的中序遍历应该是从小到大排列的数
            // 如果一个数比下一个数大，则这个数就是要替换的， 节点1
            if (result[i - 1].`val` > result[i].`val`) {
                if (changeNode1 == null) {
                    changeNode1 = result[i - 1]
                    changeNode2 = result[i]
                    continue
                }
                // 找到节点1后面最小的节点2
                if (result[i].`val` < changeNode2!!.`val`) {
                    changeNode2 = result[i]
                }
            }
        }
        val temp = changeNode1!!.`val`
        changeNode1.`val` = changeNode2!!.`val`
        changeNode2.`val` = temp
    }

    private fun inorderExtraNSpace(node: TreeNode?, result: MutableList<TreeNode>) {
        if (node == null) {
            return
        }
        inorderExtraNSpace(node.left, result)
        result.add(node)
        inorderExtraNSpace(node.right, result)

    }
}

fun main() {
    val root = TreeNode(1)
    root.apply {
        left = TreeNode(3)
//        right = TreeNode(9)
    }
    root.left!!.apply {
        left = TreeNode(2)
//        right = TreeNode(2)
    }
    root.left!!.left!!.left = TreeNode(4)
    /*root.right!!.apply {
        left = TreeNode(2)
    }*/
    P99RecoverBST.recoverTreeExtraNSpace(root)
    TreeUtil.printTreeNode(root)
}