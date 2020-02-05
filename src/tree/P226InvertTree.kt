package tree

import common.TreeNode
import java.util.*

/**
 * 反转二叉树
 */
class P226InvertTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val right = invertTree(root.right)
        val left = invertTree(root.left)
        root.left = right
        root.right = left
        return root
    }

    fun invertTreeIter(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val queue = LinkedList<TreeNode>();
        queue.add(root)
        while (!queue.isEmpty()) {
            val current = queue.poll()
            val tmp = current.left
            current.left = current.right
            current.right = tmp
            current.right?.let {
                queue.add(it)
            }
            current.left?.let {
                queue.add(it)
            }

        }

        return root
    }
}