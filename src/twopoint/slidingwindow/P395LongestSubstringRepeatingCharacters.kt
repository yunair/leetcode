package twopoint.slidingwindow

import kotlin.test.assertEquals

/**
 * 至少有K个重复字符的最长子串
 */
object P395LongestSubstringRepeatingCharacters {
    /**
    分治：对于一个字符串来说，如果要求子串最少出现k次，那么如果某些字母出现的次数小于k,
    这些字母一定不会出现在最长的子串中，并且这些字母将整个字符子串分割成小段，这些小段有可能是最长的
    但是由于被分割了，还是要检查这一小段，如果某些字母出现的次数小于k,会将小段继续分割下去,
    比如字符串"aacbbbdc"，要求最少出现2次,我们记录左右闭区间，
    第一轮[0,7]，处理"aacbbbdc"，d只出现了一次不满足，于是递归解决区间[0,5]、[7,7]
    第二轮[0,5]，处理"aacbbb"，  c只出现了一次不满足，于是递归解决区间[0,1]、[3,4]
    第二轮[7,7]，处理"c"，       c只出现了一次不满足，不继续递归
    第三轮[0,1]，处理"aa"，      满足出现次数>=2,ret=2
    第三轮[3,4]，处理"aaa"，     满足出现次数>=2 ret=3;
     */
    fun longestSubstring(s: String, k: Int): Int {
        if (k <= 1) {
            return s.length
        }
        if (s.isEmpty() || s.length < k) {
            return 0
        }

        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        var i = 0
        while (i < s.length && map[s[i]]!! >= k) {
            i++
        }
        if (i == s.length) {
            return s.length
        }
        val l = longestSubstring(s.substring(0, i), k)
        while (i < s.length && map[s[i]]!! < k) {
            i++
        }
        val r = longestSubstring(s.substring(i), k)
        return maxOf(l, r)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, longestSubstring("aaabb", 3))
        assertEquals(5, longestSubstring("ababbc", 2))
    }
}