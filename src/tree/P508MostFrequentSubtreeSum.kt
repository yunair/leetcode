package tree

import common.TreeNode
import util.TreeUtil

/**
 * 出现次数最多的子树元素和
 */
object P508MostFrequentSubtreeSum {
    private val map = mutableMapOf<Int, Int>()
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        dfs(root)
        val arr = mutableListOf<Int>()
        var max = 0
        for (entry in map) {
            if (entry.value > max) {
                arr.clear()
                arr.add(entry.key)
                max = entry.value
            } else if(entry.value == max){
                arr.add(entry.key)
            }
        }

        return arr.toIntArray()
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val left = dfs(node.left)
        val right = dfs(node.right)
        val value = node.`val`
        val sum = value + left + right
        map[sum] = map.getOrDefault(sum, 0) + 1
        return sum
    }
}

fun main() {
    val root = TreeUtil.buildTree(arrayOf(0))
    println(P508MostFrequentSubtreeSum.findFrequentTreeSum(root).contentToString())
}