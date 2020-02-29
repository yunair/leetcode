package math

import common.ListNode
import kotlin.test.assertEquals

/**
 * 回文链表
 */
object P234PalindromicList {
    /**
     * 能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return true
        }
        if (head.next == null) {
            return true
        }

        // 链表转线性表
        var n = 0
        var node = head
        val list = mutableListOf<Int>()
        while (node != null) {
            n++
            list.add(node.`val`)
            node = node.next
        }

        for (i in 0..(n / 2)) {
            if (list[i] != list[n - 1 - i]) {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(true, isPalindrome(buildList(intArrayOf(1, 2, 2, 1))))
        assertEquals(false, isPalindrome(buildList(intArrayOf(1, 2))))
    }

    private fun buildList(arr: IntArray): ListNode {
        val root = ListNode(arr[0])
        var node = root
        for (i in 1 until arr.size) {
            node.next = ListNode(arr[i])
            node = node.next!!
        }
        return root
    }
}