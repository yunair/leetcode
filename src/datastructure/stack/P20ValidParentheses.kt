package datastructure.stack

import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 有效的括号
 */
object P20ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }

        val stack = LinkedList<Char>()
        for (c in s) {
            if (c in charArrayOf(')', ']', '}')) {
                if (stack.isEmpty()) {
                    return false
                }
                val left = stack.pop()
                if (c == ']') {
                    if (left == '[') {
                        continue
                    } else {
                        return false
                    }
                } else if (c == ')') {
                    if (left == '(') {
                        continue
                    } else {
                        return false
                    }
                } else if (c == '}') {
                    if (left == '{') {
                        continue
                    } else {
                        return false
                    }
                }
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }

    fun isValidWithMap(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        val map = mutableMapOf<Char, Char>()
        map[')'] = '('
        map[']'] = '['
        map['}'] = '{'

        val stack = LinkedList<Char>()
        for (c in s) {
            if(map.containsKey(c)){
                if (stack.isEmpty()) {
                    return false
                }
                val left = stack.pop()
                if (map[c]!! != left) {
                    return false
                }
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(isValidWithMap("()[]{}"))
        assertTrue(isValidWithMap(""))
        assertTrue(isValidWithMap("{[]}"))
        assertFalse(isValidWithMap("(]"))
        assertFalse(isValidWithMap("([)]"))
        assertFalse(isValidWithMap("]"))
    }
}