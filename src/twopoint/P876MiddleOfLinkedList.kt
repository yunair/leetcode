package twopoint

import common.ListNode
import util.ListUtil

/**
 * 链表的中间结点
 */
object P876MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }
        return slow
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            middleNode(
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
        println(
            middleNode(
                ListUtil.buildList(
                    intArrayOf(
                        1,
                        2,
                        3,
                        4,
                        5,
                        6
                    )
                )
            )
        )
    }
}