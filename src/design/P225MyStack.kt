package design

import java.util.*
import kotlin.test.assertEquals

/**
 * 用队列实现栈
 */
class P225MyStack {
    /** Initialize your data structure here. */
    private val origin = ArrayDeque<Int>()
    private val reverse = ArrayDeque<Int>()

    /** Push element x onto datastructure.stack. */
    fun push(x: Int) {
        if (reverse.isEmpty()) {
            reverse.push(x)
        } else {
            reverseQueue(reverse, origin)
            origin.push(x)
            reverseQueue(origin, reverse)
        }
    }

    private fun reverseQueue(origin: ArrayDeque<Int>, reverse: ArrayDeque<Int>) {
        val values = origin.toIntArray()
        for (i in values.size - 1 downTo 0) {
            reverse.push(values[i])
        }
        origin.clear()
    }

    /** Removes the element on top of the datastructure.stack and returns that element. */
    fun pop(): Int {
        return reverse.pop()
    }

    /** Get the top element. */
    fun top(): Int {
        return reverse.peek()
    }

    /** Returns whether the datastructure.stack is empty. */
    fun empty(): Boolean {
        return reverse.isEmpty()
    }
}

fun main() {
    val test = P225MyStack()
    test.push(1)
    test.push(2)
    assertEquals(2, test.top())
    assertEquals(2, test.pop())
    assertEquals(false, test.empty())
}