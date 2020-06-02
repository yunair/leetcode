package stack

import java.util.*
import kotlin.test.assertEquals

/**
 *
 */
object P32LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = LinkedList<Char>()
        var max = 0
        var count = 0
        for (c in s) {
            if (c == '(') {
                stack.push(c)
            } else {
                if (stack.isNotEmpty()) {
                    count++
                    max = maxOf(count * 2, max)
                    stack.pop()
                } else {
                    count = 0
                }
            }
        }
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, longestValidParentheses("(()"))
        assertEquals(4, longestValidParentheses(")()())"))
        assertEquals(2, longestValidParentheses("()(()"))
    }
}