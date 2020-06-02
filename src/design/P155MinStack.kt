package design

import java.util.*
import kotlin.test.assertEquals

/**
 * 最小栈
 */
class MinStack {
    /**
     * 将最小值和当前值合并为同一个元素
     * 获取min的时候只要peek().second即可
     */
    /** initialize your data structure here. */
    private val stack = ArrayDeque<Pair<Int, Int>>()
    private var minValue = Int.MAX_VALUE
    fun push(x: Int) {
        if (minValue > x) {
            minValue = x
        }
        stack.push(Pair(x, minValue))
    }

    fun pop() {
        if (stack.isEmpty()) {
            return
        }
        stack.pop()
        minValue = if (stack.isEmpty()) {
            Int.MAX_VALUE
        } else {
            getMin()
        }
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-10);
    minStack.push(14);
    assertEquals(-10, minStack.getMin()); //返回 -3.
    assertEquals(-10, minStack.getMin()); //返回 -3.

    minStack.push(-20);
    assertEquals(-20, minStack.getMin()); //返回 -3.
    assertEquals(-20, minStack.getMin()); //返回 -3.
    assertEquals(-20, minStack.top()); //返回 -3.
    assertEquals(-20, minStack.getMin()); //返回 -3.
    minStack.pop()
    minStack.push(-10)
    assertEquals(0, minStack.top()); //--> 返回 0.
    assertEquals(-2, minStack.getMin()); //--> 返回 -2.

}