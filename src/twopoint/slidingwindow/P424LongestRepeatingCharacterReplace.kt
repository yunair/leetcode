package twopoint.slidingwindow

import kotlin.test.assertEquals

/**
 * 替换后的最长重复字符
 */
object P424LongestRepeatingCharacterReplace {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var right = 0
        var max = 0
        var ans = 0
        val alpha = IntArray(26)
        while (right < s.length) {
            val index = s[right] - 'A'
            alpha[index]++
            // 保存滑动窗口内相同字母出现次数的历史最大值
            max = maxOf(max, alpha[index])
            if (right - left + 1 > k + max) {
                //需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
                alpha[s[left] - 'A']--
                // 缩小窗口
                left++
            }
            ans = maxOf(ans, right - left + 1)
            right++
        }
        return ans
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(
            4,
            characterReplacement(
                "ABAB",
                2
            )
        )
        assertEquals(
            4,
            characterReplacement(
                "ABAB",
                3
            )
        )
        assertEquals(
            4,
            characterReplacement(
                "AABABBA",
                1
            )
        )
    }
}