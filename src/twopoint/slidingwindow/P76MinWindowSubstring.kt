package twopoint.slidingwindow

import kotlin.test.assertEquals

/**
 * 最小覆盖子串
 */
object P76MinWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val n = s.length
        var left = 0
        var right = 0
        var start = 0
        var minLen = Int.MAX_VALUE
        var match = 0
        val needs = mutableMapOf<Char, Int>()
        for (c in t) {
            needs[c] = needs.getOrDefault(c, 0) + 1
        }
        val window = mutableMapOf<Char, Int>()
        while (right < n) {
            val c1 = s[right]
            right++
            if (!needs.containsKey(c1)) {
                continue
            }
            window[c1] = window.getOrDefault(c1, 0) + 1
            if (window[c1] == needs[c1]) {
                match++
            }

            while (match == needs.size) {
                if (right - left < minLen) {
                    // 更新最小字串的位置和长度
                    start = left
                    minLen = right - left
                }

                val c2 = s[left]
                left++
                if (needs.containsKey(c2)) {
                    window[c2] = window.getOrDefault(c2, 0) - 1
                    if (window[c2]!! < needs[c2]!!) {
                        match--
                    }
                }

            }

        }
        return if (minLen == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(start, start + minLen)
        }
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"))
        assertEquals("", minWindow("a", "aa"))
        assertEquals("abbbbbcdd", minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"))
    }
}