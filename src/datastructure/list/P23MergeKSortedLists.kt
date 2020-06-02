package datastructure

import common.ListNode
import util.ListUtil
import java.util.*

/**
 * 合并K个排序链表
 */
object P23MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(Comparator<ListNode> { o1, o2 ->
            o1.`val`.compareTo(o2.`val`)
        })

        for (list in lists) {
            var v = list
            while (v != null) {
                pq.add(v)
                v = v.next
            }
        }

        if (pq.isEmpty()) {
            return null
        }
        val head = ListNode(pq.remove().`val`)
        var node = head
        while (pq.isNotEmpty()) {
            node.next = ListNode(pq.remove().`val`)
            node = node.next!!
        }
        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = Array<ListNode?>(3) {
            null
        }.apply {
            this[0] = ListUtil.buildList(intArrayOf(1, 4, 5))
            this[1] = ListUtil.buildList(intArrayOf(1, 3, 4))
            this[2] = ListUtil.buildList(intArrayOf(2, 6))
        }
        ListUtil.print(mergeKLists(arr))
    }
}