package doublepoint

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
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }
        val set = mutableSetOf<Char>()
        var preIndex = 1
        var postIndex = 0
        var maxCount = 1
        var count = 1
        set.add(s[0])
        while (preIndex < s.length) {
            count++
            // 存在，删除相同元素之前的元素
            if (set.contains(s[preIndex])) {
                // 处理重复的
                while (postIndex < preIndex && s[postIndex] != s[preIndex]) {
                    set.remove(s[postIndex])
                    postIndex++
                    count--
                }
                // 找到相等的下一个
                postIndex++
                count--
            }

            if (count > maxCount) {
                maxCount = count
            }
            set.add(s[preIndex])
            preIndex++

        }

        return maxCount
    }

    fun lengthOfLongestSubstringSlidingWindow(s: String): Int {
        val n = s.length
        val set: MutableSet<Char> = HashSet()
        var ans = 0
        var i = 0
        var j = 0
        while (i < n && j < n) { // try to extend the range [i, j]
            if (!set.contains(s[j])) {
                set.add(s[j++])
                ans = maxOf(ans, j - i)
            } else {
                set.remove(s[i++])
            }
        }
        return ans
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(1, lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
        assertEquals(3, lengthOfLongestSubstring("pwwkew"))
        assertEquals(2, lengthOfLongestSubstring("aab"))
        assertEquals(3, lengthOfLongestSubstring("dvdf"))
        assertEquals(5, lengthOfLongestSubstring("tmmzuxt"))
        assertEquals(3, lengthOfLongestSubstring("aabaab!bb"))
    }
}