package design

import java.util.*
import kotlin.test.assertEquals

/**
 * 最小栈
 */
class P155MinStack {
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
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }
}

fun main() {
    val minStack = P155MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin()); //返回 -3.
    minStack.pop();
    assertEquals(0, minStack.top()); //--> 返回 0.
    assertEquals(-2, minStack.getMin()); //--> 返回 -2.

}