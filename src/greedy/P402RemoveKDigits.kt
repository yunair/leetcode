package greedy

import java.lang.StringBuilder
import java.util.*
import kotlin.test.assertEquals

/**
 * 移掉K位数字
 */
object P402RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {
        if (k == num.length) {
            return "0"
        }
        if (k == 0) {
            return num
        }
        val chars = num.toCharArray()
        var removedCount = k
        val stack = LinkedList<Char>()

        for (c in chars) {
            while (stack.isNotEmpty() && stack.peek() > c && removedCount > 0) {
                removedCount--
                stack.pop()
            }

            if (!(stack.isEmpty() && c == '0')) {
                stack.push(c)
            }
        }

        while (removedCount > 0) {
            stack.pop()
            removedCount--
        }
        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.insert(0, stack.pop())
        }
        if (sb.isEmpty()) {
            return "0"
        }
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("1219", removeKdigits("1432219", 3))
        assertEquals("0", removeKdigits("100", 3))
        assertEquals("200", removeKdigits("10200", 1))
        assertEquals("0", removeKdigits("10", 1))
        assertEquals("11", removeKdigits("112", 1))
        assertEquals("0", removeKdigits("1230", 3))
        assertEquals("0", removeKdigits("1234567890", 9))
    }
}