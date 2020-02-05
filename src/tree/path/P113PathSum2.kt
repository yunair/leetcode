package tree.path

import common.TreeNode

class P113PathSum2 {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        if (root == null) {
            return list
        }
        pathSumSolve(root, sum, mutableListOf(), list)
        return list
    }

    private fun pathSumSolve(node: TreeNode?, sum: Int, list: MutableList<Int>, result: MutableList<List<Int>>) {
        if (node == null) {
            return
        }
        list.add(node.`val`)

        val remain = sum - node.`val`
        if (node.left == null && node.right == null && remain == 0) {
            result.add(list)
            return
        }
        val leftCopy = ArrayList<Int>(list)
        val rightCopy = ArrayList<Int>(list)
        pathSumSolve(node.left, remain, leftCopy, result)
        pathSumSolve(node.right, remain, rightCopy, result)
    }
}