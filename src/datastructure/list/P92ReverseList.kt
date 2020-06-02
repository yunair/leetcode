package datastructure.list

import common.ListNode
import util.ListUtil

/**
 * 反转链表 II
 */
object P92ReverseList {
    /**
     * 使用dummyHead, 就可以不处理head相关的判断
     */
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null || m >= n) {
            return head
        }

        val dummy = ListNode(0)
        dummy.next = head

        var curIndex = 0
        var preNode = dummy
        while (curIndex < m - 1) {
            preNode = preNode.next!!
            curIndex++
        }

        var node = preNode.next
        val end = node
        var subPreNode: ListNode? = null
        while (curIndex < n && node != null) {
            val next = node.next
            node.next = subPreNode
            subPreNode = node
            node = next
            curIndex++
        }

        if (end != null) {
            end.next = node
            preNode.next = subPreNode
        }

        return dummy.next
    }


    @JvmStatic
    fun main(args: Array<String>) {
        ListUtil.print(reverseBetween(ListUtil.toList(1, 2, 3, 4, 5), 2, 4))
        ListUtil.print(reverseBetween(ListUtil.toList(3, 5), 1, 2))
        ListUtil.print(reverseBetween(ListUtil.toList(1, 3, 5), 1, 3))
        ListUtil.print(reverseBetween(ListUtil.toList(1, 2, 3), 1, 2))
    }
}