package interview

import kotlin.test.assertEquals

/**
 * 硬币
 */
object Coin {
    /**
     * dp[i][j]含义为
     */
    fun waysToChangeDp(n: Int): Int {
        val dp = Array(coins.size) { IntArray(n + 1) }
        TODO()
    }

    val coins = intArrayOf(25, 10, 5, 1)
    val memo = mutableMapOf<Pair<Int, Int>, Int/*几次*/>()
    fun waysToChange(n: Int): Int {
        return dfs(n, 0)
    }

    /**
     * 先换最大的
     */
    private fun dfs(n: Int, start: Int): Int {
        if (memo.containsKey(Pair(n, start))) {
            return memo[Pair(n, start)]!!
        }
        if (n == 0) {
            return 1
        }
        if (n < 0 || start == coins.size) {
            return 0
        }
        var res = 0
        for (i in start until coins.size) {
            val remain = n - coins[i]
            if (remain >= 0) {
                res += if (memo.containsKey(Pair(remain, i))) {
                    memo[Pair(remain, i)]!!
                } else {
                    dfs(remain, i)
                }
            }
        }
        // 选或者不选
        memo[Pair(n, start)] = res
        return res % 1000000007
    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(2, waysToChange(5))
        assertEquals(4, waysToChange(10))
    }
}