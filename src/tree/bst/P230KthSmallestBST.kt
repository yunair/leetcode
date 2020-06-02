package tree.bst

import common.TreeNode
import util.TreeUtil
import kotlin.test.assertEquals

/**
 * 二叉搜索树中第K小的元素
 */
object P230KthSmallestBST {
    fun kthSmallestThreadSafe(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inorder(root, list, k)
        return list[k - 1]
    }

    private fun inorder(node: TreeNode?, list: MutableList<Int>, k: Int) {
        if (node == null) {
            return
        }

        inorder(node.left, list, k)
        if (list.size == k) {
            return
        }
        list.add(node.`val`)
        if (list.size == k) {
            return
        }
        inorder(node.right, list, k)
    }

    //    var ans = ThreadLocal<Int>()
//    var count = ThreadLocal<Int>()
    var ans = 0
    var count = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
//        count.set(0)
//        ans.set(0)
        count = 0
        ans = 0
        if (root == null) {
            return 0
        }
        inorder(root, k)

//        return ans.get()
        return ans
    }

    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null) {
            return
        }

        inorder(node.left, k)
//        println(Thread.currentThread().name + count)
//        Thread.sleep(1000)
        count++
        if (count == k) {
            ans = node.`val`
            return
        } else if (count > k) {
            return
        }
        /*count.set(count.get() + 1)
        if (count.get() == k) {
            ans.set(node.`val`)
            return
        } else if (count.get() > k) {
            return
        }*/
        inorder(node.right, k)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        /*Thread {
            kthSmallest(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3)
        }.start()
        Thread {
            kthSmallest(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3)
        }.start()
        Thread {
            kthSmallest(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3)
        }.start()*/
        assertEquals(1, kthSmallestThreadSafe(TreeUtil.buildTree(arrayOf(3, 1, 4, null, 2)), 1))
        assertEquals(3, kthSmallestThreadSafe(TreeUtil.buildTree(arrayOf(5, 3, 6, 2, 4, null, null, 1)), 3))
    }
}