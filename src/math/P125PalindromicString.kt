package math

import kotlin.test.assertEquals

/**
 * 验证回文串
 */
object P125PalindromicString {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty() || s.length == 1) {
            return true
        }

        var front = 0
        var end = s.length - 1
        while (front < end) {
            if (!s[front].isLetterOrDigit()) {
                front++
                continue
            }

            if (!s[end].isLetterOrDigit()) {
                end--
                continue
            }
            if (s[front].toLowerCase() != s[end].toLowerCase()) {
                return false
            }
            front++
            end--
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"))
        assertEquals(false, isPalindrome("race a car"))
    }
}