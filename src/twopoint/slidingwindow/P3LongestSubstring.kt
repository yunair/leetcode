package twopoint.slidingwindow

import java.util.*
import kotlin.test.assertEquals


/**
 * 无重复字符的最长子串
 */
object P3LongestSubstring {
    /**
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
     * 例如，我们将 [i, j) 向右滑动 1 个元素，
     * 则它将变为 [i+1, j+1)（左闭，右开）。
     */
    fun lengthOfLongestSubstringBF(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }
        val set = mutableSetOf<Char>()
        var right = 1
        var left = 0
        var maxCount = 1
        var count = 1
        set.add(s[0])
        while (right < s.length) {
            count++
            // 存在，删除相同元素之前的元素
            if (set.contains(s[right])) {
                // 处理重复的
                while (left < right && s[left] != s[right]) {
                    set.remove(s[left])
                    left++
                    count--
                }
                // 找到相等的下一个
                left++
                count--
            }

            if (count > maxCount) {
                maxCount = count
            }
            set.add(s[right])
            right++

        }

        return maxCount
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var left = 0
        var right = 0
        var res = 0
        val map = mutableMapOf<Char, Int>()
        while (right < n) {
            val c1 = s[right]
            map[c1] = map.getOrDefault(c1, 0) + 1
            right++
            // 找到重复了，删左边
            while (map[c1]!! > 1) {
                val c2 = s[left]
                map[c2] = map.getOrDefault(c2, 0) - 1
                left++
            }
            res = maxOf(res, right - left)
        }
        return res
    }

    fun lengthOfLongestSubstringSlidingWindow(s: String): Int {
        val n = s.length
        val set: MutableSet<Char> = HashSet()
        var ans = 0
        var left = 0
        var right = 0
        while (left < n && right < n) { // try to extend the range [left, right]
            if (!set.contains(s[right])) {
                set.add(s[right++])
                ans = maxOf(ans, right - left)
            } else {
                set.remove(s[left++])
            }
        }
        return ans
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1,
            lengthOfLongestSubstring("bbbbb")
        )
        assertEquals(3,
            lengthOfLongestSubstring("abcabcbb")
        )
        assertEquals(3,
            lengthOfLongestSubstring("pwwkew")
        )
        assertEquals(2, lengthOfLongestSubstring("aab"))
        assertEquals(3, lengthOfLongestSubstring("dvdf"))
        assertEquals(5,
            lengthOfLongestSubstring("tmmzuxt")
        )
        assertEquals(3,
            lengthOfLongestSubstring("aabaab!bb")
        )
    }
}