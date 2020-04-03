package twopoint

import common.ListNode
import util.ListUtil

/**
 * 旋转链表
 */
object P61RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0 || head.next == null) {
            return head
        }
        var nodeLength = 0
        var startNode = head
        while (startNode != null) {
            nodeLength++
            startNode = startNode.next
        }

        var rotateNum = k
        if (k >= nodeLength) {
            rotateNum = k % nodeLength
        }
        if (rotateNum == 0) {
            return head
        }

        var slow = head
        var fast = slow.next
        for (i in 2..rotateNum) {
            fast = fast!!.next
        }
        while (fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next
        }
        val node = slow!!.next
        slow.next = null
        fast.next = head

        return node
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        ListUtil.print(rotateRight(ListUtil.buildList(intArrayOf(0, 1, 2)), 4))
        ListUtil.print(rotateRight(ListUtil.buildList(intArrayOf(1, 2)), 2))
        ListUtil.print(rotateRight(ListUtil.buildList(intArrayOf(1, 2, 3, 4, 5)), 2))
    }
}