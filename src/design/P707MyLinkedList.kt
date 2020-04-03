package design

import kotlin.test.assertEquals

class P707MyLinkedList {
    private val head = DNode(0)
    private var length = 0

    class DNode(val `val`: Int, var prev: DNode? = null, var next: DNode? = null)
    /** Initialize your data structure here. */

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        val node = getNode(index) ?: return -1
        return node.`val`
    }

    private fun getNode(index: Int): DNode? {
        if (index >= length) {
            return null
        }
        var i = 0
        var node = head.next!!
        while (i < index) {
            node = node.next!!
            i++
        }
        return node
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        var next = head.next
        if (next == null) {
            next = head
        }
        val node = DNode(`val`, head, next)
        next.prev = node
        head.next = node
        length++
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        var before = head.prev
        if (before == null) {
            before = head
        }
        val node = DNode(`val`, before, head)

        before.next = node
        head.prev = node
        length++
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        when {
            index < 0 -> {
                addAtHead(`val`)
            }
            index == length -> {
                addAtTail(`val`)
            }
            index > length -> {
                return
            }
            else -> {
                var i = 0
                var prev = head
                while (i < index) {
                    prev = prev.next!!
                    i++
                }
                val next = prev.next
                val node = DNode(`val`, prev, next)
                prev.next = node
                if (next != null) {
                    next.prev = node
                }
                length++
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        val node = getNode(index) ?: return
        val next = node.next
        val prev = node.prev
        if (prev != null) {
            prev.next = next
        }
        if (next != null) {
            next.prev = prev
        }
        length--
    }
}

fun main() {
    val linkedList = P707MyLinkedList();
    linkedList.addAtHead(5)
    linkedList.addAtIndex(1, 2)
    assertEquals(2, linkedList.get(1))

    linkedList.addAtHead(6)
    linkedList.addAtTail(2)
    linkedList.addAtTail(5)
    assertEquals(-1,  linkedList.get(5))
//    linkedList.addAtIndex(0, 20)
//    linkedList.addAtIndex(1, 30)
//    assertEquals(20, linkedList.get(0))
    /*linkedList.addAtHead(1);
    linkedList.addAtTail(3);
    linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
    assertEquals(2, linkedList.get(1));            //返回2
    linkedList.deleteAtIndex(1);  //现在链表是1-> 3
    assertEquals(3, linkedList.get(1));            //返回3*/
}