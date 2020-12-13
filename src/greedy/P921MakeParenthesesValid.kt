package greedy

import java.util.*
import kotlin.test.assertEquals

/**
 * 使括号有效的最少添加
 */
object P921MakeParenthesesValid {
    fun minAddToMakeValid(s: String): Int {
        val stack = LinkedList<Char>()
        for (c in s) {
            if(c != ')'){
                stack.push(c)
            } else {
                if (stack.peek() == '(') {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
        }
        return stack.size
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(0, minAddToMakeValid("()"))
        assertEquals(4, minAddToMakeValid("()))(("))
        assertEquals(3, minAddToMakeValid("((("))
        assertEquals(1, minAddToMakeValid("())"))
    }
}