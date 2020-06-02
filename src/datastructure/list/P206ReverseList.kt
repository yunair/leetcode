package datastructure.list

import common.ListNode
import util.ListUtil

/**
 * 反转链表
 */
object P206ReverseList {
    fun reverseListIter(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var node = head
        var pre: ListNode? = null

        while (node != null) {
            val next = node.next
            node.next = pre
            pre = node
            node = next
        }
        return pre
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val next = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return next
    }


    @JvmStatic
    fun main(args: Array<String>) {
        println(
            ListUtil.print(
                reverseList(
                    ListUtil.buildList(
                        intArrayOf(
                            1,
                            2,
                            3,
                            4,
                            5
                        )
                    )
                )
            )
        )
    }
}