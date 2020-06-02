package datastructure

import java.util.*
import kotlin.test.assertEquals

/**
 * 逆波兰表达式求值
 */
object P150EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<Int>()
        for (token in tokens) {
            if (token !in arrayOf("+", "-", "*", "/")) {
                stack.push(Integer.valueOf(token))
                continue
            }
            val v1 = stack.pop()
            val v2 = stack.pop()
            val v = when (token) {
                "+" -> {
                    v1 + v2
                }
                "-" -> {
                    v2 - v1
                }
                "*" -> {
                    v1 * v2
                }
                else -> {
                    v2 / v1
                }
            }
            stack.push(v)
        }

        return stack.pop()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(9, evalRPN(arrayOf("2", "1", "+", "3", "*")))
        assertEquals(6, evalRPN(arrayOf("4", "13", "5", "/", "+")))
        assertEquals(22, evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
    }
}