package tree

import common.TreeNode
import util.TreeUtil

object P863DistanceKBinaryTree {
    private val map = mutableMapOf<TreeNode, TreeNode/*parentNode*/>()
    private val visited = mutableSetOf<TreeNode>()
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        val results = mutableListOf<Int>()
        if (root == null || target == null) {
            return results
        }
        // 找到节点下侧距离为K的点
        findBottom(root, target, K, false, results)
        if (visited.isEmpty()) {
            return results
        }
        // 此时只存了targetNode
        val targetNode = visited.first()
        if (!map.containsKey(targetNode)) {
            return results
        }

        var parent = map[targetNode]
        var aimValue = K - 1
        while (parent != null) {
            findTop(parent, aimValue, results)
            parent = map[parent]
            aimValue--
        }


        return results
    }

    private fun findTop(node: TreeNode?, K: Int, results: MutableList<Int>) {
        if (node == null) {
            return
        }

        if (visited.contains(node)) {
            return
        }

        visited.add(node)

        if (K == 0) {
            results.add(node.`val`)
            return
        }
        val left = node.left
        val right = node.right
        findTop(left, K - 1, results)
        findTop(right, K - 1, results)
    }

    private fun findBottom(node: TreeNode?, target: TreeNode, K: Int, find: Boolean, results: MutableList<Int>) {
        if (node == null) {
            return
        }

        var findInner = find
        if (node.`val` == target.`val`) {
            visited.add(node)
            findInner = true
        }

        val left = node.left
        val right = node.right

        if (findInner) {
            if (K == 0) {
                results.add(node.`val`)
                return
            }
            findBottom(left, target, K - 1, findInner, results)
            findBottom(right, target, K - 1, findInner, results)
        } else {
            if (left != null) {
                map[left] = node
                findBottom(left, target, K, findInner, results)
            }
            if (right != null) {
                map[right] = node
                findBottom(right, target, K, findInner, results)
            }
        }
    }
}

fun main() {

    val root = TreeUtil.buildTree(arrayOf(0, 2, 1, null, null, 3, null, 4))
    println(P863DistanceKBinaryTree.distanceK(root, TreeNode(2), 2))
}