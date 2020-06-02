package datastructure

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 判断子序列
 */
object P392SubSequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
            }
            j++
        }
        return i == s.length
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(isSubsequence("abc", "ahbgdc"))
        assertFalse(isSubsequence("axc", "ahbgdc"))
    }
}