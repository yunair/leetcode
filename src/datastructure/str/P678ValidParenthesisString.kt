package other.str

import java.util.*

/**
 * 有效的括号字符串
 */
object P678ValidParenthesisString {
    fun checkValidString(s: String): Boolean {
        var id = 1
        val stackLeft = LinkedList<Int>()
        val stackAsterisk = LinkedList<Int>()
        for (c in s) {
            if (c == '(') {
                stackLeft.push(id)
                id++
            } else if (c == '*') {
                stackAsterisk.push(id)
                id++
            } else {
                if (stackLeft.isEmpty() && stackAsterisk.isEmpty()) {
                    return false
                }
                if (stackLeft.isNotEmpty()) {
                    stackLeft.pop()
                } else {
                    stackAsterisk.pop()
                }
            }
        }

        // 两者都不空
        while (stackAsterisk.isNotEmpty() && stackLeft.isNotEmpty()) {
            val leftId = stackLeft.pop()
            val asteriskId = stackAsterisk.pop()
            if (leftId > asteriskId) {
                return false
            }
        }

        return stackLeft.isEmpty()
    }
}