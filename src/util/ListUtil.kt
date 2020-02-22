package util

import common.ListNode

object ListUtil {
    @JvmStatic
    fun buildList(array: IntArray): ListNode? {
        if (array.isEmpty()) {
            return null
        }
        val headValue = array[0] ?: return null

        val head = ListNode(headValue)
        var node = head
        for (i in 1 until array.size) {
            node.next = ListNode(array[i])
            node = node.next!!
        }
        return head
    }

    @JvmStatic
    fun print(head: ListNode?) {
        if (head == null) {
            return
        }
        var node: ListNode? = head
        while (node != null) {
            println(node.`val`)
            node = node.next
        }
    }
}