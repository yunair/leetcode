package twopoint

import common.ListNode
import util.ListUtil

/**
 * 删除链表的倒数第N个节点
 */
object P19RemoveNthNodeFromEndOfList {
    /**
     *
     * 设置虚拟节点 dummyHead 指向 head
     * 设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
     * 这样就不用特殊处理head指针问题
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        var pre = head
        var post = head

        for (i in 0..n) {
            if (pre == null) {
                return head.next
            } else {
                pre = pre.next
            }
        }
        while (pre != null) {
            pre = pre.next
            post = post!!.next
        }

        post!!.next = post.next!!.next
        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        ListUtil.print(removeNthFromEnd(ListUtil.buildList(intArrayOf(1, 2, 3, 4, 5)), 2))
        ListUtil.print(removeNthFromEnd(ListUtil.buildList(intArrayOf(1, 2)), 1))
        ListUtil.print(removeNthFromEnd(ListUtil.buildList(intArrayOf(1)), 1))
        ListUtil.print(removeNthFromEnd(ListUtil.buildList(intArrayOf(1, 2)), 2))
    }
}