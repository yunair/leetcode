package dp.sellsock

import kotlin.test.assertEquals

/**
 * 买卖股票的最佳时机
 *
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
object P112BestTimeToBuyAndSellSock2 {
    /**
     * 状态转移公式 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var max = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] < min) {
                min = prices[i]
            }
            max = maxOf(max, prices[i] - min)
        }
        return max

    }


    @JvmStatic
    fun main(args: Array<String>) {
        assertEquals(
            5,
            maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
        )
        assertEquals(
            0,
            maxProfit(intArrayOf(7, 6, 4, 3, 1))
        )
        assertEquals(
            6,
            maxProfit(intArrayOf(1, 2, 7, 3, 1))
        )
        assertEquals(
            5,
            maxProfit(intArrayOf(5, 2, 7, 1, 4))
        )
    }
}