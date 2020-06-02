package tree.traversal

import common.TreeNode
import java.util.*

/**
 * 完全二叉树的节点个数
 */
object P222FullyBinaryTreeNodeCount {
    /**
     * 没用到完全二叉树的性质
     */
    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var count = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            count++
            current.left?.let {
                queue.add(it)
            }
            current.right?.let {
                queue.add(it)
            }
        }
        return count
    }

    /**
     * 完全二叉树的定义：它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧。
     *
     * 如果满二叉树的层数为h，则总节点数为：2^h - 1.
     *
     * 那么我们来对root节点的左右子树进行高度统计，分别记为left和right,有以下两种结果：
     *
     * 1. left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
     *  所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
     * 2. left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
     *  同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。
     */
    fun countNodesBetter(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = countLevel(root.left)
        val right = countLevel(root.right)
        return if (left == right) {
            countNodesBetter(root.right) + (1 shl left)
        } else {
            countNodesBetter(root.left) + (1 shl right)
        }
    }

    private fun countLevel(root: TreeNode?): Int {
        var node = root
        var level = 0
        while (node != null) {
            level++
            node = node.left
        }
        return level
    }
}