package math

import common.ListNode
import util.ListUtil

/**
 * 两数相加
 */
object P2AddTwoNumbers {
    private var carry = 0
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val headSum = sum(l1.`val` + l2.`val`)
        val l3 = ListNode(headSum)
        var l1Node = l1.next
        var l2Node = l2.next
        var l3Node = l3
        while (l1Node != null && l2Node != null) {
            val sum = sum(l1Node.`val` + l2Node.`val` + carry)
            l3Node.next = ListNode(sum)
            l1Node = l1Node.next
            l2Node = l2Node.next
            l3Node = l3Node.next!!
        }

        while (l1Node != null) {
            val sum = sum(l1Node.`val` + carry)
            l3Node.next = ListNode(sum)
            l1Node = l1Node.next
            l3Node = l3Node.next!!
        }

        while (l2Node != null) {
            val sum = sum(l2Node.`val` + carry)
            l3Node.next = ListNode(sum)
            l2Node = l2Node.next
            l3Node = l3Node.next!!
        }
        if (carry == 1) {
            l3Node.next = ListNode(1)
        }
        return l3
    }

    private fun sum(num: Int): Int {
        var sum = num
        if (sum >= 10) {
            carry = 1
            sum -= 10
        } else {
            carry = 0
        }
        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        ListUtil.print(addTwoNumbers(ListNode(5), ListNode(5)))
    }
}