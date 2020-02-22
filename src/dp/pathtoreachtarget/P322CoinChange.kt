package dp

import kotlin.math.min

/**
 * 零钱兑换
 */
object P322CoinChange {
    private val map = mutableMapOf<Int, Int>()
    /**
     * 自顶向下
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        return dp(coins, amount)
    }

    private fun dp(coins: IntArray, amount: Int): Int {
        if (map.containsKey(amount)) {
            return map[amount]!!
        }
        if (amount == 0) {
            return 0
        }
        if (amount < 0) {
            return -1
        }
        var res = Int.MAX_VALUE
        for (coin in coins) {
            val sub = dp(coins, amount - coin)
            if (sub == -1) {
                continue
            }
            res = min(res, sub + 1)
        }

        val result = if (res == Int.MAX_VALUE) {
            -1
        } else {
            res
        }
        // 记备忘录
        map[amount] = result
        return map[amount]!!
    }

    /**
     * 迭代解法
     *
     * dp[i] = x 表示当目标金额为 i 时，至少需要 x 枚硬币
     */
    fun coinChangeIter(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { amount + 1 }
        memo[0] = 0
        // f[1], f[2], ...f[amount]
        for (i in 1..amount) {
            for (coin in coins) {
                if (i - coin < 0) {
                    continue
                }
                memo[i] = min(memo[i], 1 + memo[i - coin])
            }
        }
        if (memo[amount] == amount + 1) {
            return -1
        }
        return memo[amount]
    }
}

fun main() {
    println(P322CoinChange.coinChange(intArrayOf(2), 3))
}