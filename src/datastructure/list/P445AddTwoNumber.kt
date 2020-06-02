package datastructure.list

import common.ListNode
import util.ListUtil
import java.util.*

/**
 * 两数相加 II
 */
object P445AddTwoNumber {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = LinkedList<Int>()
        val stack2 = LinkedList<Int>()
        var node = l1
        while (node != null) {
            stack1.push(node.`val`)
            node = node.next
        }

        node = l2
        while (node != null) {
            stack2.push(node.`val`)
            node = node.next
        }

        val stack3 = LinkedList<Int>()
        var carry = 0
        var head: ListNode? = null

        while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry > 0) {
            var sum = carry
            sum += if (stack1.isEmpty()) 0 else stack1.pop()
            sum += if (stack2.isEmpty()) 0 else stack2.pop()
            val newNode = ListNode(sum % 10)
            newNode.next = head
            head = newNode
            carry = sum / 10
        }

        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        ListUtil.print(
            addTwoNumbers(
                ListUtil.buildList(intArrayOf(7, 2, 4, 3)),
                ListUtil.buildList(intArrayOf(5, 6, 4))
            )
        )

        ListUtil.print(
            addTwoNumbers(
                ListUtil.buildList(intArrayOf(3, 9, 9, 9, 9, 9, 9, 9, 9, 9)),
                ListUtil.buildList(intArrayOf(7))
            )
        )
        ListUtil.print(addTwoNumbers(ListUtil.buildList(intArrayOf(0)), ListUtil.buildList(intArrayOf(0))))
        ListUtil.print(addTwoNumbers(ListUtil.buildList(intArrayOf(5)), ListUtil.buildList(intArrayOf(5))))
        ListUtil.print(addTwoNumbers(ListUtil.buildList(intArrayOf(1, 5)), ListUtil.buildList(intArrayOf(8, 5))))
    }
}