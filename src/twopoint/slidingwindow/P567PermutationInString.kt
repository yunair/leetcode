package twopoint.slidingwindow

import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * 字符串的排列
 */
object P567PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val needs = mutableMapOf<Char, Int>()
        for (c in s1) {
            needs[c] = needs.getOrDefault(c, 0) + 1
        }
        val window = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var match = 0
        while (right < s2.length) {
            val c1 = s2[right]
            right++
            if (!needs.containsKey(c1)) {
                continue
            }
            window[c1] = window.getOrDefault(c1, 0) + 1
            if (window[c1] == needs[c1]) {
                match++
            }
            while (match == needs.size) {
                if (right - left == s1.length) {
                    return true
                }
                val c2 = s2[left]
                if (needs.containsKey(c2)) {
                    window[c2] = window.getOrDefault(c2, 0) - 1
                    if (window[c2]!! < needs[c2]!!) {
                        match--
                    }
                }
                left++
            }

        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertTrue(checkInclusion("ab", "eidbaooo"))
        assertFalse(checkInclusion("ab", "eidboaoo"))
    }
}