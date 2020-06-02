package datastructure.str

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 验证回文字符串 Ⅱ
 */
object P680ValidPalindrome {
    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            if (s[left] != s[right]) {
                return isValid(s, left + 1, right) || isValid(s, left, right - 1)
            }
            left++
            right--
        }

        return true
    }

    private fun isValid(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue { validPalindrome("aba") }
        assertTrue { validPalindrome("abca") }
        assertFalse { validPalindrome("eeccccbebaeeabebccceea") }
        assertTrue { validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga") }
    }
}