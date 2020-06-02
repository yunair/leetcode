package stack

import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 比较含退格的字符串
 */
object P844BackspaceString {
    fun backspaceCompare(s: String, t: String): Boolean {
        return build(s) == build(t)
    }

    private fun build(s: String): String {
        val stackS = LinkedList<Char>()
        for (c in s) {
            if (c == '#') {
                if (stackS.isNotEmpty()) {
                    stackS.pop()
                }
            } else {
                stackS.push(c)
            }
        }
        return stackS.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(backspaceCompare("ab#c", "ad#c"))
        assertTrue(backspaceCompare("ab##", "c#d#"))
        assertTrue(backspaceCompare("a##c", "#a#c"))
        assertFalse(backspaceCompare("a#c", "b"))
        assertTrue(backspaceCompare("xywrrmp", "xywrrmu#p"))
    }
}