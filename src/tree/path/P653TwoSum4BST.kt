package tree.path

import common.TreeNode

/**
 * 两数之和 IV - 输入 BST
 */
class P653TwoSum4BST {
    /**
     * 更好的方案, 遍历过程中，寻找是否存在相减的值
     */
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val set = HashSet<Int>();
        return find(root, k, set);
    }

    private fun find(root: TreeNode?, k: Int, set: HashSet<Int>): Boolean {
        if (root == null) {
            return false
        }
        if (set.contains(k - root.`val`)) {
            return true
        }
        set.add(root.`val`)

        return find(root.left, k, set) || find(root.right, k, set);
    }

}

fun main() {
    val root = TreeNode(1)
    /*root.apply {
        left = TreeNode(3)
        right = TreeNode(6)
    }
    root.left!!.apply {
        left = TreeNode(2)
        right = TreeNode(4)
    }
    root.right!!.apply {
        right = TreeNode(7)
    }*/
    val test = P653TwoSum4BST()
    println(test.findTarget(root, 2))
}