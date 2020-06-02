package design.self

import java.lang.StringBuilder

class MyLinkedList<E> {
    private class Node<E>(var e: E?, var next: Node<E>?) {
        constructor(e: E? = null) : this(e, null)

        override fun toString(): String {
            return "Node(e=$e)"
        }
    }

    private var dummyHead = Node<E>()
    private var tail: Node<E> = dummyHead
    private var size = 0


    fun getSize(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun add(index: Int, e: E) {
        if (index < 0 || index > size) {
            throw IllegalArgumentException("Add failed. Illegal index.")
        }

        val node = Node(e)
        if (index == size) {
            tail.next = node
            tail = node
        } else {
            var prev = dummyHead
            for (i in 0 until index) {
                prev = prev.next!!
            }
            node.next = prev.next
            prev.next = node
        }
        size++
    }

    fun addFirst(e: E) {
        add(0, e)
    }

    fun addLast(e: E) {
        add(size, e)
    }

    fun get(index: Int): E? {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Get failed. Illegal index.")
        }
        var cur = dummyHead
        // index+1次
        for (i in 0..index) {
            cur = cur.next!!
        }
        return cur.e
    }

    fun getFirst(): E? {
        return get(0)
    }

    fun getLast(): E? {
        return get(size - 1)
    }

    fun set(index: Int, e: E?) {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Set failed. Illegal index.")
        }

        var cur = dummyHead
        // index+1次
        for (i in 0..index) {
            cur = cur.next!!
        }
        cur.e = e
    }

    fun contains(e: E): Boolean {
        var cur = dummyHead.next
        while (cur != null) {
            if (cur.e == e) {
                return true
            }

            cur = cur.next
        }
        return false
    }

    fun remove(index: Int): E? {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("Remove failed. Illegal index.")
        }

        var prev = dummyHead
        for (i in 0 until index) {
            prev = prev.next!!
        }

        val delNode = prev.next!!
        prev.next = delNode.next
        delNode.next = null
        if (index == size) {
            tail = prev
        }
        size--
        return delNode.e
    }

    fun removeFirst(): E? {
        return remove(0)
    }

    fun removeLast(): E? {
        return remove(size - 1)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var cur = dummyHead.next
        while (cur != null) {
            sb.append(cur.e).append("->")
            cur = cur.next
        }
        sb.append("NULL")
        return sb.toString()
    }
}

fun main() {
    val list = MyLinkedList<Int>()
    for (i in 0..5) {
        list.addFirst(i)
        println(list)
    }

    list.add(2, 666)
    println(list)

    list.remove(2)
    println(list)

    list.removeFirst()
    println(list)

    list.removeLast()
    println(list)
}