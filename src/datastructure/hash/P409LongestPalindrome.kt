package datastructure.hash

import kotlin.test.assertEquals

/**
 * 最长回文串
 */
object P409LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        var count = 0
        for (entry in map) {
            count += if (entry.value and 1 == 0) {
                entry.value
            } else {
                entry.value - 1
            }
        }
        return if (count < s.length) {
            count + 1
        } else {
            count
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(7, longestPalindrome("abccccdd"))
        assertEquals(9, longestPalindrome("abbbccccdd"))
        assertEquals(2, longestPalindrome("bb"))
    }
}