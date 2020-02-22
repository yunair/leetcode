package dp

import kotlin.test.assertEquals

/**
 * 不同路径
 */
object P62UniquePaths {
    /**
     * f[i,j] = f[i-1,j] + f[i, j-1]
     */
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(n) {
            IntArray(m) { 1 }
        }
        for (i in 1 until n) {
            for (j in 1 until m) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }


        return dp[n - 1][m - 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(3, uniquePaths(3, 2))
        assertEquals(28, uniquePaths(7, 3))
    }
}