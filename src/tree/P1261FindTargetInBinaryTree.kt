package tree

import common.TreeNode

/**
 * 在受污染的二叉树中查找元素
 *
 * 给出一个满足下述规则的二叉树：
 *
 *  root.val == 0
 *  如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 *  如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 */
class FindElements(root: TreeNode?) {
    private val set = mutableSetOf<Int>()

    init {
        dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, value: Int) {
        if (node == null) {
            return
        }
        node.`val` = value
        set.add(value)

        dfs(node.left, 2 * value + 1)
        dfs(node.right, 2 * value + 2)

    }

    fun find(target: Int): Boolean {
        return set.contains(target)
    }

}