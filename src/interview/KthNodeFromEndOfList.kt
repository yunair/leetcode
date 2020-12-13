package interview

import common.ListNode
import util.ListUtil
import kotlin.test.assertEquals

object KthNodeFromEndOfList {
    fun kthToLast(head: ListNode?, k: Int): Int {
        if (head == null) {
            return 0
        }

        var pre = head
        var post = head
        var i = 0
        while (pre!!.next != null) {
            i++
            pre = pre.next
            if (i >= k) {
                post = post!!.next
            }
        }
        return post!!.`val`
    }

    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }

        var pre = head
        var post = head
        var i = 0
        while (pre!!.next != null) {
            i++
            pre = pre.next
            if (i >= k) {
                post = post!!.next
            }
        }
        return post
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(4, kthToLast(ListUtil.buildList(intArrayOf(1, 2, 3, 4, 5)), 2))
    }
}