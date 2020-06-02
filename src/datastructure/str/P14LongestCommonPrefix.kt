package datastructure.str

import kotlin.test.assertEquals

/**
 * 最长公共前缀
 */
object P14LongestCommonPrefix {
    /**
     * 一个单词一个单词扫描
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        var prefix = strs[0]
        for (i in 1 until strs.size) {
            if (prefix.isEmpty()) {
                return ""
            }
            val str = strs[i]
            val len = minOf(prefix.length, str.length)
            for (j in 0 until len) {
                if (prefix[j] != str[j]) {
                    prefix = prefix.substring(0, j)
                    break
                }
            }
            if (prefix.length > str.length) {
                prefix = str
            }
        }
        return prefix
    }

    /**
     * 一次扫一个所有单词的某个位置字母
     */
    fun longestCommonPrefixByChar(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        for (i in strs[0].indices) {
            val c = strs[0][i]
            for (j in 1 until strs.size) {
                val str = strs[j]
                if (i == str.length || str[i] != c) {
                    return strs[0].substring(0, i)
                }
            }

        }
        return strs[0]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals("fl", longestCommonPrefixByChar(arrayOf("flower", "flow", "flight")))
        assertEquals("", longestCommonPrefixByChar(arrayOf("dog", "racecar", "car")))
        assertEquals("a", longestCommonPrefixByChar(arrayOf("aa", "a")))
    }
}