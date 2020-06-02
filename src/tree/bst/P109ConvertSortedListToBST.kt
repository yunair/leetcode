package tree.bst

import common.ListNode
import common.TreeNode
import util.ListUtil
import util.TreeUtil

/**
 * 有序链表转换二叉搜索树
 */
object P109ConvertSortedListToBST {
    /**
     * 双指针找中间节点
     */
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return build(head)
    }

    private fun build(head: ListNode?): TreeNode? {
        if (head == null) {
            return null
        }
        var quick = head
        var slow = head
        var preSlow: ListNode? = null
        while (quick != null) {
            if (quick.next?.next == null) {
                break
            }
            quick = quick.next!!.next
            preSlow = slow
            slow = slow!!.next
        }

        val root = TreeNode(slow!!.`val`)
        // 剪断链表
        preSlow?.next = null
        if (slow != head) {
            root.left = build(head)
        }
        root.right = build(slow.next)

        return root
    }

    @JvmStatic
    fun main(args: Array<String>) {
        TreeUtil.printTreeNode(sortedListToBST(ListUtil.buildList(intArrayOf(-10, -3, 0, 5, 9))))
        TreeUtil.printTreeNode(sortedListToBST(ListUtil.buildList(intArrayOf(0, 1, 2, 3, 4, 5))))
    }
}