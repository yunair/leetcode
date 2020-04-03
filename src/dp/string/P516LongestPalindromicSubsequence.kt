package dp.string

import kotlin.test.assertEquals

/**
 * 最长公共子序列
 */
object P1143LongestCommonSubsequence {
    /**
     * dp[i][j]定义：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]
     */
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) {
            IntArray(n + 1)
        }
        for (i in 0..m) {
            dp[i][0] = 0
        }
        for (j in 0..n) {
            dp[0][j] = 0
        }
        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    // 找到lcs，需要将i,j均往后移动
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[m][n]
    }

    private fun dpOvertime(text1: String, text2: String, i: Int, j: Int): Int {
        if (i == -1 || j == -1) {
            return 0
        }
        val key = "${i}#${j}"
        /* if (memo.containsKey(key)) {
             return memo[key]!!
         }*/
        return if (text1[i] == text2[j]) {
            val value =
                dpOvertime(text1, text2, i - 1, j - 1)
//            memo[key] = value + 1
            value + 1
        } else {
            maxOf(
                dpOvertime(text1, text2, i - 1, j),
                dpOvertime(text1, text2, i, j - 1)
            )
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3,
            longestCommonSubsequence("abcde", "ace")
        )
        assertEquals(3,
            longestCommonSubsequence("abc", "abc")
        )
        assertEquals(0,
            longestCommonSubsequence("abc", "def")
        )
        assertEquals(1,
            longestCommonSubsequence("psnw", "vozsh")
        )
        assertEquals(1,
            longestCommonSubsequence("bsbininm", "jmjkbkjkv")
        )
    }
}