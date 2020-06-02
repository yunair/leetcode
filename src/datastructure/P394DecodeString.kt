package datastructure

import java.lang.StringBuilder
import java.util.*
import kotlin.test.assertEquals

/**
 * 字符串解码
 */
object P394DecodeString {
    fun decodeString(s: String): String {
        val stack = LinkedList<Char>()
        for (c in s) {
            if (c == ']') {
                val sb = StringBuilder()
                while (stack.peek() != '[') {
                    sb.append(stack.pop())
                }
                // 扔掉[
                stack.pop()
                val countStr = StringBuilder()
                while (stack.isNotEmpty() && stack.peek().isDigit()) {
                    countStr.insert(0, stack.pop())
                }
                val count = Integer.valueOf(countStr.toString())

                val str = sb.reverse()
                for (i in 1..count) {
                    for (char in str) {
                        stack.push(char)
                    }
                }
            } else {
                stack.push(c)
            }
        }
        val ans = StringBuilder()
        while (stack.isNotEmpty()) {
            ans.insert(0, stack.pop())
        }
        return ans.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"))
        assertEquals("accaccacc", decodeString("3[a2[c]]"))
        assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"))
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode",
            decodeString("100[leetcode]")
        )
    }

}